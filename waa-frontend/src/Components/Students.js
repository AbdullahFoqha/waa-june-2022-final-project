import { Grid, Button } from "@mui/material";
import ReactDataTable from "./DataTable";
import { getStudents } from "../services/student";
import { useEffect, useState } from "react";

const StudentsData = (props) => {
  const init = {
    firstName: "Yaser",
    lastName: "Alqasem",
    email: "yalqasem.miu.edu",
    major: "Software Engineer",
    gpa: "3.50",
  };
  const [lstStudents, setStudents] = useState([init]);

  useEffect(() => {
    const fetchData = async () => {
      await getStudents()(setStudents);
    };
    //fetchData();
  }, []);

  const columns = [
    { name: "First Name", selector: (row) => row.firstName },
    { name: "Last Name", selector: (row) => row.lastName },
    { name: "Email", selector: (row) => row.email },
    { name: "Major", selector: (row) => row.major },
    { name: "GPA", selector: (row) => row.gpa },
    {
      name: "Action",
      selector: (row) => (
        <Button color="primary" variant="contained" fullWidth type="button">
          Info
        </Button>
      ),
    },
  ];

  return (
    <Grid container>
      <Grid item md={12} width="100rem">
        <ReactDataTable data={lstStudents} columns={columns} />
      </Grid>
    </Grid>
  );
};

export default StudentsData;
