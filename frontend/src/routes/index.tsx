import { Routes, Route } from "react-router-dom";
import Home from "../pages/Home";
import LoginPage from "../pages/Login";
import NotFound from "../pages/NotFound";
import ForgotPasswordPage from "../pages/ForgotPassword";

const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/reset_password" element={<ForgotPasswordPage />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="*" element={<NotFound />} />
      {/* <Route path="/about" element={<About />} /> */}

      {/* Routes con */}
      {/* <Route path="/dashboard/*" element={<DashboardRoutes />} /> */}
    </Routes>
  );
};

export default AppRoutes;
