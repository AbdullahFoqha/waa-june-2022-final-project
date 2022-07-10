import { useRoutes } from "react-router-dom";
import AuthRoutes from "./AuthRoutes";
import MainRoutes from "./MainRoutes";

const Routes = () => {
  const ActiveRoutes = true ? MainRoutes : AuthRoutes;
  return useRoutes([ActiveRoutes]);
};

export default Routes;
