import useNewProductForm from "./useNewProductForm";
import NewProductFormImages from "../NewProductFormImages/NewProductFormImages";
import "./newProductForm.css";

export default function NewProductForm({ setNewProductData }) {
	const {
		handleChange,
		categories,
		cities,
		specs,
		termsAndConditions,
		loadingCategories,
		loadingCities,
		loadingSpecs,
		loadingTermAndConditions,
		combustibleIcon,
		error,
		imageIndex,
		setImageIndex,
	} = useNewProductForm(setNewProductData);

	return (
		<div className='new_product_container'>
			{loadingCategories ||
			loadingCities ||
			loadingSpecs ||
			loadingTermAndConditions ? (
				<div className='form_new_product_bar'></div>
			) : error ? (
				<p className='new_product_error'>{error}</p>
			) : (
				<form onChange={handleChange} className='new_product_container_form'>
					<div className='new_product_navbar product_navbar'>
						<div className='product_navbar_data'>
							<h2>Nuevo Producto</h2>
						</div>
					</div>
					<div className='form_new_product_data_section form_new_product_section'>
						<h2>Información</h2>
						<div id='form_new_product_divider_name_description' className='form_new_product_divider'>
							<div className='form_new_product_group'>
								<label htmlFor='name'>Marca:</label>
								<input id='name' type='text' name='name' autoComplete="off" required />
							</div>
							<div className='form_new_product_group'>
								<label htmlFor='model'>Modelo:</label>
								<input id='model' type='text' name='model' autoComplete="off" required />
							</div>
							<div className='form_new_product_group'>
								<label htmlFor='description'>Descripcion:</label>
								<textarea id='name' type='text' name='description' autoComplete="off" required />
							</div>
						</div>
						<div className='form_new_product_divider'>
							<div className='form_new_product_group'>
								<label htmlFor='categories'>Categoria</label>
								<select id='categories' name='categories'>
									<option hidden>seleccionar..</option>
									{categories.map((category, index) => {
										return (
											<option value={category.id} key={index}>{category.title}</option>
										);
									})}
								</select>
							</div>
							<div className='form_new_product_group'>
								<label htmlFor='cities'>Ciudad</label>
								<select id='cities' name='cities'>
									<option hidden>seleccionar..</option>
									{cities.map((city, index) => {
										return <option value={city.id} key={index}>{city.name}</option>;
									})}
								</select>
							</div>
						</div>
					</div>
					<div className='form_new_product_features_section form_new_product_section'>
						<h2>Especificaciones</h2>
						<div className='form_new_product_divider'>
							<div className='form_new_product_group_spec'>
								<p className="form_new_product_spec_title">Potencia Motor</p>
								<label>
									<img
										src={specs.enginePower.icon.urlImage}
										alt={specs.enginePower.name}
									/>
								</label>
								<input type="number" name='enginePower' placeholder="Horsepower" autoComplete="off" required/>
							</div>
							<div className='form_new_product_group_spec'>
								<p className="form_new_product_spec_title">Aire Acondicionado</p>
								<label>
									<img
										src={specs.airConditioning.icon.urlImage}
										alt={specs.airConditioning.name}
									/>
								</label>
								<select name='airConditioning' required>
									<option hidden>A/C</option>
									<option value='true'>Si</option>
									<option value='false'>No</option>
								</select>
							</div>
							<div className='form_new_product_group_spec'>
								<p className="form_new_product_spec_title">Asientos</p>
								<label>
									<img src={specs.seats.icon.urlImage} alt={specs.seats.name} />
								</label>
								<input type="number" name='seats' placeholder="asientos" autoComplete="off" required/>
							</div>
							<div className='form_new_product_group_spec'>
								<p className="form_new_product_spec_title">Tipo Combustible</p>
								<label>
									<img 
										src={combustibleIcon? combustibleIcon.icon.urlImage: specs.combustible[0].icon.urlImage } 
										alt={combustibleIcon? combustibleIcon.icon.title: specs.combustible[0].icon.title}
									/>
								</label>
								<select name='combustible' required>
									<option hidden>combustible</option>
									{specs.combustible.map((spec, index) => {
										return <option value={spec.name} key={index}>{spec.name}</option>;
									})}
								</select>
							</div>
						</div>
					</div>

					<div className='form_new_product_image_section form_new_product_section'>
						<h2>Imagenes</h2>
						<div className='form_new_product_divider_images'>
							<NewProductFormImages imageIndex={imageIndex} setImageIndex={setImageIndex}/>
						</div>
					</div>

					<div className='form_new_product_section'>
						<h2>Terminos y Condiciones</h2>
						<div className='form_new_product_divider_terms_and_conditions'>
							<div className='form_new_product_divider_terms_and_conditions_items'>
								{termsAndConditions.map((item, i) => {
									return (
										<div key={i} className='form_new_product_divider_terms_and_conditions_item'>
											<input onChange={handleChange} type='checkbox' name={item.id} data-id={item.id} />
											<img src={item.icon.urlImage} alt={item.icon.title} />
											<div className='form_term_and_condition_text_div'>
												<p className='form_new_product_term_and_condition_title'>{item.title}</p>
												<p className='form_new_product_term_and_condition_description'>
													{item.description}
												</p>
											</div>
										</div>
									);
								})}
							</div>
						</div>
					</div>
				</form>
			)}
		</div>
	);
}
