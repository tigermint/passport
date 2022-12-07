import { AppBar, Button, Card, CardContent, Chip, Grid, Toolbar, Typography } from '@mui/material';
import { useTheme } from '@emotion/react';
import SessionCard from 'ui-component/cards/SessionCard';
import SessionModal from 'ui-component/SessionModal';
import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useEffect } from 'react';
import { studyAction } from 'store/studyReducer';
import { apiGetStudyDetail, apiPostParticipateStudy } from 'apis/study';
import { useParams } from 'react-router';

const Lorem = `t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy.`;

const StudyDetailPage = () => {
  const theme = useTheme();
  const [open, setOpen] = React.useState(false);

  const { study__id } = useParams();
  const dispatch = useDispatch();

  const user = useSelector((state) => state.userReducer.user);
  const { studyListDTO: studyInfo, sessions } = useSelector((state) => state.studyReducer.studyDetail);

  useEffect(() => {
    apiGetStudyDetail({ study__id: study__id }, { user__id: user.id }, (studyDetail) => {
      dispatch(studyAction.setStudyDetail(studyDetail));
    });
  }, []);

  function handleClose() {
    setOpen(false);
  }

  async function handleClickParticipation(event) {
    event.preventDefault();

    const result = await apiPostParticipateStudy(
      {
        study__id: study__id,
        user__id: user.id
      },
      () => window.location.reload()
    );
    if (result) alert('스터디 참여 성공!');
    else alert('스터디 참여 실패!');
  }

  return (
    <>
      <AppBar
        position="absolute"
        style={{ backgroundColor: theme.palette.secondary['800'] }}
        // elevation={0}
        sx={{
          zIndex: 0,
          position: 'relative',
          borderBottom: (t) => `1px solid ${t.palette.divider}`,
          borderRadius: 2,
          marginBottom: 2
        }}
      >
        <Toolbar style={{ display: 'flex', justifyContent: 'space-between' }}>
          <div style={{ display: 'flex', flexDirection: 'column' }}>
            <Typography variant="h6" color="inherit" noWrap>
              스터디 상세 페이지
            </Typography>
            <Typography variant="h2" color="inherit" noWrap>
              {studyInfo.name || 'Default Study Name'}
            </Typography>
            {/* categories using mui chip component */}
            <div style={{ display: 'flex', flexDirection: 'row', gap: '1rem', marginTop: '0.5rem' }}>
              {studyInfo.category?.map((category) => (
                <Chip color="primary" label={category} />
              ))}
            </div>
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
            <Button
              onClick={handleClickParticipation}
              disabled={studyInfo.isParticipating === 'true'}
              variant="contained"
              color="secondary"
            >
              {studyInfo.isParticipating === 'true' ? '참여중' : '참여하기'}
            </Button>
            <Typography variant="h4" color="inherit" mt={2} noWrap>
              ({studyInfo.cur_participants || -1} / {studyInfo.max_participants || -1})
            </Typography>
          </div>
        </Toolbar>
      </AppBar>

      <Grid container xs={12} rowSpacing={3} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
        <Grid item xs={9}>
          <Card sx={{ minWidth: 275 }}>
            <CardContent>
              <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                스터디 시작일
              </Typography>
              <Typography variant="h5" component="div">
                {studyInfo.start_date || '2022-11-26'}
              </Typography>
              <br />
              <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                스터디 설명
              </Typography>
              <Typography variant="h5" component="div">
                {studyInfo.description || Lorem}
              </Typography>
            </CardContent>
          </Card>
        </Grid>
        <Grid item sx={{ minWidth: 275 }} xs={3}>
          <Card sx={{ minWidth: 275 }}>
            <CardContent>
              <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                스터디 위치
              </Typography>
              <Typography variant="h5" component="div">
                {studyInfo.location || 'Default Location'}
              </Typography>
              <br />

              <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                최대 결석 횟수
              </Typography>
              <Typography variant="h5" component="div">
                {studyInfo.max_absent_time || -1}
              </Typography>
              <br />
              <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                참가비 💵
              </Typography>
              <Typography variant="h5" component="div">
                {studyInfo.participation_fee || -1}
              </Typography>
            </CardContent>
          </Card>
        </Grid>
      </Grid>
      <Grid mt={1} container spacing={2}>
        {sessions?.map((session) => (
          <Grid item xs={6}>
            <SessionCard
              data={session}
              clickHandler={() => {
                // get session data from server
              }}
              setOpenModal={setOpen}
            />
          </Grid>
        ))}
      </Grid>
      <SessionModal studyInfo={studyInfo} open={open} onClose={handleClose} />
    </>
  );
};

export default StudyDetailPage;
