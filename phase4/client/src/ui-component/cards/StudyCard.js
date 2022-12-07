import { Card, CardContent, Typography, CardActions, Button, Chip } from '@mui/material';
import { useNavigate } from 'react-router';
import styled from '@emotion/styled';

// {
//   "id": "number",
//   "name": "string",
//   "cur_participants": "number", // be calculated from participate table
//   "max_participants": "number",
//   "is_complete": "boolean",
//   "category": "string[]",
//   "start_date": "date",
//   "ledaer": "string" // name of the leader in the study
// },

const colors = ['info', 'primary', 'secondary'];

const StudyCard = (props) => {
  const navigate = useNavigate();

  const { data } = props;

  return (
    <CardWrapper idx={data.id} sx={{ minWidth: 275 }}>
      <CardContent>
        {/* categories */}
        {data.categories &&
          data.categories.map((category, index) => <Chip key={index} label={category} color={colors[index % 3]} sx={{ mr: 1, mb: 1 }} />)}

        {/* study number */}
        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
          Study#: {data.id || -1}
        </Typography>

        {/* study name */}
        <Typography variant="h2" component="div">
          {data.name || 'Default Study Name'}
        </Typography>

        {/* date */}
        <Typography sx={{ mb: 1.5 }} color="text.secondary">
          {data.start_date || '2022-11-26'}
        </Typography>

        {/* description */}
        <Typography variant="body2">{data.description || 'Default Description'}</Typography>
      </CardContent>
      {/* participants */}
      <CardActions>
        <Button size="small" onClick={() => navigate('/study/' + data.id)}>
          참여하기 ({data.cur_participants || -1} / {data.max_participants || -1})
        </Button>
      </CardActions>
    </CardWrapper>
  );
};

const CardWrapper = styled(Card)(({ theme }) => {
  // select random color from theme.palette
  let randomColor;
  switch (Math.floor(Math.random() * 3)) {
    case 0:
      randomColor = theme.palette.dark.main;
      break;
    case 1:
      randomColor = theme.palette.secondary.main;
      break;
    case 2:
      randomColor = theme.palette.info.main;
      break;
    default:
      randomColor = theme.palette.primary.main;
      break;
  }

  return {
    backgroundColor: theme.palette.secondary,
    color: '#fff',
    overflow: 'hidden',
    position: 'relative',
    '&:after': {
      content: '""',
      position: 'absolute',
      width: 210,
      height: 210,
      background: randomColor,
      borderRadius: '100%',
      top: -85,
      right: -95,
      [theme.breakpoints.down('sm')]: {
        top: -105,
        right: -140
      }
    },
    '&:before': {
      content: '""',
      position: 'absolute',
      width: 210,
      height: 210,
      background: randomColor,
      borderRadius: '50%',
      top: -125,
      right: -15,
      opacity: 0.5,
      [theme.breakpoints.down('sm')]: {
        top: -155,
        right: -70
      }
    }
  };
});

export default StudyCard;
