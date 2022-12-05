import { AppBar, Button, Card, CardContent, Chip, Grid, Toolbar, Typography } from '@mui/material';
import { useTheme } from '@emotion/react';
import SessionCard from 'ui-component/cards/SessionCard';
import SessionModal from 'ui-component/SessionModal';
import React from 'react';

const Lorem = `t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy.`;

const SamplePage = () => {
  const theme = useTheme();
  const data = {};
  const [open, setOpen] = React.useState(true);

  function handleClose() {
    setOpen(false);
  }

  return (
    <>
      <AppBar
        position="absolute"
        style={{ backgroundColor: theme.palette.secondary['800'] }}
        // elevation={0}
        sx={{
          zIndex: 1,
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
            <Typography variant="h3" color="inherit" noWrap>
              {data.name || 'Default Study Name'}
            </Typography>
            {/* categories using mui chip component */}
            <div style={{ display: 'flex', flexDirection: 'row', gap: '1rem', marginTop: '0.5rem' }}>
              {data.categories?.map((category) => (
                <Chip color="primary" label={category} />
              ))}
            </div>
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
            <Button onClick={() => {}} variant="contained" color="secondary">
              참여하기
            </Button>
            <Typography variant="h4" color="inherit" mt={2} noWrap>
              ({data.cur_participants || -1} / {data.max_participants || -1})
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
                {data.start_date || '2022-11-26'}
              </Typography>
              <br />
              <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                스터디 설명
              </Typography>
              <Typography variant="h5" component="div">
                {data.description || Lorem}
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
                {data.location || 'Default Location'}
              </Typography>
              <br />

              <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                최대 결석 횟수
              </Typography>
              <Typography variant="h5" component="div">
                {data.max_absent_times || -1}
              </Typography>
              <br />
              <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                참가비 💵
              </Typography>
              <Typography variant="h5" component="div">
                {data.participation_fee || -1}
              </Typography>
            </CardContent>
          </Card>
        </Grid>
      </Grid>
      <Grid mt={1} container spacing={2}>
        <Grid item xs={6}>
          <SessionCard
            clickHandler={() => {
              // get session data from server
            }}
            setOpenModal={setOpen}
          />{' '}
        </Grid>{' '}
        <Grid item xs={6}>
          <SessionCard
            clickHandler={() => {
              // get session data from server
            }}
            setOpenModal={setOpen}
          />{' '}
        </Grid>
      </Grid>
      <SessionModal data={data} open={open} onClose={handleClose} />
    </>
  );
};

export default SamplePage;
