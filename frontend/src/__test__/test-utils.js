import React from "react";
import { render } from "@testing-library/react";
import { UserProvider } from "../Hooks/UserContext/UserContext";
import { ProductListProvider } from "../Hooks/ProductListContext/ProductListContext";
import { BrowserRouter } from "react-router-dom";

const AllTheProviders = ({ children}) => {
	return (
		<BrowserRouter>
			<UserProvider>
				<ProductListProvider>{children}</ProductListProvider>
			</UserProvider>
		</BrowserRouter>
	);
};

const customRender = (ui, options) =>
	render(ui, { wrapper: AllTheProviders, ...options });

// re-export everything
export * from "@testing-library/react";

// override render method
export { customRender as render };
