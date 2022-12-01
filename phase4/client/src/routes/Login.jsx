import * as React from "react";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import PassportLogo from "../assets/PassportLogo.png";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";

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
          로그인
        </Typography>
        <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
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
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2 }}
          >
            login
          </Button>
          <Grid container>
            <Grid item xs>
              <Link href="#" variant="body2">
                비밀번호 찾기
              </Link>
            </Grid>
            <Grid item>
              <Link href="#" variant="body2">
                {"회원가입"}
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
