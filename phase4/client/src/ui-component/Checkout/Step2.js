import * as React from 'react';
import Grid from '@mui/material/Grid';
import TextField from '@mui/material/TextField';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { DatePicker, LocalizationProvider } from '@mui/lab';

export default function PaymentForm() {
  const [value, setValue] = React.useState(new Date());

  return (
    <React.Fragment>
      <Grid container spacing={3}>
        <Grid item xs={12} md={6}>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker
              label="스터디 시작일"
              value={value}
              onChange={(newValue) => {
                setValue(newValue);
              }}
              renderInput={(params) => <TextField {...params} />}
            />
          </LocalizationProvider>
        </Grid>
        <Grid item xs={12} md={6}>
          <TextField
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
