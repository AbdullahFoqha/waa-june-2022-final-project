import { Box } from "@mui/material";
import { Outlet } from "react-router-dom";

const AuthLayout = (props) => {
  return (
    <Box sx={{ display: "flex" }}>
      <div style={{ margin: "0 auto" }}>
        <Outlet />
      </div>
    </Box>
  );
};

export default AuthLayout;
