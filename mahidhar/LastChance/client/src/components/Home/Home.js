import React, { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import Grid from '@material-ui/core/Grid';
import Container from '@material-ui/core/Container';

import MainFeaturedPost from './MainFeaturedPost';
import FeaturedPost from './FeaturedPost';

import useStyles from './styles';



const mainFeaturedPost = {
  title: 'Title of a longer featured blog post',
  description:
    "Multiple lines of text that form the lede, informing new readers quickly and efficiently about what's most interesting in this post's contents.",
  image: 'https://source.unsplash.com/random',
  imgText: 'main image description',
  linkText: 'Continue reading…',
};

const featuredPosts = [
  {
    title: 'Featured post',
    date: 'Nov 12',
    description:
      'This is a wider card with supporting text below as a natural lead-in to additional content.',
    image: 'https://source.unsplash.com/random',
    imageText: 'Image Text',
  },
  {
    title: 'Post title',
    date: 'Nov 11',
    description:
      'This is a wider card with supporting text below as a natural lead-in to additional content.',
    image: 'https://source.unsplash.com/random',
    imageText: 'Image Text',
  },
];






const Home = () => {

 const classes = useStyles();



  return (
    <React.Fragment>
      <Container className = {classes.containerPrimary} maxWidth="lg">
          <MainFeaturedPost post = {mainFeaturedPost}/>
          <Grid container spacing={4}>
            {featuredPosts.map((post) => (
              <FeaturedPost key={post.title} post={post} />
            ))}
          </Grid>
      </Container>
    </React.Fragment>
  );
}

export default Home;