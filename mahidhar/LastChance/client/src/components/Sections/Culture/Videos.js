import React from 'react';
import { Grid, CircularProgress, Card, CardMedia } from '@material-ui/core';
import { useSelector } from 'react-redux';

import useStyles from './styles';

const Videos = () => {
  const videos = useSelector((state) => state.videos);
  const classes = useStyles();

  return (
    !videos ? <CircularProgress /> : (
      <Grid className={classes.container} container alignItems="stretch" spacing={3}>
        {videos.items.map((video) => (
          <Grid key={videos.items.id} item xs={12} sm={6} md={6}>
            <Card videos={videos} id={videos.items.id} />
            <CardMedia className={classes.media} image={video.items.thumbnail || 'https://user-images.githubusercontent.com/194400/49531010-48dad180-f8b1-11e8-8d89-1e61320e1d82.png'} title={video.items.title} />

          </Grid>
        ))}
      </Grid>
    )
  );
};

export default Videos;