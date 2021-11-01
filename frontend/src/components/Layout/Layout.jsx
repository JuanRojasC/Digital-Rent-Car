import { Fragment } from "react";
import Footer from "../Footer/Footer";
import Header from "../Header/Header";
import { UserProvider } from "../UserContext/UserContext";

export default function Layout(props) {
	return (
		<Fragment>
			<UserProvider>
				<Header headerMain={props.headerMain}/>
				{props.children}
				<Footer />
			</UserProvider>
		</Fragment>
	);
}
