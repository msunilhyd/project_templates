import React, { useState, useEffect } from 'react';
import { Container, Grow, Grid } from '@material-ui/core';
import { useDispatch } from 'react-redux';

import { getVideos } from '../../../actions/sections';
import Videos from './Videos';
import useStyles from './styles';



const Culture = () => {
  const [currentId, setCurrentId] = useState(0);
  const dispatch = useDispatch();
  const classes = useStyles();

  useEffect(() => {
    dispatch(getVideos());
  }, [currentId, dispatch]);

  return (
    <Grow in>
      <Container className = { classes.containerPrimary } maxWidth = "lg">
        <Grid container justify="space-between" alignItems="stretch" spacing={3} >
            <Videos setCurrentId={setCurrentId} />          
        </Grid>
      </Container>
    </Grow>
  );
};

export default Culture;