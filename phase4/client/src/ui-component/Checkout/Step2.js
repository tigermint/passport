import * as React from 'react';
import Grid from '@mui/material/Grid';
import TextField from '@mui/material/TextField';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { DatePicker, LocalizationProvider } from '@mui/lab';
import { useDispatch, useSelector } from 'react-redux';
import { studyAction } from 'store/studyReducer';

export default function PaymentForm() {
  const dispatch = useDispatch();
  const studyCreateParams = useSelector((state) => state.studyReducer.studyCreateParams);
  const handleChangeDate = (value) => dispatch(studyAction.setStudyCreateParams({ ...studyCreateParams, start_date: value }));
  const handleChangeSessionRound = (e) => dispatch(studyAction.setStudyCreateParams({ ...studyCreateParams, total_round: e.target.value }));

  return (
    <React.Fragment>
      <Grid container spacing={3}>
        <Grid item xs={12} md={6}>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker
              label="스터디 시작일"
              value={studyCreateParams.start_date}
              onChange={(newValue) => {
                handleChangeDate(newValue);
              }}
              renderInput={(params) => <TextField {...params} />}
            />
          </LocalizationProvider>
        </Grid>
        <Grid item xs={12} md={6}>
          <TextField
            value={studyCreateParams.total_round}
            onChange={handleChangeSessionRound}
            style={{ width: '100%' }}
            id="total_round"
            defaultValue="0"
            label="세션 진행 횟수"
            type="number"
            InputLabelProps={{
              shrink: true
            }}
          />
        </Grid>
      </Grid>
    </React.Fragment>
  );
}
