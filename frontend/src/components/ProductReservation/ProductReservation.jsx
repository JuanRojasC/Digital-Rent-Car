import { useContext } from "react";
import { Link } from "react-router-dom";
import { UserContext } from "../../Hooks/UserContext/UserContext";

import "./productReservation.css";

export default function ProductReservation({car}) {

	const {logged} = useContext(UserContext);

	return (
		<>
			<div className='product_availability_reservation'>
				<p>Selecciona tus fechas de viaje y disfruta del camino con Digital Rent Car</p>
				<Link to={logged ? `/reservacion/${car.name.replace(" ", "-")}`:"/login"}>
					Inicia tu reserva
				</Link>
			</div>
		</>
	);
}
