import { useState } from "react";
import { isMobile } from "react-device-detect";
import NewProductForm from "../../components/NewProductForm/NewProductForm";
import NewProductResum from "../../components/NewProductResum/NewProductResum";
import useNewProduct from "./useNewProduct";

import "./newProduct.css";

export default function NewProduct() {
	const { newProductData, handleSubmit, setNewProductData } = useNewProduct();
	const [ isPhone ] = useState(isMobile && window.innerWidth < 599);
	const [ deployResum, setDeployResum ] = useState(false);

	return (
		<section className='section_new_product'>
			<div className="section_new_product_data">
				{/*form de creacion del producto*/}
				<NewProductForm
					handleSubmit={handleSubmit}
					setNewProductData={setNewProductData}
				/>
				{/*resumen del producto que se esta creando*/}
				<NewProductResum productData={newProductData} isPhone={isPhone} deployResum={deployResum} setDeployResum={setDeployResum}/>
			</div>
			<button type="button" className="section_new_product_button" onClick={handleSubmit}>Crear Producto</button>
			{isPhone? <button type="button" className="view_resum_btn_mobile" onClick={()=>setDeployResum(true)}>Ver Resumen</button> : ""}
		</section>
	);
}
