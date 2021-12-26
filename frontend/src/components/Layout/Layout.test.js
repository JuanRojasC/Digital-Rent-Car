import React from "react";
import "@testing-library/jest-dom/extend-expect";
import userEvent from "@testing-library/user-event";
import "@testing-library/jest-dom";
import { render, fireEvent, screen, waitFor } from "../../__test__/test-utils";
import Layout from "./Layout";
import Home from "../../pages/Home/Home";
import Login from "../../pages/Login/Login";

describe("test de landing page", () => {
	it("se renderiza componente header", () => {
		const component = render(
			<Layout>
				<Home />
                <Login />
			</Layout>
		);
		expect(component).toBeDefined();
	});

	it("botton hacia login", async () => {
		const component = render(<Layout />);
		const loginBtn = component.getByTestId("login_btn");
		expect(loginBtn).toBeDefined();
		fireEvent.click(loginBtn);
        const landingPage = await component.findByText("Los mejores caminos para los mejores autos")
        expect(landingPage).toBe({})
        const login = component.getByText("Correo electrónico")
        expect(login).toBeDefined()
	});
});
