export default (posts = [], action) => {
    switch(action.type) {
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