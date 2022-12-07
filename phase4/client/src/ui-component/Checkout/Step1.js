import * as React from 'react';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import { MenuItem } from '@mui/material';

const categories = [
  {
    value: '5급',
    label: '5급공무원'
  },
  {
    value: '7급',
    label: '7급공무원'
  },
  {
    value: '9급',
    label: '9급공무원'
  }
];

export default function AddressForm() {
  const [category1, setCategory1] = React.useState('');
  const [category2, setCategory2] = React.useState('');
  const [category3, setCategory3] = React.useState('');

  const handleChange1 = (event) => {
    setCategory1(event.target.value);
  };
  const handleChange2 = (event) => {
    setCategory2(event.target.value);
  };
  const handleChange3 = (event) => {
    setCategory3(event.target.value);
  };

  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        스터디 기본정보
      </Typography>
      <Grid container spacing={3}>
        <Grid item xs={12}>
          <TextField required id="name" name="name" label="스터디 이름" fullWidth variant="standard" />
        </Grid>
        <Grid item xs={12}>
          <TextField required id="location" name="location" label="스터디 진행 장소" fullWidth variant="standard" />
        </Grid>
        <Grid item xs={4}>
          <TextField
            id="standard-select-currency"
            select
            label="첫번째 카테고리"
            value={category1}
            onChange={handleChange1}
            helperText="첫번째 카테고리를 입력하세요"
            variant="standard"
          >
            {categories.map((option) => (
              <MenuItem key={option.value} value={option.value}>
                {option.label}
              </MenuItem>
            ))}
          </TextField>
        </Grid>
        <Grid item xs={4}>
          <TextField
            id="standard-select-currency"
            select
            label="두번째 카테고리"
            value={category2}
            onChange={handleChange2}
            helperText="두번째 카테고리를 입력하세요"
            variant="standard"
          >
            {categories.map((option) => (
              <MenuItem key={option.value} value={option.value}>
                {option.label}
              </MenuItem>
            ))}
          </TextField>
        </Grid>
        <Grid item xs={4}>
          <TextField
            id="standard-select-currency"
            select
            label="세번째 카테고리"
            value={category3}
            onChange={handleChange3}
            helperText="세번째 카테고리를 입력하세요"
            variant="standard"
          >
            {categories.map((option) => (
              <MenuItem key={option.value} value={option.value}>
                {option.label}
              </MenuItem>
            ))}
          </TextField>
        </Grid>
      </Grid>
    </React.Fragment>
  );
}
