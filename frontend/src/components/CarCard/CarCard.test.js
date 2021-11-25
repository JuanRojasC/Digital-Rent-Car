import React from "react";
import '@testing-library/jest-dom/extend-expect'
import { fireEvent, render } from "@testing-library/react"
import CarCard from './CarCard';

test('render content',()=>{
    const car ={
        id: 2,
        img: "/car-images/Chevrolet_Camaro-Image.png",
        category: "Deportive",
        title: "Test 1 Chevrolet Camaro",
        location: "ARG/COL",
        description : {
            engine: "455 HP",
            airConditioning: false,
            seats: 4,
            type: "Gasolina"
        }
    }

    const index = 1;

    const component = render(<CarCard car={car} key={index}/>)
    expect(component.container).toHaveTextContent(car.title)
    component.getByText("Gasolina")
    component.getByText("ARG/COL")
})