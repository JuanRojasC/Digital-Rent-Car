import React from "react";

import "./bookingData.css";
import useBookingData from "./useBookingData";

export default function BookingData() {

	const { pickUpHoursOptions, dropOffHoursOptions } = useBookingData();

	return (
		<div className='booking_data_container'>
			<h3 className='booking_data_container_title'>
				Tu hora de llegada y regreso
			</h3>
			<p>Indica tu hora de llegada y regreso para brindarte el mejor servicio</p>
			<form className='booking_data_container_form'>
				<div className="booking_data_container_form_group">
					<select name="arrive">
						{pickUpHoursOptions.map((ele) => {
							return <option value={ele.format("HH")}>Hora de Llegada: {ele.format("HH")}:00</option>
						})}
					</select>
				</div>
				<div className="booking_data_container_form_group">
					<select name="dropOff">
						{dropOffHoursOptions.map((ele) => {
							return <option value={ele.format("HH")}>Hora de Regreso: {ele.format("HH")}:00</option>
						})}
					</select>
				</div>
			</form>
		</div>
	);
}
