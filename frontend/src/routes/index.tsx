import { Routes, Route } from "react-router-dom";
import Home from "../pages/Home";
import ResetPassword from "../pages/ResetPassword/ResetPassword";
const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/reset_password" element={<ResetPassword />} />
      {/* <Route path="/about" element={<About />} /> */}

      {/* Routes con */}
      {/* <Route path="/dashboard/*" element={<DashboardRoutes />} /> */}
    </Routes>
  );
};

export default AppRoutes;
