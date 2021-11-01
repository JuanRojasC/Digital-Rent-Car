import { Fragment } from "react";
import Footer from "../Footer/Footer";
import Header from "../Header/Header";
import { UserProvider } from "../UserContext/UserContext";

export default function Layout(props) {
	return (
		<Fragment>
			<UserProvider>
				<Header />
				{props.children}
				<Footer />
			</UserProvider>
		</Fragment>
	);
}
