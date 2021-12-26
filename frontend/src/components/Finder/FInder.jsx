import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSearch } from "@fortawesome/free-solid-svg-icons";

import "./finder.css";
import { useContext } from "react";
import { ProductListContext } from "../../Hooks/ProductListContext/ProductListContext";

export default function Finder(props) {

	const {formValues,handleChange,handleOnSubmit} = useContext(ProductListContext);

	return (
		<div className='intro_landing_page_finder'>
			<h2 className='intro_landing_page_finder_title'>
				Rentar <span>Ahora</span>
			</h2>
			<form
				action=''
				className='intro_landing_page_form_finder'
				id='intro_landing_page_form_finder'
				onChange={handleChange}
				onSubmit={handleOnSubmit}>
				<label
					htmlFor='intro_landing_page_finder_select_location'
					className='intro_finder_label'>
					Ciudad:
					<select
						name='selectLocation'
						id='intro_landing_page_finder_select_location'
						defaultValue={formValues.selectLocation}>
						<option value='Ubicacion' disabled hidden>
							Ubicación
						</option>
						<option value='Bogotá DC'>Bogotá DC</option>
						<option value='Ciudad de Buenos Aires'>
							Ciudad de Buenos Aires
						</option>
					</select>
				</label>
				<label
					htmlFor='intro_landing_page_finder_select_fecha_recepcion'
					className='intro_finder_label'>
					Retiro:
					<input
						type='date'
						id='intro_landing_page_finder_select_fecha_recepcion'
						name='pickUpDate'
						placeholder='Fecha de Recepción'
						defaultValue={formValues.pickUpDate}
					/>
				</label>
				<label
					htmlFor='intro_landing_page_finder_select_fecha_regreso'
					className='intro_finder_label'>
					Devolución:
					<input
						type='date'
						id='intro_landing_page_finder_select_fecha_regreso'
						name='dropOffDate'
						placeholder='Fecha de Regreso'
						defaultValue ={formValues.dropOffDate}
					/>
				</label>
				<button
					className='intro_landing_page_finder_btn_buscar'
					type='submit'
					form='intro_landing_page_form_finder'>
					<FontAwesomeIcon icon={faSearch} className='finder_btn_find_icon' />
					Buscar
				</button>
			</form>
		</div>
	);
}
