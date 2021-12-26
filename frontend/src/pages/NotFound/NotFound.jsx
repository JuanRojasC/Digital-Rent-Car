import { Link } from "react-router-dom";
import "./not_found.css";

export default function NotFound() {
	return (
		<div className="page_not_found">
			<img src="/s3-bucket/props/404.png" alt="Car Sign Alert" className="not_found_page_image"/>
			<div className="not_found_page_message">
				<h2 className="not_found_title">Pagina no encontrada</h2>
				<p className="not_found_text">Parece que intentas acceder a un sitio no disponible</p>
				<Link to="/" className="not_found_btn_back_home">Volver al Inicio</Link>
			</div>
		</div>
	);
}