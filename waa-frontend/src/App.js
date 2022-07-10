import { Suspense } from "react";
import Routes from "./routes";

const App = () => {
  return (
    <Suspense>
      <Routes />
    </Suspense>
  );
};

export default App;
