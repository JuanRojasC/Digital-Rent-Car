import { useState } from "react";
import {
	faTasks,
	faMapMarkerAlt,
	faCar,
	faFileSignature,
} from "@fortawesome/free-solid-svg-icons";

import RentStep from "../../components/RentStep/RentStep";
import Intro from "../../components/Intro/Intro";
import CarCarousel from "../../components/CarCarousel/CarCarousel";
import rentSteps from "../../Assets/jsons/RentSteps.json";
import CategoriesCards from "../../components/CategoriesCards/CategoriesCards";

import rentStepsImage from "../../Assets/Dealer-Image.jpg";

import "./home.css";

export default function Home() {
	const [iconsStepsRent] = useState({
		faMapMarkerAlt: faMapMarkerAlt,
		faTasks: faTasks,
		faCar: faCar,
		faFileSignature: faFileSignature,
	});

	return (
		<>
			<section data-testid="home_page" className='intro_landing_page_section'>
				<Intro />
			</section>
			<section id='car-options' className='car_options_landing_page_section'>
				<h2 className='title_cars_categories'>
					¡Un vehiculo para cada ocasión!
				</h2>
				<CategoriesCards />
				<h2 className='title_cars_catalogue'>Recomendaciones</h2>
				<CarCarousel />
			</section>

			<section className='rent_steps_landing_page_section'>
				<h2 className='title_rent_steps'>¿Como rento un vehiculo?</h2>
				<div className='rent_steps_div'>
					<div className='rent_steps_landing_page'>
						{rentSteps.map((step, index) => (
							<RentStep
								icon={iconsStepsRent[step.icon]}
								title={step.title}
								text={step.text}
								key={index}
							/>
						))}
					</div>
					<div className='rent_steps_image_landing_page'>
						<img
							src={rentStepsImage}
							alt='Car Dealer'
							className='car-dealer-image'
						/>
					</div>
				</div>
			</section>
		</>
	);
}
