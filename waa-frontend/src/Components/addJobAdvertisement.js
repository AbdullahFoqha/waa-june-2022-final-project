import React, { useEffect, useState } from "react";
import { useFormik } from "formik";
import * as yup from "yup";
import { Autocomplete, Button, TextField, Grid } from "@mui/material";
import {
  addJobAdvertisement,
  getCities,
  getStates,
  getTags,
} from "../services/job";

const tags = [];
const states = [];
const cities = [];

const AddJobAdvertisement = () => {
  const [tagState, setTagState] = useState();
  const [stateState, setStateState] = useState();
  const [cityState, setCityState] = useState();
  const fetchData = async () => {
    const { data: tagsData } = await getTags();
    tagsData.map((x) => tags.push({ label: x.name, id: x.id }));
    setTagState(tags);
    const { data: statesData } = await getStates();
    statesData.map((x) => states.push({ label: x.name, id: x.id }));
    setStateState(states);
    const { data: citiesData } = await getCities();
    citiesData.map((x) => cities.push({ label: x.name, id: x.id }));
    setCityState(cities);
  };
  useEffect(() => {
    fetchData();
  }, []);
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
      onSubmit: async (values) => {
        values.tag = { ...tagState };
        values.state = { ...stateState };
        values.city = { ...cityState };
        await addJobAdvertisement(values);
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
                  setTagState(value);
                }}
                renderInput={(params) => (
                  <TextField
                    {...params}
                    id="tag"
                    name="tag"
                    label="tag"
                    //onChange={handleChange}
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
                  setStateState(value);
                }}
                renderInput={(params) => (
                  <TextField
                    {...params}
                    id="state"
                    name="state"
                    label="state"
                    // value={values?.state}
                    // onChange={handleChange}
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
                  //   console.log(value);
                  //   setFieldValue("cityId", value.value);
                  setCityState(value);
                }}
                renderInput={(params) => (
                  <TextField
                    {...params}
                    id="city"
                    name="city"
                    label="city"
                    //value={values?.city}
                    //onChange={handleChange}
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
                onClick={handleSubmit}
              >
                Save
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

export default AddJobAdvertisement;
