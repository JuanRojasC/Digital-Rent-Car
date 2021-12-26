import React from "react";
import '@testing-library/jest-dom/extend-expect'
import { fireEvent, render } from "../../__test__/test-utils";
import CategoryCard from './CategoryCard';

test('render content', () => {
    const category = {

        id: 1,
        titulo: "SUV",
        descripcion: "Un Sport Utility Vehicle (Vehículo Utilitario Deportivo) es un vehículo que apuesta por una estética todoterreno, pero que por sus cualidades está más orientado al asfalto. Por su tamaño y habitabilidad, ofrece más espacio y posibilidades que un turismo convencional con el añadido de poder desenvolverse fuera del asfalto gracias a su mayor altura libre con respecto al suelo, aunque casi nunca con capacidades similares a las de un todoterreno.",
        url: "/car-images/Audi_Q5-Image.png"
    }

    const index = 1;

    const component = render(<CategoryCard CategoryCard key={index} id={index} title={category.titulo} image={category.url} />)
    component.debug()
    component.getByText("SUV")

})

test('Clicking the category and change of styles on click ', () => {
    const category = {

        id: 1,
        titulo: "SUV",
        descripcion: "Un Sport Utility Vehicle (Vehículo Utilitario Deportivo) es un vehículo que apuesta por una estética todoterreno, pero que por sus cualidades está más orientado al asfalto. Por su tamaño y habitabilidad, ofrece más espacio y posibilidades que un turismo convencional con el añadido de poder desenvolverse fuera del asfalto gracias a su mayor altura libre con respecto al suelo, aunque casi nunca con capacidades similares a las de un todoterreno.",
        url: "/car-images/Audi_Q5-Image.png"
    }

    const index = 1;

    const mockHandler = jest.fn()
    const component = render(<CategoryCard CategoryCard key={index} id={index} title={category.titulo} image={category.url} setCategoryClicked={mockHandler} />)
    const btn = component.container.querySelector("#category_SUV")
    fireEvent.click(btn)

    expect(mockHandler.mock.calls).toHaveLength(1)
})