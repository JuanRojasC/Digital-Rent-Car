import React from "react";
import '@testing-library/jest-dom/extend-expect';
import { render } from "@testing-library/react";
import Intro from './Intro';

test('render content',()=>{
    const component = render(<Intro/>)
    console.log(component);
})