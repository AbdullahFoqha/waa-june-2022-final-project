import { lazy } from "react";
import { Navigate } from "react-router-dom";
import JobsAdvertisements from "../components/JobsAdvertisements";
import MainLayout from "../layout/MainLayout";

const Signup = lazy(() => import("../components/SignUp"));
const Signin = lazy(() => import("../components/SignIn"));
const Profile = lazy(() => import("../components/Profile"));
const StudentsData = lazy(() => import("../components/Students"));

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
      path: "/JobsAdvertisements",
      element: <JobsAdvertisements />,
    },
    {
      path: "*",
      element: <Navigate to="/" replace />,
    },
  ],
};

export default MainRoutes;
