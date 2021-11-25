import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import Layout from "./components/Layout/Layout";
import Home from "./pages/Home/Home";
import Login from "./pages/Login/Login";
import Registro from "./pages/Registro/Registro";
import NotFound from "./pages/NotFound";
import Product from "./pages/Product/Product";
import Booking from "./pages/Booking/Booking";
import { ProductListProvider } from "./Hooks/ProductListContext/ProductListContext";
import SuccessfulBooking from "./pages/SuccessfulBooking/SuccessfulBooking";

function App() {
	return (
		<ProductListProvider>
			<Router>
				<Switch>
					<Route exact path='/'>
						<Layout headerMain={true}>
							<Home />
						</Layout>
					</Route>
					<Route exact path='/login'>
						<Layout headerMain={false}>
							<Login />
						</Layout>
					</Route>
					<Route exact path='/registro'>
						<Layout headerMain={false}>
							<Registro />
						</Layout>
					</Route>
					<Route exact path='/producto/:id'>
						<Layout headerMain={false}>
							<Product />
						</Layout>
					</Route>
					<Route exact path='/:user/producto/:name/reserva'>
						<Layout headerMain={false}>
							<Booking />
						</Layout>
					</Route>
					<Route exact path='/:user/producto/:name/reserva/exitosa'>
						<Layout headerMain={false}>
							<SuccessfulBooking />
						</Layout>
					</Route>
					<Route component={NotFound} />
				</Switch>
			</Router>
		</ProductListProvider>
	);
}

export default App;
