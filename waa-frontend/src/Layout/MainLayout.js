import { Box, AppBar, Toolbar, Button, Typography } from "@mui/material";
import { Outlet } from "react-router-dom";

const MainLayout = (props) => {
  return (
    <Box sx={{ display: "flex" }}>
      <AppBar>
        <Toolbar>
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="/"
            sx={{
              mr: 2,
              display: { xs: "none", md: "flex" },
              fontFamily: "monospace",
              fontWeight: 700,
              letterSpacing: ".3rem",
              color: "inherit",
              textDecoration: "none",
            }}
          >
            LOGO
          </Typography>
          <Typography
            variant="h6"
            component="a"
            href="/students"
            sx={{ flexGrow: 1, color: "inherit", textDecoration: "none" }}
          >
            Students
          </Typography>
          <Button color="inherit" href="/SignUp">
            Sign Up
          </Button>
          <Button color="inherit" href="/SignIn">
            Login
          </Button>
        </Toolbar>
      </AppBar>
      <div style={{ margin: "0 auto", marginTop: "100px" }}>
        <Outlet />
      </div>
    </Box>
  );
};

export default MainLayout;
