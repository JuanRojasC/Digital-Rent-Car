import React from "react";
import '@testing-library/jest-dom/extend-expect'
import { render } from "@testing-library/react";
import Signin from "./Signin";

test('render content',()=>{
    const component = render(<Signin/>)
    console.log(component);
})