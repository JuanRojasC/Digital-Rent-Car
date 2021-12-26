import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faExclamationCircle } from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";
import "./not_bookings.css";

export default function NotBookings(){
    return(
        <div id="not_bookings_div">
            <div className="not_bookings_message">
                <div className="not_bookings_text">
                    <FontAwesomeIcon icon={faExclamationCircle} className="not_bookings_text_icon"/>
                    <h2 className="not_bookings_text_message">Aun no tienes reservas</h2>
                </div>
                <Link to="/" className="not_booking_btn_back_home">Volver a Inicio</Link>
            </div>
            <div className="not_bookings_data">
                <img src="https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Ford+Mustang/Ford_Mustang-Image-White.png" alt="Car" className="not_bookings_car_image"/>
                <img src="/s3-bucket/props/background-main-booking.svg" alt="Prop Background" className="not_bookings_prop_background"/>
            </div>
        </div>
    );
}