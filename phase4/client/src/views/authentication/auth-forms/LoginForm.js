import { useState } from 'react';
import { useSelector } from 'react-redux';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';

// material-ui
import { useTheme } from '@mui/material/styles';
import { Box, Button, Checkbox, Divider, FormControlLabel, FormHelperText, Grid, Stack, Typography, useMediaQuery } from '@mui/material';

// third party
import * as Yup from 'yup';

// project imports
import useScriptRef from 'hooks/useScriptRef';
import AnimateButton from 'ui-component/extended/AnimateButton';

import Google from 'assets/images/icons/social-google.svg';

// ============================|| FIREBASE - LOGIN ||============================ //

const FirebaseLogin = ({ ...others }) => {
    const theme = useTheme();
    const matchDownSM = useMediaQuery(theme.breakpoints.down('md'));
    const customization = useSelector((state) => state.customization);
    const [checked, setChecked] = useState(true);

    const googleHandler = async () => {
        console.error('Login');
    };

    const submitHandler = async () => {
        alert('login');
    };

    return (
        <>
            <Grid container direction="column" justifyContent="center" spacing={2}>
                <Grid item xs={12}>
                    <AnimateButton>
                        <Button
                            disableElevation
                            fullWidth
                            onClick={googleHandler}
                            size="large"
                            variant="outlined"
                            sx={{
                                color: 'grey.700',
                                backgroundColor: theme.palette.grey[50],
                                borderColor: theme.palette.grey[100]
                            }}
                        >
                            <Box sx={{ mr: { xs: 1, sm: 2, width: 20 } }}>
                                <img src={Google} alt="google" width={16} height={16} style={{ marginRight: matchDownSM ? 8 : 16 }} />
                            </Box>
                            Google 계정으로 회원가입
                        </Button>
                    </AnimateButton>
                </Grid>
                <Grid item xs={12}>
                    <Box
                        sx={{
                            alignItems: 'center',
                            display: 'flex'
                        }}
                    >
                        <Divider sx={{ flexGrow: 1 }} orientation="horizontal" />

                        <Button
                            variant="outlined"
                            sx={{
                                cursor: 'unset',
                                m: 2,
                                py: 0.5,
                                px: 7,
                                borderColor: `${theme.palette.grey[100]} !important`,
                                color: `${theme.palette.grey[900]}!important`,
                                fontWeight: 500,
                                borderRadius: `${customization.borderRadius}px`
                            }}
                            disableRipple
                            disabled
                        >
                            OR
                        </Button>

                        <Divider sx={{ flexGrow: 1 }} orientation="horizontal" />
                    </Box>
                </Grid>
                <Grid item xs={12} container alignItems="center" justifyContent="center">
                    <Box sx={{ mb: 2 }}>
                        <Typography variant="subtitle1">이메일로 로그인하기</Typography>
                    </Box>
                </Grid>
            </Grid>

            <form noValidate onSubmit={submitHandler} {...others}>
                <Box component="form" onSubmit={() => console.log('hi')} sx={{ mt: 1 }}>
                    <TextField
                        margin="normal"
                        required
                        fullWidth
                        id="email"
                        label="이메일을 입력해주세요"
                        name="email"
                        autoComplete="email"
                        autoFocus
                    />
                    <TextField
                        margin="normal"
                        required
                        fullWidth
                        name="password"
                        label="비밀번호를 입력해주세요"
                        type="password"
                        id="password"
                        autoComplete="current-password"
                    />
                    <Box sx={{ mt: 2, mb: 2 }}>
                        <AnimateButton>
                            <Button
                                disableElevation
                                disabled={false}
                                fullWidth
                                size="large"
                                type="submit"
                                variant="contained"
                                color="secondary"
                            >
                                Sign in
                            </Button>
                        </AnimateButton>
                    </Box>
                    <Grid container>
                        <Grid item xs>
                            <Link href="#" variant="body2" style={{ color: 'black' }}>
                                비밀번호 찾기
                            </Link>
                        </Grid>
                        <Grid item>
                            <Link href="signup" variant="body2" style={{ color: 'black' }}>
                                {'회원가입'}
                            </Link>
                        </Grid>
                    </Grid>
                </Box>
            </form>
        </>
    );
};

export default FirebaseLogin;
