import * as React from 'react';
import PropTypes from 'prop-types';
import Avatar from '@mui/material/Avatar';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemText from '@mui/material/ListItemText';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import UncheckedIcon from '@mui/icons-material/RadioButtonUnchecked';
import CheckedIcon from '@mui/icons-material/CheckCircleOutline';
import { blue } from '@mui/material/colors';
import { DialogContent, DialogContentText } from '@mui/material';
import { useSelector } from 'react-redux';

export default function SessionModal(props) {
  let { onClose, open, data } = props;
  data = { attendants: [{ user_name: 'abc', isIn: 'true' }] };
  const handleClose = () => {
    onClose();
  };

  const [attendantsDummyData, setAttendantsDummyData] = React.useState([
    {
      user_name: '이승열',
      isIn: false
    },
    {
      user_name: '이상민',
      isIn: false
    },
    {
      user_name: '홍희림',
      isIn: false
    }
  ]);

  const { studyListDTO: studyInfo } = useSelector((state) => state.studyReducer.studyDetail);

  const handleListItemClick = (value) => {
    // onClose(value);
    // console.log(value);
    if (value.user_name === '이승열') alert('세션 참여 성공!');
    setAttendantsDummyData([
      {
        user_name: '이승열',
        isIn: true
      },
      {
        user_name: '이상민',
        isIn: false
      },
      {
        user_name: '홍희림',
        isIn: false
      }
    ]);
  };

  return (
    <Dialog fullWidth={true} maxWidth={'xs'} onClose={handleClose} open={open}>
      {/* 스터디 이름, 세션 라운드, 세션 날짜 */}
      <DialogTitle>스터디 이름</DialogTitle>
      <DialogContent>
        <DialogContentText id="alert-dialog-description">{studyInfo.name || 'Default Study Name'}</DialogContentText>
      </DialogContent>
      <DialogTitle>세션 라운드</DialogTitle>
      <DialogContent>
        <DialogContentText id="alert-dialog-description">{studyInfo.round || '-1'}</DialogContentText>
      </DialogContent>
      <DialogTitle>세션 날짜</DialogTitle>
      <DialogContent>
        <DialogContentText id="alert-dialog-description">{studyInfo.date || '2022.11.26'}</DialogContentText>
      </DialogContent>
      <DialogTitle>출석 현황</DialogTitle>
      <List sx={{ pt: 0 }}>
        {attendantsDummyData.map((attendant) => (
          <ListItem button onClick={(e) => handleListItemClick(attendant)} key={attendant.user_name}>
            <ListItemAvatar>
              <Avatar sx={{ bgcolor: blue[100], color: blue[600] }}>{attendant.isIn === true ? <CheckedIcon /> : <UncheckedIcon />}</Avatar>
            </ListItemAvatar>
            <ListItemText primary={attendant.user_name} />
          </ListItem>
        ))}
      </List>
    </Dialog>
  );
}

SessionModal.propTypes = {
  onClose: PropTypes.func.isRequired,
  open: PropTypes.bool.isRequired,
  data: PropTypes.object.isRequired
};
