import axios from "axios";
import keycloak from "../config/security/keycloak";

const client = axios.create({
  baseURL: "http://localhost:9090/api",
});

export default client;
