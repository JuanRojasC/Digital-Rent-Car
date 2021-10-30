import { BrowserRouter, Route, Switch } from "react-router-dom";
import Layout from "./components/Layout/Layout";
import Home from "./pages/Home/Home";
import Login from "./pages/Login/Login";
import Registro from "./pages/Registro/Registro";
import NotFound from "./pages/NotFound";

function App() {
	return (
		<BrowserRouter>
			<Layout>
				<Switch>
					<Route exact path='/' component={Home} />
					<Route exact path='/login' component={Login} />
					<Route exact path='/registro' component={Registro} />
					<Route component={NotFound} />
				</Switch>
			</Layout>
		</BrowserRouter>
	);
}

export default App;
