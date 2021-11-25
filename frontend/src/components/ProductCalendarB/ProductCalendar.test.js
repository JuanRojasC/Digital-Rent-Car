import React from "react";
import '@testing-library/jest-dom/extend-expect'
import { render } from "@testing-library/react";
import ProductCalendar from './ProductCalendar';

test('render content',()=>{
    const component = render(<ProductCalendar/>)
    console.log(component);
})