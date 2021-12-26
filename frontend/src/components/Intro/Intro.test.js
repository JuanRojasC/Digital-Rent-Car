import React from "react";
import '@testing-library/jest-dom/extend-expect';
import { render } from "../../__test__/test-utils";
import Intro from './Intro';

test('render content',()=>{
    const component = render(<Intro/>)
})