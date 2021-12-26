import React from "react";
import "@testing-library/jest-dom/extend-expect";
import userEvent from "@testing-library/user-event";
import "@testing-library/jest-dom";
import { render, fireEvent, screen, waitFor } from "../../__test__/test-utils";
import Home from "./Home";

describe("test de landing page", () => {
	it("se renderiza componente header", () => {
		const component = render(<Home />);
        expect(component).toBeDefined()
	});
});
