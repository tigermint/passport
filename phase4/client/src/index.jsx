import React from "react";
import ReactDOM from "react-dom/client";
import CssBaseline from "@mui/material/CssBaseline";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import App from "./App";

const root = ReactDOM.createRoot(document.getElementById("root"));

const theme = createTheme({
  typography: {
    fontFamily: "S-CoreDream-3Light",
  },
  palette: {
    primary: {
      main: "#4ABBFA",
    },
    secondary: {
      main: "#edf2ff",
    },
  },
  components: {
    MuiCssBaseline: {
      styleOverrides: `
        @font-face {
          font-family: 'S-CoreDream-3Light';
          src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-3Light.woff') format('woff');
          font-weight: normal;
          font-style: normal;
        }
      `,
    },
  },
});

root.render(
  <React.StrictMode>
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <App />
    </ThemeProvider>
  </React.StrictMode>
);
