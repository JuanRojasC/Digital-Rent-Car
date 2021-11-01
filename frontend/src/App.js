import { useState } from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Layout from "./components/Layout/Layout";
import Home from "./pages/Home/Home";
import Login from "./pages/Login/Login";
import Registro from "./pages/Registro/Registro";
import NotFound from "./pages/NotFound";

function App() {

	return (
		<BrowserRouter>
			<Switch>
				<Route exact path='/' >
					<Layout headerMain={true}>
						<Home />
					</Layout>
				</Route>
				<Route exact path='/login' >
					<Layout headerMain={false}>
						<Login />
					</Layout>
				</Route>
				<Route exact path='/registro' >
					<Layout headerMain={false}>
						<Registro />
					</Layout>
				</Route>
				<Route component={NotFound} />
			</Switch>
		</BrowserRouter>
	);
}

export default App;
