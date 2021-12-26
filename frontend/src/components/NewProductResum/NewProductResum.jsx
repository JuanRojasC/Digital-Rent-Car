import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMapMarkedAlt, faTimes } from "@fortawesome/free-solid-svg-icons";
import { useEffect, useState } from "react";
import "./newProductResum.css";

export default function NewProductResum({ productData, isPhone, deployResum, setDeployResum }) {

	const [ mainImage, setMainImage ] = useState("");

	useEffect(() => {
		setMainImage(productData?.images?.find(img => img.title.includes("White"))?.urlImage || "/s3-bucket/props/vehicle-prop-new-product-form.png")
	}, [productData])

	return (
		productData?
		<aside className='aside_new_product_resum'>
			<div className='new_product_resum_container' style={{display: isPhone? (deployResum? "flex" : "none") : "flex"}}>
				{isPhone? <FontAwesomeIcon icon={faTimes} className="close_new_product_resum_mobile" onClick={()=>setDeployResum(false)}/> : ""}
				<div className="new_product_resum_title">
					<h2 className="new_product_resum_title">
						{productData.name? productData.name : "Marca / Modelo"}
					</h2>
					<div className="product_navbar_location">
						<FontAwesomeIcon className='product_location_icon' icon={faMapMarkedAlt} />
						<p className="product_location_text">{productData.city?.name || "ubicación"}</p>
					</div>
				</div>
				<p className="new_product_resum_category">{productData.category?.title || "Marca / Modelo"}</p>
				<img src={mainImage} alt="Car" className="new_product_resum_main_image_car"/>
				<div className="new_product_resum_color_options">
					{
						productData.images.filter(img => {
							return img.title.match( /White|Black|Blue|Red/g ) && img.urlImage? img : "";
						}).map((image, index) => {
							return <div className={`new_product_resum_circle_color_option circle_color_car_${image.title.toLowerCase()} circle_color_car`} key={index} onClick={()=>setMainImage(image.urlImage)} />
						})
					}
				</div>
				<hr className="new_product_resum_hr" />
				<div className="new_product_resum_description new_product_container_values">
					<p className="new_product_resum_description_title new_product_resum_title_key">Descripción</p>
					<div className="new_product_resum_description_body">{productData.description?.slice(0,350).concat(" . . .") || <div className="new_product_resum_without_results">Agrega una descripción</div>}</div>
				</div>
				<hr className="new_product_resum_hr" />
				<div className="new_product_container_values">
					<p className="new_product_resum_features_title new_product_resum_title_key">Especificaciones</p>
					<div className="new_product_resum_features">
						<div className="new_product_resum_feature_div">
							<img src={productData.specs.enginePower.icon?.urlImage} alt="Feature Icon" className="new_product_resum_feature_icon" />
							<p className="new_product_resum_feature_value">{productData.specs.enginePower.value? productData.specs.enginePower.value  + " HP" : "hp"}</p>
						</div>
						<div className="new_product_resum_feature_div">
							<img src={productData.specs.airConditioning.icon?.urlImage} alt="Feature Icon" className="new_product_resum_feature_icon" />
							<p className="new_product_resum_feature_value">{productData.specs.airConditioning.value === "true"? "A/C" : "N/A"}</p>
						</div>
						<div className="new_product_resum_feature_div">
							<img src={productData.specs.seats.icon?.urlImage} alt="Feature Icon" className="new_product_resum_feature_icon" />
							<p className="new_product_resum_feature_value">{productData.specs.seats.value || "asientos"}</p>
						</div>
						<div className="new_product_resum_feature_div">
							<img src={productData.specs.combustible.icon?.urlImage} alt="Feature Icon" className="new_product_resum_feature_icon" />
							<p className="new_product_resum_feature_value">{productData.specs.combustible.value || "combustible"}</p>
						</div>
					</div>
				</div>
				<hr className="new_product_resum_hr" />
				<div className="new_product_container_values">
					<p className="new_product_resum_tcs_title new_product_resum_title_key">Politicas</p>
					<div className="new_product_resum_tyc_div">
						{productData.termsAndConditions?.length > 0?
							productData.termsAndConditions?.map((tyc, index) => 
								<div className="new_product_resum_tyc" key={index}>
									<img src={tyc.icon.urlImage} alt="Term And Codition Icon" className="new_product_resum_tyc_icon"/>
									<p className="new_product_resum_tyc_title">{tyc.title}</p>
								</div>)
							:
							<div className="new_product_resum_without_results">No hay politicas seleccionadas</div>
						}
					</div>
				</div>
			</div>
		</aside>
		:
		""
	);
}
