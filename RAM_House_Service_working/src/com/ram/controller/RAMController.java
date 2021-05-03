package com.ram.controller;

import javax.servlet.annotation.*;
import com.ram.service.*;
import javax.servlet.*;

import com.ram.dao.ForceDAO;
import com.ram.dao.WorkDAO;
import com.ram.dto.*;
import java.io.*;
import javax.servlet.http.*;

@MultipartConfig(fileSizeThreshold = 2097152, maxFileSize = 10485760L, maxRequestSize = 20971520L)
public class RAMController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String action = request.getParameter("action");
        
        System.out.println("action is ==== " + action);
        
        if (action == null) {
            request.setAttribute("categories", (Object)new RAMService().getCategories());
            request.setAttribute("subcategories", (Object)new RAMService().getSubCategories());
            request.getRequestDispatcher("home.jsp").forward((ServletRequest)request, (ServletResponse)response);
            return;
        }
        if (action.equals("RAMController")) {
        	System.out.println("action is RAMController");
        }
        
        if (action.equals("user_home")) {
            request.setAttribute("categories", (Object)new RAMService().getCategories());
            request.setAttribute("subcategories", (Object)new RAMService().getSubCategories());
            final HttpSession session = request.getSession();
            final User user = (User)session.getAttribute("user");
            request.setAttribute("worksList", (Object)new RAMService().getActiveWorks(user.getId()));
            request.getRequestDispatcher("userhome.jsp").forward((ServletRequest)request, (ServletResponse)response);
            return;
        }
        if (action.equals("user_profile")) {
            final HttpSession session = request.getSession();
            final User user = (User)session.getAttribute("user");
            request.setAttribute("worksList", (Object)new RAMService().getActiveWorks(user.getId()));
            request.setAttribute("services", (Object)new RAMService().getServiceTypes());
            request.getRequestDispatcher("profile.jsp").forward((ServletRequest)request, (ServletResponse)response);
            return;
        }
        if (action.equals("logout")) {
            final HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            request.setAttribute("categories", (Object)new RAMService().getCategories());
            request.setAttribute("subcategories", (Object)new RAMService().getSubCategories());
            request.getRequestDispatcher("home.jsp").forward((ServletRequest)request, (ServletResponse)response);
            return;
        }
        if ( Integer.parseInt(action) > 100 && Integer.parseInt(action) < 200 ) {
            request.setAttribute("category", (Object)new RAMService().getCategory(Integer.parseInt(action)));
            request.setAttribute("subcategories", (Object)new RAMService().getSubCategories(Integer.parseInt(action)));
            request.getRequestDispatcher("subcategories.jsp").forward((ServletRequest)request, (ServletResponse)response);
        }
        if (Integer.parseInt(action) > 1000 && Integer.parseInt(action) < 2000) {
            final User user2 = (User)request.getSession().getAttribute("user");
            System.out.println("user2.getId is = " + user2.getId());
            request.setAttribute("subcategory", (Object)new RAMService().getSubCategory(Integer.parseInt(action)));
            request.setAttribute("services", (Object)new RAMService().getServiceTypes(Integer.parseInt(action)));
            request.setAttribute("addresslist", (Object)new RAMService().getAddressList(user2.getId()));
            request.getRequestDispatcher("services.jsp").forward((ServletRequest)request, (ServletResponse)response);
        }
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String action = request.getParameter("action");
//		String action = request.getServletPath();
                
        if ("Login As User".equalsIgnoreCase(action)) {
            final String email = request.getParameter("loginEmail");
            final String password = request.getParameter("loginPassword");
            final User user = new RAMService().loginUser(email, password);
            if (user != null) {
                final HttpSession session = request.getSession();
                session.setAttribute("user", (Object)user);
                if (new RAMService().getAddressList(user.getId()).size() == 0) {
                    request.getRequestDispatcher("address.jsp").forward((ServletRequest)request, (ServletResponse)response);
                }
                request.setAttribute("categories", (Object)new RAMService().getCategories());
                request.setAttribute("subcategories", (Object)new RAMService().getSubCategories());
                request.getRequestDispatcher("userhome.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
            else {
                request.setAttribute("message", (Object)"Login Unsuccessful, you are not registered");
                request.getRequestDispatcher("home.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
        }
        
        else if ("Login As Force".equalsIgnoreCase(action)) {
            final String email = request.getParameter("loginEmail");
            final String password = request.getParameter("loginPassword");
            final Force force = new RAMService().loginForce(email, password);
            
            System.out.println("force in db is = " + force);
            
            if (force != null) {
                request.getSession().setAttribute("force", (Object)force);
                request.setAttribute("categories", (Object)new RAMService().getCategories());
                request.setAttribute("subcategories", (Object)new RAMService().getSubCategories());
                request.setAttribute("services", (Object)new RAMService().getServiceTypes());
                request.setAttribute("skillsList", (Object)new RAMService().getSkillsList(force));
                request.setAttribute("works", (Object)new RAMService().getActiveWorks(force.getId()));
                
                request.getRequestDispatcher("forcehome.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
            else {
                request.setAttribute("message", (Object)"Login Unsuccessful");
                request.getRequestDispatcher("home.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
        }
        else if ("signUpUser".equalsIgnoreCase(action)) {
            User user2 = new User();
            user2.setName(request.getParameter("uname"));
            user2.setPassword(request.getParameter("upwd"));
            user2.setEmailId(request.getParameter("uemail"));
            user2.setMobileNumber(Long.parseLong(request.getParameter("phone")));
            user2 = new RAMService().registerUser(user2);
            if (user2 != null) {
                request.setAttribute("message", (Object)"Congrats.....Welcome");
                request.getSession().setAttribute("user", (Object)user2);
                request.getRequestDispatcher("address.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
            else {
                request.setAttribute("message", (Object)"Registration Unsuccessful. Email or Password already existing");
                request.getRequestDispatcher("home.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
        }
        else if ("signUpForce".equalsIgnoreCase(action)) {
            final String saveDir = "uploadFiles";
            Force force2 = new Force();
            force2.setName(request.getParameter("fname"));
            force2.setPassword(request.getParameter("fpwd"));
            force2.setEmailId(request.getParameter("femail"));
            force2.setMobileNumber(Long.parseLong(request.getParameter("fphone")));
            System.out.println(request.getPart("file"));
            final String fileName = String.valueOf(request.getParameter("fname")) + "_" + request.getParameter("fphone") + ".jpg";
            System.out.println(fileName);
            force2.setAadharImage(fileName);
            force2 = new RAMService().registerForce(force2);
            if (force2 != null) {
                this.imageUpload(request, fileName, saveDir);
                request.getSession().setAttribute("force", (Object)force2);
                request.setAttribute("message", (Object)"Registration done successfully!");
                request.getRequestDispatcher("home.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
            else {
                request.setAttribute("message", (Object)"Registration Unsuccessful !");
                request.getRequestDispatcher("home.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
        }
        else if (action.equalsIgnoreCase("add_address")) {
            Address address = new Address();
            final User user3 = (User)request.getSession().getAttribute("user");
            address.setDoorno(request.getParameter("address1"));
            address.setStreet(request.getParameter("address2"));
            address.setCity(request.getParameter("city"));
            address.setState(request.getParameter("state"));
            address.setPostalCode(request.getParameter("zip"));
            address.setUserId(user3.getId());
            address = new RAMService().addAddress(address);
            if (address != null) {
                request.setAttribute("message", (Object)"Address added");
                request.setAttribute("categories", (Object)new RAMService().getCategories());
                request.getRequestDispatcher("userhome.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
            else {
                request.setAttribute("message", (Object)"Address not added. Try again");
                request.getRequestDispatcher("address.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
        }
        
        else if (action.equals("confirmation")) {
            final Work work = new Work();
            final User user3 = (User)request.getSession().getAttribute("user");
            work.setPostedBy(user3);
            final ServiceType serviceType2 = new RAMService().getServiceType(Integer.parseInt(request.getParameter("id")));
            work.setService(serviceType2);
            work.setDescription(request.getParameter("description"));
            final Address address2 = new Address();
            address2.setId(Integer.parseInt(request.getParameter("addressid")));
            work.setAddress(address2);
            if (new RAMService().addAWork(work)) {
                request.setAttribute("message", (Object)"Work Posted Successfully");
                request.setAttribute("categories", (Object)new RAMService().getCategories());
                request.setAttribute("subcategories", (Object)new RAMService().getSubCategories());
                request.setAttribute("works", (Object)new RAMService().getActiveWorks(user3.getId()));
               request.getRequestDispatcher("userhome.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
        }
        else if (action.equals("accepting")) {
        	System.out.println("Came to accepting in RAMController");
            final int workid = Integer.parseInt(request.getParameter("workid"));

            if (new WorkDAO().changeStatus(workid)) {
            	System.out.println("Updated work with workId = " + workid);
            	request.setAttribute("message", "Skill added Successfully");
				request.setAttribute("categories", new RAMService().getCategories());
				request.setAttribute("subcategories", new RAMService().getSubCategories());
				request.setAttribute("services", new RAMService().getServiceTypes());
				request.setAttribute("works", new RAMService().getActiveWorks(1234));
				request.getRequestDispatcher("forcehome.jsp").forward(request, response);
			
            }
        }
}
    
    private void imageUpload(final HttpServletRequest request, final String fname, final String saveDir) throws ServletException, IOException {
        final String savePath = "D:/tswork/RAM/WebContent/" + saveDir;
        final File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        final Part part = request.getPart("file");
        String fileName = this.extractFileName(part);
        fileName = new File(fileName).getName();
        System.out.println(fileName);
        part.write(String.valueOf(savePath) + "/" + fname);
    }
    
    private String extractFileName(final Part part) {
        final String contentDisp = part.getHeader("content-disposition");
        final String[] items = contentDisp.split(";");
        String[] array;
        for (int length = (array = items).length, i = 0; i < length; ++i) {
            final String s = array[i];
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}