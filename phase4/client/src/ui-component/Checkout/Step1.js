import * as React from 'react';
import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import { MenuItem } from '@mui/material';
import { useDispatch, useSelector } from 'react-redux';
import { studyAction } from 'store/studyReducer';
import { useEffect } from 'react';

const categories = [
  { value: '변리사', label: '변리사' },
  { value: '공인중개사', label: '공인중개사' },
  { value: '노무사', label: '노무사' },
  { value: '치위생사', label: '치위생사' },
  { value: '정보처리기사', label: '정보처리기사' },
  { value: '간호사', label: '간호사' },
  { value: '조산사', label: '조산사' },
  { value: '토목기사', label: '토목기사' },
  { value: '공인 세무사', label: '공인 세무사' },
  { value: '법무사', label: '법무사' },
  { value: '공인회계사', label: '공인회계사' }
];

export default function AddressForm() {
  const dispatch = useDispatch();
  const studyCreateParams = useSelector((state) => state.studyReducer.studyCreateParams);
  const handleChange1 = (e) => dispatch(studyAction.setStudyCreateParams({ ...studyCreateParams, category1: e.target.value }));
  const handleChange2 = (e) => dispatch(studyAction.setStudyCreateParams({ ...studyCreateParams, category2: e.target.value }));
  const handleChange3 = (e) => dispatch(studyAction.setStudyCreateParams({ ...studyCreateParams, category3: e.target.value }));
  const handleChangeName = (e) => dispatch(studyAction.setStudyCreateParams({ ...studyCreateParams, name: e.target.value }));
  const handleChangeLocation = (e) => dispatch(studyAction.setStudyCreateParams({ ...studyCreateParams, location: e.target.value }));

  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        스터디 기본정보
      </Typography>
      <Grid container spacing={3}>
        <Grid item xs={12}>
          <TextField
            value={studyCreateParams.name}
            onChange={handleChangeName}
            required
            id="name"
            name="name"
            label="스터디 이름"
            fullWidth
            variant="standard"
          />
        </Grid>
        <Grid item xs={12}>
          <TextField
            value={studyCreateParams.location}
            onChange={handleChangeLocation}
            required
            id="location"
            name="location"
            label="스터디 진행 장소"
            fullWidth
            variant="standard"
          />
        </Grid>
        <Grid item xs={4}>
          <TextField
            id="standard-select-currency"
            select
            label="첫번째 카테고리"
            value={studyCreateParams.category1}
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
            value={studyCreateParams.category2}
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
            value={studyCreateParams.category3}
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
