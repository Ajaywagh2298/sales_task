import "./App.css";
import LoginUser from "./pages/LoginUser";
import RegisterUser from "./pages/RegisterUser";
import Home from "./pages/Home";
import CurrentBalance from "./pages/CurrentBalance";
import Error from "./pages/Error";
import {useRoutes} from "react-router-dom";

const App = () => {
  return useRoutes([
    {
      path: "/",
      element: <LoginUser/>,
    },
    {
      path: "/register",
      element: <RegisterUser/>,
    },
    {
      path: "/home",
      element: <Home/>,
    },
    {
      path: "/current-balance",
      element: <CurrentBalance/>,
    },
    {
      path: "/*",
      element: <Error/>,
    },
  ]);
};

export default App;
