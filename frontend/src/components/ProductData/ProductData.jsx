import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar } from "@fortawesome/free-solid-svg-icons";
import Gallery from "../Gallery/Gallery";
import "./product_data.css";

export default function ProductData({ car }) {

	const [ mainImages ] = useState(car.images.filter(image => !image.title.includes("Gallery")));
	const [ galleryImages ] = useState(car.images.filter(image => image.title.includes("Gallery")));
	let [ mainImage, setMainImage ] = useState(mainImages.find(image => image.title === car.name + " White").urlImage);

	useEffect(()=>{}, [mainImage])

	return (
		<>
			<article className='product_data'>
				<div className="car_image_div">
					<img src={mainImage} alt="Car" className="car_image" />
					<img src="/s3-bucket/props/background-product-vehicle.png" alt="Landscape  Background" className="landscape_background"/>
					<div className="color_options_div">
						{mainImages.map((image, index) => 
						<div className={`circle_color_car_${image.title.split(" ")[2].toLowerCase()} circle_color_car`} key={index} onClick={()=>setMainImage(image.urlImage)}></div>)}
					</div>
				</div>
				{/*No mover de posicion, el position afecta otros elementos*/}
				<div className="background_yellow"></div>
				<Gallery images={galleryImages} />
				<div className="features_car">
					<div className='product_resum_qualification'>
						<div className='product_resum_qualification_text'>
							<p>Calificación</p>
							<FontAwesomeIcon className='product_icon_star' icon={faStar} />
							<FontAwesomeIcon className='product_icon_star' icon={faStar} />
							<FontAwesomeIcon className='product_icon_star' icon={faStar} />
							<FontAwesomeIcon className='product_icon_star' icon={faStar} />
							<FontAwesomeIcon className='product_icon_star' icon={faStar} />
						</div>
					</div>
					{Object.values(car.specs).map((spec,index) => spec.name? 
					<div className="feature_car" key={index}>
						<img src={spec.icon.urlImage} alt="Feature Icon" className="feature_car_icon" />
						<p className="feature_car_value">{spec.value === "true"? "A/C" : spec.value}</p>
					</div> 
					: 
					""
					)}
				</div>
			</article>
			<div className="description_car">
				<p className="description_car_title">Descripcion</p>
				<p className="description_car_body">{car.description}</p>
			</div>
		</>
	);
}
