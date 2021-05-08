import { makeStyles } from '@material-ui/core/styles';


export default makeStyles((theme) => ({

  avatar: {
    height: theme.spacing(24),
    width: theme.spacing(24),
  },

  root: {
    display: 'flex',
    padding: theme.spacing(1),

  },
  secondary: {
    padding: theme.spacing(2),

  },
  
  name:{
    marginTop: theme.spacing(0),
    marginLeft: theme.spacing(6),
  },
  
  control: {
    padding: theme.spacing(2),
  },
  listRoot: {
    width: '100%',
    maxWidth: 550,
    backgroundColor: theme.palette.background.paper,
    marginRight: 0,
  },
  image :{
    marginTop : theme.spacing(1),
    marginRight: theme.spacing(2),
  },
  education :{
    padding : theme.spacing(1)

  },
  grid :{
    marginTop : theme.spacing(2)
  }
  
  
  
}));
