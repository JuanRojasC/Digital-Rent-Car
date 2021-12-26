import React from "react";
import '@testing-library/jest-dom/extend-expect'
import { render } from "@testing-library/react";
import Icon from './Icon';

test('render content',()=>{
    const component = render(<Icon/>)
})