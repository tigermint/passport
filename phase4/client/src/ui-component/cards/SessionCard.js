import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';

export default function SessionCard(props) {
  function clickHandler() {
    props.setOpenModal(true);
    props.getStudySessionDetail();
  }

  const { data } = props;

  return (
    <Card sx={{ minWidth: 200 }}>
      <CardContent>
        <div style={{ display: 'flex', flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' }}>
          <Typography style={{ cursor: 'pointer' }} onClick={clickHandler} sx={{ fontSize: '1.3rem', fontWeight: 'bold' }}>
            #{data.round || '-1'}
          </Typography>
          <Typography>{data.date || '2022-11-26'}</Typography>
          {/* <Typography>{'참가자: ' + (data.session_attendants || -1) + ' / ' + (data.cur_participants || -1)}</Typography> */}
          <Typography>{'참가자: ' + (data.attendants || -1)}</Typography>
        </div>
      </CardContent>
    </Card>
  );
}
