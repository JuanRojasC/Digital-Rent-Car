import { useContext } from "react";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
	faChevronRight,
	faChevronLeft,
	faTimes,
} from "@fortawesome/free-solid-svg-icons";

import { ProductListContext } from "../../Hooks/ProductListContext/ProductListContext";
import CarCard from "../../components/CarCard/CarCard";

import "./car_carousel.css";

export default function CarCarousel(props) {
	const { carsShow, clickSlideLeft, clickSlideRight, filterData,handleRemoveFilterData } =
		useContext(ProductListContext);

	return (
		<div className='car_options_landing_page_section_car_list'>
			<div className='carousel_landing_page_arrow_div' onClick={clickSlideLeft}>
				<FontAwesomeIcon
					icon={faChevronLeft}
					className='carousel_landing_page_arrow carousel_landing_page_arrow_left'
				/>
			</div>
			{carsShow.map((car, index) => {
				return <CarCard car={car} key={index} />;
			})}
			<div
				className='carousel_landing_page_arrow_div'
				onClick={clickSlideRight}>
				<FontAwesomeIcon
					icon={faChevronRight}
					className='carousel_landing_page_arrow carousel_landing_page_arrow_rigth'
				/>
			</div>
			{filterData && (
				<button className="carousel_landing_page_remove_filter" onClick={handleRemoveFilterData}>
					<FontAwesomeIcon icon={faTimes} />
					Eliminar filtros
				</button>
			)}
		</div>
	);
}
