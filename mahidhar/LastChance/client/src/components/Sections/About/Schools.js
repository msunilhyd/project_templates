import React  from 'react';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import ExpansionPanel from '@material-ui/core/ExpansionPanel';
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary';
import { ExpansionPanelDetails, Typography } from '@material-ui/core';
import Avatar from '@material-ui/core/Avatar';

import ubIcon from '../../../images/ubIcon.png';
import jntuLogo from '../../../images/jntuLogo.png';

import useStyles from './styles';




const Schools = () => {

    const classes = useStyles();


    const schools = [
    { university : 'University of Bridgeport', degree: "Master's in Computer Science", description: ' Lorem ipsum ...', logo : ubIcon, time : 'January 2018 - December 2019'},
    { university : 'Jawaharlal Nehru Technological University', degree: "Bachelor's in Electronics and Communications Engineering", description: 'Lorem Ipsum ...!!!', logo : jntuLogo, time: 'October 2013 - May 2017' }
]

return (
    <div>
        { schools.map((school) => {
        return (
            <ExpansionPanel defaultExpanded>
            <ExpansionPanelSummary expandIcon={<ExpandMoreIcon />} aria-label="Expand" >
            <Avatar className = {classes.image} src = {school.logo} />
            <div>
                <Typography color="textPrimary" variant="h6" > {school.university} </Typography>
                <Typography color="textSecondary" variant="subtitle"> {school.degree} </Typography>
            </div>
            </ExpansionPanelSummary>
            <ExpansionPanelDetails> {school.description} </ExpansionPanelDetails>
            </ExpansionPanel>                    
    )})}  

    </div>
     

);
}




export default Schools; 