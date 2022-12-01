import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Landing from "./routes/Landing";
import Login from "./routes/Login";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Landing />} />
        <Route path="/login" element={<Login />} />
        {/* signup */}
        {/* study main */}
        {/* study detail */}
        {/* study create */}
        {/* mypage */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
