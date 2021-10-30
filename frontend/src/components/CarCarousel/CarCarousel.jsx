import { useEffect, useState } from "react";
import { isMobile } from "react-device-detect";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faChevronRight, faChevronLeft } from '@fortawesome/free-solid-svg-icons';
import carList from "../../Assets/jsons/CarsList.json";
import CarCard from "../../components/CarCard/CarCard";
import "./car_carousel.css";

const itemsNumber = isMobile  && window.innerWidth < 1000? 3 : 4

export default function CarCarousel(props){

    let [lastPosition, setLastPosition] = useState(itemsNumber)
    let [carsShow, setCarsShow] = useState(carList.slice(0,itemsNumber));

    useEffect(()=>{
        setCarsShow(carList.slice(lastPosition-itemsNumber,lastPosition));
    },[lastPosition])

    useEffect(()=>{},[carsShow])

    const clickSlideLeft = () => {
        if(lastPosition===itemsNumber) return;
        else if(lastPosition>itemsNumber) setLastPosition(lastPosition-1);
    }
    const clickSlideRight = () => {
        if(lastPosition===carList.length) return;
        else if(lastPosition<carList.length) setLastPosition(lastPosition+1);
    }

    return(
        <div className="car_options_landing_page_section_car_list">
            <div className="carousel_landing_page_arrow_div" onClick={clickSlideLeft}>
                <FontAwesomeIcon icon={faChevronLeft} className="carousel_landing_page_arrow carousel_landing_page_arrow_left" />
            </div>
            {carsShow.map((car, index)=>{
                return <CarCard car={car} key={index}/>}
            )}
            <div className="carousel_landing_page_arrow_div" onClick={clickSlideRight}>
                <FontAwesomeIcon icon={faChevronRight} className="carousel_landing_page_arrow carousel_landing_page_arrow_rigth" />
            </div>
        </div>
    );
}