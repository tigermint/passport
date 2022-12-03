import { AppBar, Button, Grid, Toolbar, Typography } from '@mui/material';
import StudyCard from 'ui-component/cards/StudyCard';
import { useTheme } from '@emotion/react';

const SamplePage = () => {
  const theme = useTheme();
  return (
    <>
      <AppBar
        position="absolute"
        style={{ backgroundColor: theme.palette.secondary[800] }}
        elevation={0}
        sx={{
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
        <Grid item xs={6}>
          <StudyCard />
        </Grid>
      </Grid>
    </>
  );
};

export default SamplePage;
