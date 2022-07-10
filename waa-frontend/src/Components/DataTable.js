import { useTheme } from "@mui/material";
import DataTable from "react-data-table-component";

const ReactDataTable = (props) => {
  const theme = useTheme();
  const customStyles = {
    headRow: {
      style: {
        backgroundColor: theme.palette.primary.dark,
        color: "white",
      },
    },
  };
  return (
    <DataTable
      {...props}
      pagination
      pointerOnHover
      customStyles={customStyles}
    />
  );
};

export default ReactDataTable;
