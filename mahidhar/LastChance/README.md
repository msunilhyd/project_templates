# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.\
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: [https://facebook.github.io/create-react-app/docs/code-splitting](https://facebook.github.io/create-react-app/docs/code-splitting)

### Analyzing the Bundle Size

This section has moved here: [https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size](https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size)

### Making a Progressive Web App

This section has moved here: [https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app](https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app)

### Advanced Configuration

This section has moved here: [https://facebook.github.io/create-react-app/docs/advanced-configuration](https://facebook.github.io/create-react-app/docs/advanced-configuration)

### Deployment

This section has moved here: [https://facebook.github.io/create-react-app/docs/deployment](https://facebook.github.io/create-react-app/docs/deployment)

### `npm run build` fails to minify

This section has moved here: [https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify](https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify)


####
Notes :

# LastChance
# LastChance
# LastChanceTue Mar 16 : 

	'bodyParser' is included in express itself from the latest version of node. No need to import again. call it from 'express'.
	
Wed Mar 17:

Steps for MERN stack application : 

1. Create client(React) and server(node) folders separately in the project. 

server : 

	1. Create the index file. 
	2. npm init -y to create the package file which is in .json format.
	3. Install the packages cors, express, mongoose and nodemon with npm. 
	4. Declare the "type" equals 'module' in package file for using import syntax in ES6 and change the 'start' value to 'nodemon index.js' to avoid restarting server every time for the changes made.
	5. Import express and call it as a method and call .json function which uses body-parser to send requests in json format to the middleware and .urlencoded to parse incoming requests with url encoded payloads and is also based on body-parser. 
	6. Intialize cors which is the Cross-Origin Resource Sharing standard that works by adding new HTTP headers that let servers describe which origins are permitted to read that information from a web browser. 
	7. connect to mongodb using mongoose.connect() in index file.
	8. create models folder and create the respective schema of the collections to be used in mongo db using mongoose and  call it using mongoose.model. 
	9. create Routes folder and declare routes for each of the requests made to the backend such as get, post, patch using express.router and pass the routes as arguments in .use function on express in index file.
	10. create controllers folder and add the backend functionality for all the calls made to the backend using the request-response model. 
	
client : 

	1. npx create-react-app ./ to create the basic structure of the react application. 
	2. Install axios, moment, react-file-base 64 redux and redux-thunk using npm. 
	3. The folder structure for all the components are created inside the src folder. 
	4. Create an index.js file and render the app by using ReactDOM.render() and create a redux store and pass in as an argument to the provider component.
	4. Create reusable 'components' folder in the src folder to implement the front-end using react, which has all the components in each separate folders and each component containing its own .js and styles. 
	5. App.js is the parent component of the application and the child components are passed in with their respective props declared. 
	6. Create index.js in src/api folder to implement the api calls to backend using axios which is an easy to use HTTP client.   
	7. To use redux, create 'reducers' which can be implemented by using switch statements for each of the 'actions'. The reducers are arrow functions which take state and action as the arguments and returns an action.payload. 
	8. Create 'action creators' which are async functions and dispatches (returns) a type and payload to be used by reducers.  
	9. Create reusable components in react in 'components' folder using react & react-redux hooks which are used to effectively access the state of the component.  