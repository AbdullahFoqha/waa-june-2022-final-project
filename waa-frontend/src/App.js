import { Suspense } from "react";
import Routes from "./Routes";

const App = () => {
  return (
    <Suspense>
      <Routes />
    </Suspense>
  );
};

export default App;
