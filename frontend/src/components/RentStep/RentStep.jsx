import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faAngleDown } from '@fortawesome/free-solid-svg-icons';
import "./step_rent.css";

export default function RentStep({title, text, icon}){
    return(
        <div className="step_rent">
            <div  className="i_step_rent_div">
                <FontAwesomeIcon icon={icon} className="i_step_rent"/>
            </div>
            <div className="step_rent_text">
                <h3>{title}</h3>
                <p>{text}</p>
            </div>
            <FontAwesomeIcon icon={faAngleDown} className="i_arrow_step_rent"/>
        </div>
    );
}