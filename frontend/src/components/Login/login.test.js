import React from "react";
import '@testing-library/jest-dom/extend-expect'
import { render } from "@testing-library/react";
import Login from './Login';

test('render content',()=>{
    const component = render(<Login/>)
    console.log(component);
})