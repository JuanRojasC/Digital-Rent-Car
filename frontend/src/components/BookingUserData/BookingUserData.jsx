import React from "react";
import "./bookingUserData.css";

export default function BookingUserData({user,location}) {
	return (
		<div className='bookingUserData_container'>
			<h3>Completa tus datos</h3>
			<form>
				<div>
					<label name="name">Nombre</label>
					<input type="text" name="name" value={user.name} disabled/>
				</div>

				<div>
					<label name="lastName">Apellido</label>
					<input type="text" name="lastName" value={user.lastName} disabled/>
				</div>

				<div>
					<label name="email">Correo Electronico</label>
					<input type="email" name="email" value={user.email}disabled/>
				</div>

				<div>
					<label name="ciudad">Ciudad</label>
					<input id="city" type="text" name="ciudad" value={location} />
				</div>
			</form>
			<h3>Seleccioná tu fecha de reserva</h3>
		</div>
	);
}
