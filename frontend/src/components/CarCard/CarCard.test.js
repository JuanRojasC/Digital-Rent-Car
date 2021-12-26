import React from "react";
import '@testing-library/jest-dom/extend-expect'
import { render } from "../../__test__/test-utils";
import CarCard from './CarCard';


test('render content', () => {
    const car = {
        id: 1,
        name: "Chevrolet Captiva",
        description: "Captiva Turbo llega para desafiar todas las expectativas de lo que se espera de un SUV. Más allá de su atractivo diseño, tiene el espacio suficiente para todo y todos, gracias a su capacidad para 5 o 7 pasajeros. Está equipada con tecnología superior y atributos avanzados de seguridad.",
        mainImage: {
            id: 18,
            title: "Chevrolet Captiva",
            urlImage: "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image.png"
        },
        category: {
            id: 1,
            title: "SUV",
            description: "Un Sport Utility Vehicle (Vehículo Utilitario Deportivo) es un vehículo que apuesta por una estética todoterreno, pero que por sus cualidades está más orientado al asfalto. Por su tamaño y habitabilidad, ofrece más espacio y posibilidades que un turismo convencional con el añadido de poder desenvolverse fuera del asfalto gracias a su mayor altura libre con respecto al suelo, aunque casi nunca con capacidades similares a las de un todoterreno.",
            image: {
                id: 16,
                title: "Audi Q5",
                urlImage: "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Audi+Q5/Audi_Q5-Image.png"
            }
        },
        city: {
            id: 1,
            name: "Ciudad de Buenos Aires",
            latitude: -34.6131500,
            longitude: -58.3772300,
            country: {
                id: 1,
                name: "Argentina"
            }
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
                    urlImage: "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/engine.png"
                }
            },
            airConditioning: {
                id: 2,
                name: "airConditioning",
                value: "true",
                icon: {
                    id: 5,
                    title: "Air conditioner Icon",
                    urlImage: "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/air-conditioner.png"
                }
            },
            seats: {
                id: 3,
                name: "seats",
                value: "7",
                icon: {
                    id: 9,
                    title: "seat Icon",
                    urlImage: "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/seat.png"
                }
            },
            combustible: {
                id: 4,
                name: "combustible",
                value: "Diesel",
                icon: {
                    id: 8,
                    title: "Gasoline Icon",
                    urlImage: "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/gasoline.png"
                }
            }
        },
        "images": [
            {
                id: 35,
                title: "Chevrolet Captiva Gallery",
                urlImage: "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image1.png"
            },
            {
                id: 36,
                title: "Chevrolet Captiva Gallery",
                urlImage: "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image2.png"
            },
            {
                id: 37,
                title: "Chevrolet Captiva Gallery",
                urlImage: "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image3.png"
            },
            {
                id: 38,
                title: "Chevrolet Captiva Gallery",
                urlImage: "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image4.png"
            },
            {
                id: 39,
                title: "Chevrolet Captiva Gallery",
                urlImage: "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/vehicles/Chevrolet+Captiva/Chevrolet_Captiva-Image5.png"
            }
        ],
        bookings: null
    }


    const index = 1;

    const component = render(<CarCard car={car} key={index} />)
    expect(component.container).toHaveTextContent(car.name)
    component.getByText("Chevrolet Captiva")
})