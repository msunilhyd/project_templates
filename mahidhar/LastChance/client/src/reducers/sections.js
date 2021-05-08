import { FETCH_ALL }  from '../constants/actionTypes';

export default (videos = [], action) => {
    switch (action.type) {
      case FETCH_ALL :
        return action.payload;
    default :
        return videos;

    }
};