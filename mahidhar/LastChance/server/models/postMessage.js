import mongoose from 'mongoose';

const postSchema = mongoose.Schema({
    title: String,
    message: String,
    name: String,
    creator: String,
    tags: [String],
    image: String,
    likes: { type: [String], default: [] },
    createdAt: {
        type: Date,
        default: new Date(),
    },
    description: String,
    linkText: String,
    imgText: String, 
})

var PostMessage = mongoose.model('PostMessage', postSchema);

export default PostMessage;
