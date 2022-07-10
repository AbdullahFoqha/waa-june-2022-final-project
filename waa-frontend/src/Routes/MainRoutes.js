import { lazy } from "react";
import { Navigate } from "react-router-dom";
import MainLayout from "../Layout/MainLayout";

const Signup = lazy(() => import("../Components/SignUp"));
const Signin = lazy(() => import("../Components/SignIn"));
const Profile = lazy(() => import("../Components/Profile"));
const StudentsData = lazy(() => import("../Components/Students"));

const MainRoutes = {
  path: "/",
  element: <MainLayout />,
  children: [
    {
      path: "/SignUp",
      element: <Signup />,
    },
    {
      path: "/SignIn",
      element: <Signin />,
    },
    {
      path: "/Profile",
      element: <Profile />,
    },
    {
      path: "/Students",
      element: <StudentsData />,
    },
    {
      path: "*",
      element: <Navigate to="/" replace />,
    },
  ],
};

export default MainRoutes;
