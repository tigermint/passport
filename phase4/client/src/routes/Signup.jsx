import * as React from "react";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import PassportLogo from "../assets/PassportLogo.png";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { Checkbox, FormControlLabel } from "@mui/material";

export default function SignIn() {
  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    console.log({
      email: data.get("email"),
      password: data.get("password"),
    });
  };

  return (
    <Container component="main" maxWidth="xs">
      <Box
        sx={{
          marginTop: 8,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <img src={PassportLogo} alt="" style={{ width: "400px" }} />
        <Typography component="h1" variant="h5">
          회원가입
        </Typography>
        <Box component="form" onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                autoFocus
                required
                fullWidth
                id="name"
                label="이름"
                name="name"
                autoComplete="name"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="school_email"
                label="학교 이메일"
                name="school_email"
                autoComplete="email"
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                name="bank_name"
                required
                fullWidth
                id="bank_name"
                label="은행 이름"
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                required
                fullWidth
                id="bank_account"
                label="계좌 번호"
                name="bank_account"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="password"
                label="비밀번호"
                type="password"
                id="password"
                autoComplete="new-password"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="password_check"
                label="비밀번호 확인"
                type="password"
                id="password_check"
                autoComplete="new-password"
              />
            </Grid>
            <Grid item xs={12}>
              <FormControlLabel
                control={<Checkbox color="primary" />}
                label="저는 스터디에 열심히 참여하겠습니다."
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2 }}
          >
            Sign Up
          </Button>
          <Grid container justifyContent="flex-end">
            <Grid item>
              <Link href="login" variant="body2" style={{ color: "black" }}>
                이미 아이디가 있으신가요?
              </Link>
            </Grid>
          </Grid>
        </Box>
      </Box>
      <TeamIntoduction sx={{ mt: 8, mb: 4 }} />
    </Container>
  );
}

function TeamIntoduction(props) {
  return (
    <Typography
      variant="body2"
      color="text.secondary"
      align="center"
      {...props}
    >
      {"데이터베이스 프로젝트 6조 "}
      <br />
      <Link
        color="inherit"
        href="https://upload.wikimedia.org/wikipedia/commons/6/6b/Knuemblem00.jpg"
      >
        COMP0322-004
      </Link>
    </Typography>
  );
}
