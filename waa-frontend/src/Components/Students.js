import { Grid, Button } from "@mui/material";
import ReactDataTable from "./common/DataTable";
import { getStudents } from "../services/student";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const StudentsData = (props) => {
  const init = [
    {
      firstName: "Yaser",
      lastName: "Alqasem",
      email: "yalqasem.miu.edu",
      major: "Software Engineer",
      gpa: "3.50",
    },
    {
      firstName: "Abdullah",
      lastName: "Alfoqha",
      email: "alfoqha.miu.edu",
      major: "Computer Science",
      gpa: "3.80",
    },
  ];
  const [lstStudents, setStudents] = useState(init);

  useEffect(() => {
    const fetchData = async () => {
      await getStudents()(setStudents);
    };
    //fetchData();
  }, []);

  let navigate = useNavigate();
  const handleClick = (row) => {
    navigate("/Profile", { state: row });
  };

  const columns = [
    { name: "First Name", selector: (row) => row.firstName },
    { name: "Last Name", selector: (row) => row.lastName },
    { name: "Email", selector: (row) => row.email },
    { name: "Major", selector: (row) => row.major },
    { name: "GPA", selector: (row) => row.gpa },
    {
      name: "Action",
      selector: (row) => (
        <Button
          color="primary"
          variant="contained"
          fullWidth
          type="button"
          onClick={() => handleClick(row)}
        >
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
