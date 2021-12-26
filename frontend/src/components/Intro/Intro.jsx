import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHeadset, faCarCrash, faDollarSign } from "@fortawesome/free-solid-svg-icons";
import Finder from "../Finder/FInder";
import introImage from "../../Assets/Intro_Car-Image.png";
import "./intro.css";

export default function Intro() {

	return (
		<div className='intro_landing_page'>
			<section className='intro_landing_page_text_section'>
				<div className='intro_landing_page_text'>
					<h2 className='intro_landing_page_title'>
						Los mejores caminos para los mejores autos
					</h2>
					<p className='intro_landing_page_p'>
						Elija un automovil para todas la ocasiones, carretera, offroad,
						pista o familia.
					</p>
					<a href='#car-options' className='intro_landing_page_btn_rent'>
						Alquilar
					</a>
					<div className='intro_landing_page_brands_div'>
						<img
							src='/car-brands-icons/chevrolet-icon.png'
							alt='chevrolet brand icon'
							className='intro_brand_icon'
						/>
						<img
							src='/car-brands-icons/ford-icon.png'
							alt='ford brand icon'
							className='intro_brand_icon'
						/>
						<img
							src='/car-brands-icons/honda-icon.png'
							alt='honda brand icon'
							className='intro_brand_icon'
						/>
						<img
							src='/car-brands-icons/nissan-icon.png'
							alt='nissan brand icon'
							className='intro_brand_icon'
						/>
						<img
							src='/car-brands-icons/renault-icon.png'
							alt='renault brand icon'
							className='intro_brand_icon'
						/>
						<img
							src='/car-brands-icons/toyota-icon.png'
							alt='toyota brand icon'
							className='intro_brand_icon'
						/>
					</div>
				</div>
				<div className='intro_image_family_car'>
					<img
						src={introImage}
						alt='Car with family board'
						className='intro_car_family_image'
					/>
					<div className='intro_landing_page_services_div'>
						<div className='intro_landing_page_support_div'>
							<FontAwesomeIcon
								icon={faHeadset}
								className='intro_landing_page_support_icon'
							/>
							<p className='intro_landing_page_support_text'>Soporte 24/7</p>
						</div>
						<div className='intro_landing_page_support_div'>
							<FontAwesomeIcon
								icon={faCarCrash}
								className='intro_landing_page_support_icon'
							/>
							<p className='intro_landing_page_support_text'>Insurances</p>
						</div>
						<div className='intro_landing_page_support_div'>
							<FontAwesomeIcon
								icon={faDollarSign}
								className='intro_landing_page_support_icon'
							/>
							<p className='intro_landing_page_support_text'>Economia</p>
						</div>
					</div>
					<div className='intro_circle_yellow'></div>
				</div>
			</section>
			<section className='intro_landing_page_finder_section'>
				<Finder />
			</section>
		</div>
	);
}