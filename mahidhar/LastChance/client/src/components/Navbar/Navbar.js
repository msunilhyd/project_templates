import React, { useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import IconButton from '@material-ui/core/IconButton';
import SearchIcon from '@material-ui/icons/Search';
import { useHistory, useLocation, Link } from 'react-router-dom';
import { Typography, Toolbar, Avatar, Button } from '@material-ui/core';
import Backdrop from '@material-ui/core/Backdrop';
import { useDispatch } from 'react-redux';
import decode from 'jwt-decode';


import Section from '../Sections/sections';
import Form from '../Form/Form';
import useStyles from './styles';
import * as actionType from '../../constants/actionTypes';



const Navbar = (props) => {
  const classes = useStyles();
  const { title } = props;

  const [user, setUser] = useState(JSON.parse(localStorage.getItem('profile')));
  const [currentId, setCurrentId] = useState(0);

  const dispatch = useDispatch();
  const location = useLocation();
  const history = useHistory();

  const [open, setOpen] = useState(false);
  const handleClose = () => {
    setOpen(false);
  };
  const handleToggle = () => {
    setOpen(!open);
  };


  const logout = () => {
    dispatch({ type: actionType.LOGOUT });

    history.push('/auth');

    setUser(null);
  };
  useEffect(() => {
    const token = user?.token;

    if (token) {
      const decodedToken = decode(token);

      if (decodedToken.exp * 1000 < new Date().getTime()) logout();
    }

    setUser(JSON.parse(localStorage.getItem('profile')));
  }, [location]);


  return (
    <React.Fragment>
        <Toolbar className={classes.toolbar}>
          <Typography component={Link} to="/" className={classes.toolbarTitle} variant="h4" align="center">
              {title}
          </Typography>
          <IconButton>
            <SearchIcon />
          </IconButton>
          {user?.result ? (
          <Toolbar className={classes.profile}>
            <Avatar className={classes.purple} alt={user?.result.name} src={user?.result.imageUrl}>{user?.result.name.charAt(0)}</Avatar>
            <Typography className={classes.userName} variant="h8">{user?.result.name}</Typography>&nbsp;
            <Button classes = {classes.button} variant="outlined" color="primary" onClick={handleToggle}> Create Post </Button>
            <Backdrop className={classes.backdrop} open={open} onClick= {handleClose}><Form currentId={currentId} setCurrentId={setCurrentId} /> </Backdrop>
            <Button variant="contained" className={classes.logout} color="secondary" onClick={logout}>Logout</Button>
          </Toolbar>
        ) : (
              <Button component={Link} to="/auth" variant="contained" color="primary">Sign In</Button>
        )}
        
        </Toolbar> 
        <Section/>      

    </React.Fragment>
  );
}


Navbar.propTypes = {
  title: PropTypes.string,
};

export default Navbar ;
