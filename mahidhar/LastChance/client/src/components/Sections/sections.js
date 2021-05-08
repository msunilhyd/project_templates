import React from 'react';

import { Toolbar, Link } from '@material-ui/core';

import useStyles from './styles';
import { withRouter } from 'react-router-dom';




const Sections = (props) => {

    const classes = useStyles();

    const sections = [
      { title: 'Technology', url: '/technology' },
      { title: 'Culture', url: '/culture' },
      { title: 'Business', url: '/business' },
      { title: 'Politics', url: '/politics' },
      { title: 'Opinion', url: '/opinion' },
      { title: 'Science', url: '/science' },
      { title: 'Health', url: '/health' },
      { title: 'Cinema', url: 'cinema' },
      { title: 'Travel', url: '/travel' },
      { title: 'About', url: '/about' },

    ];

    const { location } = props;

   if (location.pathname.match(/about/)){
    return null;
  }
  return (
    <Toolbar component="Sections" variant="dense" className={classes.toolbarSecondary}>
          {sections.map((section) => (
            <Link color="inherit" noWrap key={section.title} variant="body2" href={section.url} className={classes.toolbarLink}>
              {section.title}
            </Link>
          ))}
        </Toolbar>

  )
}
const Section = withRouter(Sections);

export default Section; 