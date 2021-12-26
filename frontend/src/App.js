import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import Layout from "./components/Layout/Layout";
import Home from "./pages/Home/Home";
import Login from "./pages/Login/Login";
import Registro from "./pages/Registro/Registro";
import NotFound from "./pages/NotFound/NotFound";
import Product from "./pages/Product/Product";
import Booking from "./pages/Booking/Booking";
import UserBookings from "./pages/UserBookings/UserBookings";
import NewProduct from "./pages/NewProduct/NewProduct";

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
					<Route exact path='/autos/:name'>
						<Layout headerMain={false}>
							<Product />
						</Layout>
					</Route>
					<Route exact path='/reservacion/:name'>
						<Layout headerMain={false}>
							<Booking />
						</Layout>
					</Route>
					<Route exact path='/:user/producto/:name/reserva/exitosa'>
						<Layout headerMain={false}>
							<SuccessfulBooking />
						</Layout>
					</Route>
					<Route exact path='/reservas'>
						<Layout headerMain={false}>
							<UserBookings />
						</Layout>
					</Route>
					<Route exact path='/vehiculos/nuevo'>
						<Layout headerMain={false}>
							<NewProduct />
						</Layout>
					</Route>
					<Route>
						<Layout headerMain={false}>
							<NotFound />
						</Layout>
					</Route>
				</Switch>
			</Router>
		</ProductListProvider>
	);
}

export default App;
