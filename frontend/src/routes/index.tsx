import { Routes, Route } from "react-router-dom";
import Home from "../pages/Home";
const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      {/* <Route path="/about" element={<About />} /> */}

      {/* Routes con */}
      {/* <Route path="/dashboard/*" element={<DashboardRoutes />} /> */}
    </Routes>
  );
};

export default AppRoutes;
