import * as React from 'react';
import Typography from '@mui/material/Typography';
import Grid from '@mui/material/Grid';
import { FormControl, InputAdornment, InputLabel, OutlinedInput, TextField } from '@mui/material';

export default function Review() {
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
              value={1}
              onChange={() => {}}
              startAdornment={<InputAdornment position="end">₩</InputAdornment>}
              label="참가비"
            />
          </FormControl>
        </Grid>
        <Grid item xs={12}>
          <FormControl fullWidth sx={{ m: 1 }}>
            <InputLabel htmlFor="max_absent_time">총 허용 결석</InputLabel>
            <OutlinedInput id="max_absent_time" value={1} onChange={() => {}} label="총 허용 결석" />
          </FormControl>
        </Grid>
        <Grid item xs={12}>
          <FormControl fullWidth sx={{ m: 1 }}>
            <InputLabel htmlFor="max_participants">총 참여자 수</InputLabel>
            <OutlinedInput id="max_participants" value={1} onChange={() => {}} label="총 참여자 수" />
          </FormControl>
        </Grid>
      </Grid>
    </React.Fragment>
  );
}
