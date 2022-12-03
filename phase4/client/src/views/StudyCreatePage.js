import { useTheme } from '@emotion/react';
import { AppBar, Button, Grid, Toolbar, Typography } from '@mui/material';
import Checkout from 'ui-component/Checkout/Checkout';

const SamplePage = () => {
  const theme = useTheme();
  return (
    <>
      <AppBar
        position="absolute"
        style={{ backgroundColor: theme.palette.primary['main'] }}
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
            스터디 생성하기
          </Typography>
        </Toolbar>
      </AppBar>
      <Checkout></Checkout>
    </>
  );
};

export default SamplePage;