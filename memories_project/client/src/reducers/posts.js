export default (posts = [], action) => {
    switch(action.type) {
        case 'UPDATE':
            return posts.map((post) => post._id == action.payload._id ? action.payload : post);
        case 'FETCH_ALL':
            console.log('FETCH_ALL at reducers');
            return action.payload;
        case 'CREATE':
            console.log('CREATE at reducers');
            return [ ...posts, action.payload ];
        default:
            return posts;        
    }
}