import React from "react";
import { useFormik } from "formik";
import * as yup from "yup";
import { Autocomplete, Button, TextField, Grid } from "@mui/material";

const validationSchema = yup.object({
  tag: yup.string("Select tag").required("Tag is required"),
  state: yup.string("Select tag").required("State is required"),
  city: yup.string("Select tag").required("City is required"),
  companyName: yup.string("Select tag").required("CompanyName is required"),
  description: yup.string("Select tag").required("Description is required"),
  benefits: yup.string("Select tag").required("Benefits is required"),
});

const AddJobAdvertisement = () => {
  const { errors, touched, handleSubmit, values, handleChange, setFieldValue } =
    useFormik({
      initialValues: {
        tag: "",
        state: "",
        city: "",
        companyName: "",
        description: "",
        benefits: "",
        file: "",
      },
      validationSchema: validationSchema,
      onSubmit: (values) => {
        alert(JSON.stringify(values, null, 2));
      },
    });

  return (
    <>
      <div
        style={{
          border: "1px solid #e4e4e4",
          padding: "20px",
          width: "auto",
        }}
      >
        <h2>Job Advertisement</h2>
        <form onSubmit={handleSubmit}>
          <Grid container direction={"column"} spacing={5}>
            <Grid item>
              <Autocomplete
                fullWidth
                disablePortal
                id="autocomplete-tag"
                options={tags}
                sx={{ width: 600 }}
                onChange={(event, value) => {
                  setFieldValue("tagId", value.value);
                }}
                renderInput={(params) => (
                  <TextField
                    {...params}
                    id="tag"
                    name="tag"
                    label="tag"
                    value={values?.tag}
                    onChange={handleChange}
                    error={touched.tag && Boolean(errors.tag)}
                    helperText={touched.tag && errors.tag}
                  />
                )}
              />
            </Grid>
            <Grid item>
              <Autocomplete
                fullWidth
                disablePortal
                id="autocomplete-state"
                options={states}
                sx={{ width: 600 }}
                onChange={(event, value) => {
                  setFieldValue("stateId", value.value);
                }}
                renderInput={(params) => (
                  <TextField
                    {...params}
                    id="state"
                    name="state"
                    label="state"
                    value={values?.state}
                    onChange={handleChange}
                    error={touched.state && Boolean(errors.state)}
                    helperText={touched.state && errors.state}
                  />
                )}
              />
            </Grid>
            <Grid item>
              <Autocomplete
                disablePortal
                id="autocomplete-city"
                options={cities}
                sx={{ width: 600 }}
                onChange={(event, value) => {
                  setFieldValue("cityId", value.value);
                }}
                renderInput={(params) => (
                  <TextField
                    {...params}
                    id="city"
                    name="city"
                    label="city"
                    value={values?.city}
                    onChange={handleChange}
                    error={touched.city && Boolean(errors.city)}
                    helperText={touched.city && errors.city}
                  />
                )}
              />
            </Grid>
            <Grid item>
              <TextField
                fullWidth
                id="companyName"
                name="companyName"
                label="companyName"
                type="companyName"
                value={values.companyName}
                onChange={handleChange}
                error={touched.companyName && Boolean(errors.companyName)}
                helperText={touched.companyName && errors.companyName}
              />
            </Grid>
            <Grid item>
              <TextField
                fullWidth
                id="description"
                name="description"
                label="description"
                type="description"
                value={values.description}
                onChange={handleChange}
                error={touched.description && Boolean(errors.description)}
                helperText={touched.description && errors.description}
              />
            </Grid>
            <Grid item>
              <TextField
                fullWidth
                id="benefits"
                name="benefits"
                label="benefits"
                type="benefits"
                value={values.benefits}
                onChange={handleChange}
                error={touched.benefits && Boolean(errors.benefits)}
                helperText={touched.benefits && errors.benefits}
              />
            </Grid>
            <Grid item>
              <Button
                color="primary"
                variant="contained"
                fullWidth
                type="submit"
              >
                Submit
              </Button>
            </Grid>
          </Grid>
        </form>
      </div>
      <br />
      <br />
    </>
  );
};

const tags = [
  { label: "SD", id: 0 },
  { label: "Illinois", id: 1 },
  { label: "Texas", id: 2 },
  { label: "Iowa", id: 3 },
];
const states = [
  { label: "California", id: 0 },
  { label: "Illinois", id: 1 },
  { label: "Texas", id: 2 },
  { label: "Iowa", id: 3 },
];
const cities = [
  { label: "California", id: 0 },
  { label: "Illinois", id: 1 },
  { label: "Texas", id: 2 },
  { label: "Iowa", id: 3 },
];

export default AddJobAdvertisement;
