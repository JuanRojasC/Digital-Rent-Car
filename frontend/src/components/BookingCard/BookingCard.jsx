import { useState } from 'react';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar } from "@fortawesome/free-solid-svg-icons";
import "./booking_card.css";

export default function BookingCard({ booking }){

    const [ product ] = useState(booking? booking.product : null)
    const [ image ] = useState(booking? booking.product.images.find(image => image.title === booking.product.name + " White").urlImage : null);

    return(
        <div className="booking_card">
            <div className="booking_card_data">
                <div className="booking_card_car_div">
                    <img src={image} alt="Car" className="booking_card_car_image" />
                    <div className="booking_card_yellow_circle"></div>
                </div>
                <div className="booking_card_details">
                    <p className="booking_card_details_title">{product.name}</p>
                    <p className="booking_card_details_location">{product.city.name}</p>
                    <div className='booking_card_qualification product_resum_qualification_text'>
                        <FontAwesomeIcon className='product_icon_star' icon={faStar} />
                        <FontAwesomeIcon className='product_icon_star' icon={faStar} />
                        <FontAwesomeIcon className='product_icon_star' icon={faStar} />
                        <FontAwesomeIcon className='product_icon_star' icon={faStar} />
                        <FontAwesomeIcon className='product_icon_star' icon={faStar} />
					</div>
                    <p className="booking_card_details_key">
                        Check In:
                        <span  className="booking_card_details_value">{booking.startTime.split("T")[0].replaceAll("-","/")}</span>
                    </p>
                    <p className="booking_card_details_key">
                        Check Out:
                        <span  className="booking_card_details_value">{booking.finishTime.split("T")[0].replaceAll("-","/")}</span>
                    </p>
                </div>
            </div>
            <button className="booking_card_view_details">Ver en detalle</button>
        </div>
    );
}