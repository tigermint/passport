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

export default function SessionModal(props) {
  let { onClose, open, data } = props;
  data = { attendants: [{ user_name: 'abc', isIn: 'true' }] };
  const handleClose = () => {
    onClose();
  };

  const handleListItemClick = (value) => {
    // onClose(value);
    // 만약 본인 계정이고 아직 체크를 하지 않았다면 체크를하고, 서버에 세션에 참여한다는 정보를 전송한다.
  };

  return (
    <Dialog fullWidth={true} maxWidth={'xs'} onClose={handleClose} open={open}>
      {/* 스터디 이름, 세션 라운드, 세션 날짜 */}
      <DialogTitle>스터디 이름</DialogTitle>
      <DialogContent>
        <DialogContentText id="alert-dialog-description">{data.name || 'Default Study Name'}</DialogContentText>
      </DialogContent>
      <DialogTitle>세션 라운드</DialogTitle>
      <DialogContent>
        <DialogContentText id="alert-dialog-description">{data.round || '-1'}</DialogContentText>
      </DialogContent>
      <DialogTitle>세션 날짜</DialogTitle>
      <DialogContent>
        <DialogContentText id="alert-dialog-description">{data.date_ || '2022.11.26'}</DialogContentText>
      </DialogContent>
      <DialogTitle>출석 현황</DialogTitle>
      <List sx={{ pt: 0 }}>
        {data?.attendants?.map((attendant) => (
          <ListItem button onClick={() => handleListItemClick(attendant)} key={attendant.user_name}>
            <ListItemAvatar>
              <Avatar sx={{ bgcolor: blue[100], color: blue[600] }}>
                {attendant.isIn === 'true' ? <CheckedIcon /> : <UncheckedIcon />}
              </Avatar>
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
