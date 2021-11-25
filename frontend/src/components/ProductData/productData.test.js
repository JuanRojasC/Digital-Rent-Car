import React from "react";
import '@testing-library/jest-dom/extend-expect';
import { render } from "@testing-library/react";
import ProductData from './ProductData';

test('render content',()=>{

    const car={
        id: 1,
        img: ["/car-images/Chevrolet_Captiva-Image.png",
          "/car-images/Chevrolet_Captiva-Image2.png",
          "/car-images/Chevrolet_Captiva-Image3.png",
          "/car-images/Chevrolet_Captiva-Image4.jpg",
          "/car-images/Chevrolet_Captiva-Image5.png"],
        category: "SUV",
        title: "Chevrolet Captiva",
        location: "ARG/COL",
        description : {
            engine: "145 HP",
            airConditioning: true,
            seats: 7,
            type: "Diesel",
            text: "Captiva Turbo llega para desafiar todas las expectativas de lo que se espera de un SUV. Más allá de su atractivo diseño, tiene el espacio suficiente para todo y todos, gracias a su capacidad para 5 o 7 pasajeros. Está equipada con tecnología superior y atributos avanzados de seguridad."
        }
    }

    const component = render(<ProductData car={car}/>)
})