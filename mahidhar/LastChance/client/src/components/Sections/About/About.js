import React, { useState } from 'react';
import Grid from '@material-ui/core/Grid';
import Avatar from '@material-ui/core/Avatar';
import { ExpansionPanelDetails, Typography } from '@material-ui/core';
import Paper from '@material-ui/core/Paper';

import Divider from '@material-ui/core/Divider';



import useStyles from './styles';
import Schools from './Schools';



const About = () => {
  const classes = useStyles();
  
  


  

  return (
        <Grid container justify="space-between" alignItems="stretch" spacing={3} >
            <Grid className = {classes.grid} item xs={12} sm={5}>
                <Paper>
                    <div className= {classes.root} varaint = "outlined">
                        <Avatar className = {classes.avatar}>MR</Avatar>
                        <div className= {classes.secondary}>
                            <Typography variant="h4" spacing > Sai Mahidhar Reddy Illuri </Typography>
                            <Typography variant="caption" display="block" spacing gutterBottom>Software Engineer</Typography>
                        </div>                        
                    </div>  
                    <Typography className = {classes.education} variant = "h4"> Education </Typography>
                    <Divider />
                    <Schools/>
                              
                </Paper>
            </Grid>
                <Grid item xs={12} sm={7}>
                        <Paper >
                            <h1> Projects & Works </h1>
                            
                        </Paper>
                </Grid>
        </Grid>

     

  );
}

export default About;