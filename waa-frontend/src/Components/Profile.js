import { Button, Grid, TextField, Avatar, Stack } from "@mui/material";
import ReactDataTable from "./common/DataTable";
import { useEffect, useState } from "react";
import { useFormik } from "formik";
import { useKeycloak } from "@react-keycloak/web";
import { getStudentById } from "../services/student";
let profileData = {};
const Profile = () => {
  const {
    keycloak: {
      tokenParsed: { sub: studentId },
    },
  } = useKeycloak();
  const init = {
    firstName: "",
    lastName: "",
    state: "",
    city: "",
    email: "",
  };

  const [profileState, setProfileState] = useState(init);

  const fetchData = async () => {
    const { data } = await getStudentById(studentId);
    // setProfileState(data);
    profileData = { ...data };
  };

  useEffect(() => {
    fetchData();
  }, []);

  const { handleSubmit, values, handleChange } = useFormik({
    initialValues: { ...profileData },
    onSubmit: async (values) => {},
  });
  return (
    <div
      style={{
        border: "1px solid #e4e4e4",
        padding: "30px",
        paddingTop: "1px",
        width: "50vh",
        height: "auto",
      }}
    >
      <Stack direction="row" spacing={1}>
        <Avatar
          src="/broken-image.jpg"
          sx={{ width: "70px", height: "70px", margin: "auto" }}
        />
      </Stack>
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          margin: "10px",
        }}
      >
        <form onSubmit={handleSubmit}>
          <Grid container direction={"column"} spacing={4}>
            <Grid item>
              <TextField
                fullWidth
                id="firstName"
                name="firstName"
                label="firstName"
                type="firstName"
                value={values.firstName}
                onChange={handleChange}
              />
            </Grid>
            <Grid item>
              <TextField
                fullWidth
                id="lastName"
                name="lastName"
                label="lastName"
                type="lastName"
                value={values.lastName}
                onChange={handleChange}
              />
            </Grid>
            <Grid item>
              <TextField
                fullWidth
                id="state"
                name="state"
                label="state"
                type="state"
                value={values.state}
                onChange={handleChange}
              />
            </Grid>
            <Grid item>
              <TextField
                fullWidth
                id="city"
                name="city"
                label="city"
                type="city"
                value={values.city}
                onChange={handleChange}
              />
            </Grid>
            <Grid item>
              <TextField
                fullWidth
                id="email"
                name="email"
                label="email"
                type="email"
                value={values.email}
                onChange={handleChange}
              />
            </Grid>
            <Grid item>
              <Button
                color="primary"
                variant="contained"
                fullWidth
                type="submit"
                onClick={handleSubmit}
              >
                Save
              </Button>
            </Grid>
          </Grid>
        </form>
      </div>
    </div>
  );
};

export default Profile;
