import { useRef, useState, useEffect, useContext } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMapMarkedAlt } from "@fortawesome/free-solid-svg-icons";
import { useProduct } from "./useProduct";
import { UserContext } from "../../Hooks/UserContext/UserContext";
import ProductAvailability from "../../components/ProductAvaibility/ProductAvailability";
import ProductData from "../../components/ProductData/ProductData";
import mapboxgl from "!mapbox-gl"; // eslint-disable-line import/no-webpack-loader-syntax
import TermsAndConditions from "../../components/TermsAndConditions/TermsAndConditions";
import "./product.css";

export default function Product() {
	const { product } = useProduct();
	const { setProductBooking } = useContext(UserContext);
	const mapContainer = useRef(null);
	const map = useRef(null);
	const [ zoom ] = useState(11.52);
	mapboxgl.accessToken = "pk.eyJ1Ijoic2FnYXJjaWFlc2NvYmFyIiwiYSI6ImNrdm9wZ3d0MzNwYzEydW51NHMxZjdhczMifQ.mhfe16kkn5XvnYiiB7nKgg";
	setProductBooking(product);

	useEffect(() => {
		if(product !== undefined && !map.current){
			map.current = new mapboxgl.Map({
				container: mapContainer.current,
				style: "mapbox://styles/sagarciaescobar/ckvophrs0bqv814qw8k2jffbl",
				center: [product.city.longitude, product.city.latitude],
				zoom: zoom,
			});
			const markerImage = document.createElement("div");
			markerImage.className = "marker_map";
			markerImage.style.backgroundImage = `url(${product.images.find(image => image.title === product.name + " White").urlImage})`;
			new mapboxgl.Marker(markerImage).setLngLat([product.city.longitude, product.city.latitude]).addTo(map.current);
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	},[product]);

	return(
		product?
		<section className='section_product'>
			<div className='product_navbar'>
				<div className='product_navbar_data'>
					<h2>{product.name}</h2>
					<h4>{product.category.title}</h4>
				</div>
				<div className="product_navbar_location">
					<FontAwesomeIcon className='product_location_icon' icon={faMapMarkedAlt} />
					<p className="product_location_text">{product.city.name}</p>
				</div>
			</div>
			<ProductData car={product} />
			<ProductAvailability car={product} />
			<div className='product_location_map'>
				<h3>¿Donde puedo recoger mi vehiculo?</h3>
				<div ref={mapContainer} className='map-container' />
			</div>
			<div className='product_additional_info'></div>
			<TermsAndConditions termsAndConditions={product.termsAndConditions} />
		</section>
		:
		null
	);
}
