import * as React from 'react';
import Typography from '@mui/material/Typography';
import Grid from '@mui/material/Grid';
import { FormControl, InputAdornment, InputLabel, OutlinedInput, TextField } from '@mui/material';
import { useDispatch, useSelector } from 'react-redux';
import { studyAction } from 'store/studyReducer';

export default function Review() {
  const dispatch = useDispatch();
  const studyCreateParams = useSelector((state) => state.studyReducer.studyCreateParams);
  const handleChangeParticipationFee = (e) =>
    dispatch(studyAction.setStudyCreateParams({ ...studyCreateParams, participation_fee: e.target.value }));
  const handleChangeMaxAbsentTimes = (e) =>
    dispatch(studyAction.setStudyCreateParams({ ...studyCreateParams, max_absent_time: e.target.value }));
  const handleChangeMaxParticipants = (e) =>
    dispatch(studyAction.setStudyCreateParams({ ...studyCreateParams, max_participants: e.target.value }));
  const handleChangeDescription = (e) => dispatch(studyAction.setStudyCreateParams({ ...studyCreateParams, description: e.target.value }));
  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        기타 설정
      </Typography>
      <Grid container spacing={3}>
        <Grid item xs={12}>
          <FormControl fullWidth sx={{ m: 1 }}>
            <InputLabel htmlFor="participation_fee">참가비</InputLabel>
            <OutlinedInput
              id="participation_fee"
              value={studyCreateParams.participation_fee}
              onChange={handleChangeParticipationFee}
              startAdornment={<InputAdornment position="end">₩</InputAdornment>}
              label="참가비"
            />
          </FormControl>
        </Grid>
        <Grid item xs={12}>
          <FormControl fullWidth sx={{ m: 1 }}>
            <InputLabel htmlFor="max_absent_time">총 허용 결석</InputLabel>
            <OutlinedInput
              id="max_absent_time"
              value={studyCreateParams.max_absent_time}
              onChange={handleChangeMaxAbsentTimes}
              label="총 허용 결석"
            />
          </FormControl>
        </Grid>
        <Grid item xs={12}>
          <FormControl fullWidth sx={{ m: 1 }}>
            <InputLabel htmlFor="max_participants">총 참여자 수</InputLabel>
            <OutlinedInput
              id="max_participants"
              value={studyCreateParams.max_participants}
              onChange={handleChangeMaxParticipants}
              label="총 참여자 수"
            />
          </FormControl>
        </Grid>
        <Grid item xs={12}>
          <FormControl fullWidth sx={{ m: 1 }}>
            <InputLabel htmlFor="description">스터디 설명</InputLabel>
            <OutlinedInput id="description" value={studyCreateParams.description} onChange={handleChangeDescription} label="스터디 설명" />
          </FormControl>
        </Grid>
      </Grid>
    </React.Fragment>
  );
}
