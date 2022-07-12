import React from "react";
import { AppBar, Box, Toolbar, Typography } from "@mui/material";
import AdbIcon from "@mui/icons-material/Adb";
import IconButton from "@mui/material/IconButton";
import Menu from "@mui/material/Menu";
import MenuItem from "@mui/material/MenuItem";
import Tooltip from "@mui/material/Tooltip";
import Avatar from "@mui/material/Avatar";
import { useKeycloak } from "@react-keycloak/web";
import RenderIf from "./common/RenderIf";
import { useNavigate } from "react-router-dom";

const pages = ["Students", "Jobs Advertisements"];
const pagesUrls = ["/AddJobAdvertisement", "/JobsAdvertisements"];
const settings = ["Profile"];
const settingsUrls = ["/profile"];

const NavBar = () => {
  const navigate = useNavigate();

  const {
    keycloak: { logout, login, tokenParsed, authenticated: isLoggedIn },
  } = useKeycloak();
  const [anchorElUser, setAnchorElUser] = React.useState(null);

  const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleCloseUserMenu = () => {
    setAnchorElUser(null);
  };

  return (
    <AppBar>
      <Toolbar>
        <AdbIcon sx={styles.icon} />
        <Typography
          variant="h6"
          noWrap
          component="a"
          onClick={() => navigate("/dashboard")}
          sx={[styles.logo, isLoggedIn ? { flexGrow: 0 } : { flexGrow: 1 }]}
        >
          LOGO
        </Typography>

        <RenderIf condition={isLoggedIn}>
          <Box sx={styles.navContainer}>
            {pages.map((page, index) => (
              <Typography
                key={page}
                component="a"
                onClick={() => navigate(pagesUrls[index])}
                sx={styles.navItem}
              >
                {page}
              </Typography>
            ))}
          </Box>

          <Box
            sx={{
              flexGrow: 0,
              display: "flex",
            }}
          >
            <Typography
              key={"name"}
              component="a"
              sx={[
                styles.navItem,
                {
                  marginRight: "1rem",
                  textTransform: "capitalize",
                },
              ]}
            >
              {tokenParsed?.given_name}
            </Typography>

            <Tooltip title="Open settings">
              <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
                <Avatar
                  alt={tokenParsed?.given_name}
                  src="/static/images/avatar/2.jpg"
                />
              </IconButton>
            </Tooltip>
            <Menu
              sx={{ mt: "45px" }}
              id="menu-appbar"
              anchorEl={anchorElUser}
              anchorOrigin={{
                vertical: "top",
                horizontal: "right",
              }}
              keepMounted
              transformOrigin={{
                vertical: "top",
                horizontal: "right",
              }}
              open={Boolean(anchorElUser)}
              onClose={handleCloseUserMenu}
            >
              {settings.map((setting, index) => (
                <MenuItem key={setting} onClick={handleCloseUserMenu}>
                  <Typography
                    component="a"
                    onClick={() => navigate(settingsUrls[index])}
                    textAlign="center"
                    sx={styles.settingsItem}
                  >
                    {setting}
                  </Typography>
                </MenuItem>
              ))}
              <MenuItem key={"logout"} onClick={() => logout()}>
                <Typography
                  component="a"
                  textAlign="center"
                  sx={styles.settingsItem}
                >
                  Logout
                </Typography>
              </MenuItem>
            </Menu>
          </Box>
        </RenderIf>

        <RenderIf condition={!isLoggedIn}>
          <Box
            sx={[
              styles.navContainer,
              {
                flexGrow: 0,
                alignItems: "center",
              },
            ]}
          >
            <Typography
              key={"signup"}
              component="a"
              sx={styles.navItem}
              onClick={() => navigate("./signup")}
            >
              Signup
            </Typography>
            <span style={{ marginInline: "1rem" }}>|</span>
            <Typography
              onClick={login}
              key={"login"}
              component="a"
              sx={styles.navItem}
            >
              Login
            </Typography>
          </Box>
        </RenderIf>
      </Toolbar>
    </AppBar>
  );
};

const styles = {
  logo: {
    cursor: "pointer",
    mr: 2,
    display: {
      xs: "none",
      md: "flex",
    },
    fontFamily: "monospace",
    fontWeight: 700,
    letterSpacing: ".3rem",
    color: "inherit",
    textDecoration: "none",
  },
  icon: {
    display: {
      xs: "none",
      md: "flex",
    },
    mr: 1,
  },
  box: {
    flexGrow: 1,
    display: {
      xs: "flex",
      md: "none",
    },
  },
  menu: {
    display: {
      xs: "block",
      md: "none",
    },
  },
  navContainer: {
    flexGrow: 1,
    display: {
      xs: "none",
      md: "flex",
    },
  },
  navItem: {
    cursor: "pointer",
    my: 2,
    flexGrow: 0.01,
    color: "white",
    display: "block",
    textDecoration: "none",
  },
  settingsItem: {
    cursor: "pointer",
    mt: 1,
    color: "black",
    display: "block",
    textDecoration: "none",
  },
};

export default NavBar;
