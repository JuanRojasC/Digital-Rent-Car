import React from "react";
import { render } from "../../__test__/test-utils";
import BookingResum from "./BookingResum";

test("render content", () => {
	const car = {
		id: 1,
		name: "Chevrolet Captiva",
		description:
			"Captiva Turbo llega para desafiar todas las expectativas de lo que se espera de un SUV. Más allá de su atractivo diseño, tiene el espacio suficiente para todo y todos, gracias a su capacidad para 5 o 7 pasajeros. Está equipada con tecnología superior y atributos avanzados de seguridad.",
		category: {
			id: 1,
			title: "SUV",
			description:
				"Un Sport Utility Vehicle (Vehículo Utilitario Deportivo) es un vehículo que apuesta por una estética todoterreno, pero que por sus cualidades está más orientado al asfalto. Por su tamaño y habitabilidad, ofrece más espacio y posibilidades que un turismo convencional con el añadido de poder desenvolverse fuera del asfalto gracias a su mayor altura libre con respecto al suelo, aunque casi nunca con capacidades similares a las de un todoterreno.",
			image: {
				id: 16,
				title: "Audi Q5 Black",
				urlImage:
					"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Audi+Q5/Audi_Q5-Image-Black.png",
			},
		},
		city: {
			id: 1,
			name: "Ciudad de Buenos Aires",
			latitude: -34.61315,
			longitude: -58.37723,
			country: { id: 1, name: "Argentina" },
		},
		specs: {
			id: 1,
			enginePower: {
				id: 1,
				name: "enginePower",
				value: "145 HP",
				icon: {
					id: 7,
					title: "Engine Icon",
					urlImage:
						"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/engine.png",
				},
			},
			airConditioning: {
				id: 2,
				name: "airConditioning",
				value: "true",
				icon: {
					id: 5,
					title: "Air conditioner Icon",
					urlImage:
						"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/air-conditioner.png",
				},
			},
			seats: {
				id: 3,
				name: "seats",
				value: "7",
				icon: {
					id: 9,
					title: "seat Icon",
					urlImage:
						"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/seat.png",
				},
			},
			combustible: {
				id: 4,
				name: "combustible",
				value: "Diesel",
				icon: {
					id: 8,
					title: "Gasoline Icon",
					urlImage:
						"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/gasoline.png",
				},
			},
		},
		images: [
			{
				id: 133,
				title: "Chevrolet Captiva Gallery",
				urlImage:
					"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image1.png",
			},
			{
				id: 134,
				title: "Chevrolet Captiva Gallery",
				urlImage:
					"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image2.png",
			},
			{
				id: 135,
				title: "Chevrolet Captiva Gallery",
				urlImage:
					"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image3.png",
			},
			{
				id: 24,
				title: "Chevrolet Captiva Black",
				urlImage:
					"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image-Black.png",
			},
			{
				id: 136,
				title: "Chevrolet Captiva Gallery",
				urlImage:
					"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image4.png",
			},
			{
				id: 25,
				title: "Chevrolet Captiva Blue",
				urlImage:
					"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image-Blue.png",
			},
			{
				id: 137,
				title: "Chevrolet Captiva Gallery",
				urlImage:
					"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image5.png",
			},
			{
				id: 26,
				title: "Chevrolet Captiva White",
				urlImage:
					"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image-White.png",
			},
			{
				id: 27,
				title: "Chevrolet Captiva Red",
				urlImage:
					"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image-Red.png",
			},
		],
		bookings: [
			{
				startTime: "2022-01-24T00:00:00.000+00:00",
				finishTime: "2022-01-29T00:00:00.000+00:00",
			},
			{
				startTime: "2022-01-09T00:00:00.000+00:00",
				finishTime: "2022-01-17T00:00:00.000+00:00",
			},
		],
		termsAndConditions: [
			{
				id: 1,
				title: "Cancelacion",
				description:
					"Podra cancelar gratis y sin penalización 24 hrs antes de la hora programada para iniciar la reserva, podra hacerlo a través del portal web en la linea telefonica 6325685.",
				icon: {
					id: 257,
					title: "Cancel icon",
					urlImage:
						"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/cancel.png",
				},
			},
			{
				id: 2,
				title: "Gastos Asumido",
				description:
					"Cualquier daño, multa o penalización alguna producto del usuario titular de la reserva sera asumida en su totalidad economicamente y de completa responsabilidad de este. ",
				icon: {
					id: 255,
					title: "Crash icon",
					urlImage:
						"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/crash.png",
				},
			},
			{
				id: 3,
				title: "Documentos Exigidos",
				description:
					"Recuerde su DNI o Pasaporte a la hora de retirar el vehiculo, y recuerde portar siempre con usted su licencia de conducción valida para las autoridades del país.",
				icon: {
					id: 254,
					title: "Legal Documents icon",
					urlImage:
						"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/dni.png",
				},
			},
			{
				id: 4,
				title: "Modificación",
				description:
					"Modifique su reserva sin penalidad alguna en cualquier momento, bajo los horarios y vehiculos disponibles, no se haran devolucion por reducción del valor de la reserva, y el usuario asumira diferencias de valor.",
				icon: {
					id: 256,
					title: "Schedule icon",
					urlImage:
						"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/schedule.png",
				},
			},
			{
				id: 5,
				title: "Limites de Rodaje",
				description:
					"Mantenga el vehiculo dentro de las fronteras del territorio nacional, si desea salir de este, debera acercarse a una de nuestras oficinas y seguir el proceso con un asesor.",
				icon: {
					id: 258,
					title: "Country Border icon",
					urlImage:
						"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/border.png",
				},
			},
			{
				id: 6,
				title: "Soporte 24/7",
				description:
					"Comunicate con nuestro soporte telefonico disponible las 24 hrs del dia los 7 dias de la semana, nuestro equipo estara dispuesto a ayudarte ante cualquier eventualidad o asistencia que solicites",
				icon: {
					id: 253,
					title: "Support 24/7 icon",
					urlImage:
						"https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/support.png",
				},
			},
		],
	};
	const component = render(<BookingResum car={car} />);
	expect(component).toBeDefined();
});
