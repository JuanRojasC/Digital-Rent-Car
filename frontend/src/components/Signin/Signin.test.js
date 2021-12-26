import React from "react";
import '@testing-library/jest-dom/extend-expect'
import { render } from "../../__test__/test-utils";
import Signin from "./Signin";

test('render content',()=>{
    const component = render(<Signin/>)
})