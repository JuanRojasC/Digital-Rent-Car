import React, { useRef, useState, useEffect, useContext} from "react";
import { Link } from "react-router-dom";
import mapboxgl from "!mapbox-gl"; // eslint-disable-line import/no-webpack-loader-syntax
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
	faChevronLeft,
	faMapMarkedAlt,
	faStar,
} from "@fortawesome/free-solid-svg-icons";

import { useProduct } from "./useProduct";
import ProductAvailability from "../../components/ProductAvaibility/ProductAvailability";
import ProductData from "../../components/ProductData/ProductData";

import "./product.css";
import { UserContext } from "../../Hooks/UserContext/UserContext";

export default function Product() {
	const { error, product } = useProduct();

	const {setProductBooking}= useContext(UserContext);

	const mapContainer = useRef(null);
	const map = useRef(null);
	const [lng] = useState(product.city.longitude);
	const [lat] = useState(product.city.latitude);
	const [zoom] = useState(11.52);
	setProductBooking(product)

	useEffect(()=>{
		setProductBooking(product)
	},[])

	mapboxgl.accessToken =
		"pk.eyJ1Ijoic2FnYXJjaWFlc2NvYmFyIiwiYSI6ImNrdm9wZ3d0MzNwYzEydW51NHMxZjdhczMifQ.mhfe16kkn5XvnYiiB7nKgg";

	useEffect(() => {
		if (map.current) return; // initialize map only once
		map.current = new mapboxgl.Map({
			container: mapContainer.current,
			style: "mapbox://styles/sagarciaescobar/ckvophrs0bqv814qw8k2jffbl",
			center: [lng, lat],
			zoom: zoom,
		});
	});

	return error.is ? (
		<p>{error.text}</p>
	) : (
			<section className='section_product'>
				<div className='product_navbar'>
					<div className='product_navbar_data'>
						<h4>{product.category.title}</h4>
						<h2>{product.name}</h2>
					</div>
					<Link className='product_navbar_btn' to='/'>
						<FontAwesomeIcon
							className='product_navbar_backbtn'
							icon={faChevronLeft}
						/>
					</Link>
				</div>
				<div className='product_resum'>
					<div className='product_resum_location'>
						<FontAwesomeIcon
							className='product_resum_icon'
							icon={faMapMarkedAlt}
						/>
						<div className='product_resum_text'>
							<p>{product.location}</p>
						</div>
					</div>
					<div className='product_resum_qualification'>
						<div className='product_resum_qualification_text'>
							<p>Muy bueno</p>
							<FontAwesomeIcon className='product_icon_start' icon={faStar} />
							<FontAwesomeIcon className='product_icon_start' icon={faStar} />
							<FontAwesomeIcon className='product_icon_start' icon={faStar} />
							<FontAwesomeIcon className='product_icon_start' icon={faStar} />
							<FontAwesomeIcon className='product_icon_start' icon={faStar} />
						</div>
						<p>9</p>
					</div>
				</div>
				<ProductData car={product} />
				<ProductAvailability car={product} />
				<div className='product_location_map'>
					<h3>¿Donde puedo recoger mi vehiculo?</h3>
					<p>{product.city.name}</p>
					<div ref={mapContainer} className='map-container' />
				</div>
				<div className='product_additional_info'></div>
			</section>
	);
}
