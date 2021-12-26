import React from "react";
import '@testing-library/jest-dom/extend-expect'
import userEvent from '@testing-library/user-event';
import '@testing-library/jest-dom';
import { render,fireEvent ,screen,waitFor} from "../../__test__/test-utils";
import Header from './Header';

describe('test de Header',()=>{
    it("se renderiza componente header",()=>{
        const component = render(<Header/>)
    })
})