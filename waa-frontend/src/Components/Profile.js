import React from "react";
import { Formik, Field } from "formik";
import * as yup from "yup";
import { Button, Grid, TextField, Stack, Avatar } from "@mui/material";
import { useLocation } from "react-router-dom";

const validationSchema = yup.object().shape({
  email: yup
    .string("Enter your email")
    .email("Enter a valid email")
    .required("Email is required"),
  password: yup
    .string("Enter your password")
    .min(8, "Password should be of minimum 8 characters length")
    .required("Password is required"),
});

const Profile = (props) => {
  const location = useLocation();
  return (
    <Formik
      initialValues={{
        email: "",
        password: "",
      }}
      validationSchema={validationSchema}
      onSubmit={(values) => {
        alert(JSON.stringify(values, null, 2));
      }}
    >
      {({ errors, touched }) => (
        <div
          style={{
            border: "1px solid #e4e4e4",
            padding: "30px",
            paddingTop: "1px",
            width: "50vh",
            height: "auto",
          }}
        >
          <div
            style={{
              display: "flex",
              justifyContent: "center",
              margin: "10px",
            }}
          >
            <Stack direction="row" spacing={2}>
              <Avatar
                src="/broken-image.jpg"
                sx={{ width: "70px", height: "70px" }}
              />
            </Stack>
          </div>
          <form>
            <Grid container direction={"column"} spacing={5}>
              <Grid item>
                <Field
                  id="firstName"
                  name="firstName"
                  render={({ field }) => (
                    <TextField
                      fullWidth
                      label="First Name"
                      {...field}
                      value={location.state?.firstName}
                    />
                  )}
                  variant="outlined"
                  margin="dense"
                />
                {errors.firstName && touched.firstName ? (
                  <div style={{ color: "red" }}>{errors.firstName}</div>
                ) : null}
              </Grid>
              <Grid item>
                <Field
                  id="lastName"
                  name="lastName"
                  render={({ field }) => (
                    <TextField
                      fullWidth
                      label="Last Name"
                      {...field}
                      value={location.state?.lastName}
                    />
                  )}
                  variant="outlined"
                  margin="dense"
                />
                {errors.lastName && touched.lastName ? (
                  <div style={{ color: "red" }}>{errors.lastName}</div>
                ) : null}
              </Grid>
              <Grid item>
                <Field
                  id="email"
                  name="email"
                  render={({ field }) => (
                    <TextField
                      fullWidth
                      label="Email"
                      {...field}
                      value={location.state?.email}
                    />
                  )}
                  variant="outlined"
                  margin="dense"
                />
                {errors.email && touched.email ? (
                  <div style={{ color: "red" }}>{errors.email}</div>
                ) : null}
              </Grid>
              <Grid item>
                <Button
                  color="primary"
                  variant="contained"
                  fullWidth
                  type="submit"
                >
                  Save
                </Button>
              </Grid>
            </Grid>
          </form>
        </div>
      )}
    </Formik>
  );
};

export default Profile;
