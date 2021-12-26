import React, { useContext } from "react";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCalendarAlt, faUser, faEnvelopeOpenText } from "@fortawesome/free-solid-svg-icons";
import { UserContext } from "../../Hooks/UserContext/UserContext";

import "./successfulbooking.css";

export default function SuccessfulBooking() {

	const { bookingInfo } = useContext(UserContext);


	return (
		<div className='successful_booking'>
			<div className='successful_booking_container'>
				<div className='successful_booking_container_data'>
					<h3>Reserva Exitosa</h3>
					<img src={bookingInfo.product.images.find(image => image.title === bookingInfo.product.name + " White").urlImage} alt={bookingInfo.product.name} />
					<div className="successful_icon"></div>
					<div className='successful_booking_container_data_car'>
						<p className='successful_booking_container_data_car_category'>
							{bookingInfo.product.category.title}
						</p>
						<p className='successful_booking_container_data_car_name'>
							{bookingInfo.product.name}
						</p>
						<p className='successful_booking_container_data_car_location'>
							{bookingInfo.product.city.name}
						</p>
					</div>
					<div className='successful_booking_container_data_date'>
						<div className='line_calendar'></div>
						<div className='successful_booking_container_data_date_label'>
							<FontAwesomeIcon className='success_icon_calendar' icon={faCalendarAlt} />
							<p className='date_title_checkin'>Check In: </p>
							<p className='date_p_start'>{bookingInfo.startTime.split("T")[0].replaceAll("-","/")}</p>
						</div>
						<div className='line_calendar'></div>
						<div className='successful_booking_container_data_date_data'>
							<FontAwesomeIcon className='success_icon_calendar' icon={faCalendarAlt} />
							<p className='date_title_checkout'>Check Out: </p>
							<p className='date_p_finish'>{bookingInfo.finishTime.split("T")[0].replaceAll("-","/")}</p>
						</div>
					</div>
					<div className='successful_line_calendar'></div>
					<div className='successful_booking_container_data_user'>
						<FontAwesomeIcon className='success_icon_user' icon={faUser} />
						<p className='successful_user_title'>
							Nombre:
						</p>
						<p className='successful_user_email'>
							{bookingInfo.user.name} {bookingInfo.user.lastName}
						</p>
					</div>
					<div className='successful_line_calendar'></div>
					<div className='successful_booking_container_data_user'>
						<FontAwesomeIcon className='success_icon_email' icon={faEnvelopeOpenText} />
						<p className='successful_user_title_email'>
							Correo: 
						</p>
						<p className='successful_user_email'>
							{bookingInfo.user.email}
						</p>
					</div>
					<Link to='/'>Volver al Inicio</Link>
				</div>
			</div>
		</div>
	);
}
