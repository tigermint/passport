import { AppBar, Button, Grid, Toolbar, Typography } from '@mui/material';
import StudyCard from 'ui-component/cards/StudyCard';
import { useTheme } from '@emotion/react';
import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { studyAction } from 'store/studyReducer';
import { apiGetStudyList } from 'apis/study';
import { useNavigate } from 'react-router';

const StudyPage = () => {
  const theme = useTheme();
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const user = useSelector((state) => state.userReducer.user);
  if (!user) navigate('/login');

  const studyList = useSelector((state) => state.studyReducer.studyList);

  useEffect(() => {
    apiGetStudyList((studyList) => {
      dispatch(studyAction.setStudyList(studyList));
    });
  }, []);

  return (
    <>
      <AppBar
        position="absolute"
        style={{ backgroundColor: theme.palette.secondary[800] }}
        elevation={0}
        sx={{
          zIndex: 0,
          position: 'relative',
          borderBottom: (t) => `1px solid ${t.palette.divider}`,
          borderRadius: 2,
          marginBottom: 2
        }}
      >
        <Toolbar style={{ display: 'flex', justifyContent: 'space-between' }}>
          <Typography variant="h3" color="inherit" noWrap>
            스터디 리스트
          </Typography>
          <Button href="/study/create" variant="contained" color="secondary">
            스터디 생성
          </Button>
        </Toolbar>
      </AppBar>

      <Grid container rowSpacing={3} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
        {studyList.map((study) => (
          <Grid item xs={6}>
            <StudyCard data={study} />
          </Grid>
        ))}
      </Grid>
    </>
  );
};

export default StudyPage;
