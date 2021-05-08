import { combineReducers } from 'redux';

import posts from './posts';
import auth from './auth';
import sections from './sections';


export default combineReducers ({ posts, auth, sections });