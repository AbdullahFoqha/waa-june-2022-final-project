import { lazy } from "react";
import { Navigate } from "react-router-dom";
import JobsAdvertisements from "../components/JobsAdvertisements";
import MainLayout from "../layout/MainLayout";
import Dashboard from "../components/Dashboard";

const Profile = lazy(() => import("../components/Profile"));
const StudentsData = lazy(() => import("../components/Students"));
const AddJobAdvertisement = lazy(() =>
  import("../components/addJobAdvertisement")
);

const MainRoutes = {
  path: "/",
  element: <MainLayout />,
  children: [
    {
      path: "/dashboard",
      element: <Dashboard />,
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
      path: "/AddJobAdvertisement",
      element: <AddJobAdvertisement />,
    },
    {
      path: "*",
      element: <Navigate to="/" replace />,
    },
  ],
};

export default MainRoutes;
