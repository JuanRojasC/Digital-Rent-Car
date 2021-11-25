import { useContext } from "react";
import { Link } from "react-router-dom";
import { UserContext } from "../../Hooks/UserContext/UserContext";

import "./productReservation.css";

export default function ProductReservation({id}) {

	const {user,logged,productBooking} = useContext(UserContext);

	console.log(productBooking);
	return (
		<div className='product_availability_reservation'>
			<p>Agrega tus fechas de viaje para obtener precios excatos</p>
			<Link to={logged ? `/${user.email}/producto/${id}/reserva`:"/"}>Inicia tu reserva</Link>
		</div>
	);
}
