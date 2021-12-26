import { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCarAlt, faCalendarDay, faUsers, faStar } from "@fortawesome/free-solid-svg-icons";
import "./main_booking.css";

export default function MainBooking({ booking }){

    const [ product ] = useState(booking? booking.product : null)
    const [ image ] = useState(booking? booking.product.images.find(image => image.title === booking.product.name + " White").urlImage : null);

    return(
        <div className="main_booking">
            <h3 className="main_booking_title">
                Ultima reservación
            </h3>
            <div className="main_booking_data">
                <img src={image} alt="Car" className="main_booking_car_image"/>
                <img src="/s3-bucket/props/background-main-booking.svg" alt="Prop Background" className="main_booking_prop_background"/>
                <div className="main_booking_data_div_absolute main_booking_data_title">
                    <div className="main_booking_data_div">
                        <div className="main_booking_data_icon">
                            <FontAwesomeIcon icon={faCarAlt} className="main_bookind_data_icon_i" />
                        </div>
                        <div className="main_booking_data_text">
                            <p className="main_booking_data_title">{product.name}</p>
                            <p className="main_booking_data_value">{product.city.name}</p>
                        </div>
                    </div>
                </div>
                <div className="main_booking_data_div_absolute main_booking_data_check_in">
                    <div className="main_booking_data_div">
                        <div className="main_booking_data_icon">
                            <FontAwesomeIcon icon={faCalendarDay} className="main_bookind_data_icon_i" />
                        </div>
                        <div className="main_booking_data_text">
                            <p className="main_booking_data_inline main_booking_data_title">Check In:</p>
                            <p className="main_booking_data_inline main_booking_data_value main_booking_data_value_inline">{booking.startTime.split("T")[0].replaceAll("-","/")}</p>
                        </div>
                    </div>
                </div>
                <div className="main_booking_data_div_absolute main_booking_data_check_out">
                    <div className="main_booking_data_div">
                        <div className="main_booking_data_icon">
                            <FontAwesomeIcon icon={faCalendarDay} className="calendar_inverse main_bookind_data_icon_i"/>
                        </div>
                        <div className="main_booking_data_text">
                            <p className="main_booking_data_inline main_booking_data_title">Check Out:</p>
                            <p className="main_booking_data_inline main_booking_data_value main_booking_data_value_inline">{booking.finishTime.split("T")[0].replaceAll("-","/")}</p>
                        </div>
                    </div>
                </div>
                <div className="main_booking_data_div_absolute main_booking_data_quality">
                    <div className="main_booking_data_div">
                        <div className="main_booking_data_icon">
                            <FontAwesomeIcon icon={faUsers} className="main_bookind_data_icon_i" />
                        </div>
                        <div className="main_booking_data_text">
                            <p className="main_booking_data_title">Calidad del Servicio</p>
                            <div className='product_resum_qualification'>
						<div className='main_booking_qualification product_resum_qualification_text'>
							<FontAwesomeIcon className='product_icon_star' icon={faStar} />
							<FontAwesomeIcon className='product_icon_star' icon={faStar} />
							<FontAwesomeIcon className='product_icon_star' icon={faStar} />
							<FontAwesomeIcon className='product_icon_star' icon={faStar} />
							<FontAwesomeIcon className='product_icon_star' icon={faStar} />
						</div>
					</div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="main_booking_car_data">
                {Object.values(product.specs).map((spec,index) => spec.name? 
                    <div className="main_booking_feature_car" key={index}>
                        <img src={spec.icon.urlImage} alt="Feature Icon" className="feature_car_icon" />
                        <p className="feature_car_value">{spec.value === "true"? "A/C" : spec.value}</p>
                    </div> 
                    : 
                    ""
                )}
            </div>
        </div>
    );
}