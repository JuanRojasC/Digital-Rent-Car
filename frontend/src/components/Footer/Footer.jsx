import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFacebook, faTwitter, faInstagram, faYoutube } from '@fortawesome/free-brands-svg-icons';
import logo from "../../Assets/Digital Rent Car Company - Light.png";
import "./footer.css";

export default function Footer() {
    return (
        <div className="footer_page">
            <div className="footer_page_logo_div">
                <img src={logo} alt="Logo de la Compañia" className="logo_company_footer"/>
            </div>
            <p>© 2021 Todos los derechos reservados</p>
            <div className="footer_page_links_div">
                <ul>
                    <li>
                        <Link to="" className="footer_page_link">Alquilar</Link>
                    </li>
                    <li>
                        <Link to="" className="footer_page_link">Servicios</Link>
                    </li>
                    <li>
                        <Link to="" className="footer_page_link">Terminos</Link>
                    </li>
                </ul>
                <ul>
                    <li>
                        <Link to="" className="footer_page_link">Nosotros</Link>
                    </li>
                    <li>
                        <Link to="" className="footer_page_link">Anunciese</Link>
                    </li>
                    <li>
                        <Link to="" className="footer_page_link">Empleo</Link>
                    </li>
                </ul>
                <ul>
                    <li>
                        <Link to="" className="footer_page_link">Contactenos</Link>
                    </li>
                    <li>
                        <Link to="" className="footer_page_link">Ubicaciones</Link>
                    </li>
                    <li>
                        <Link to="" className="footer_page_link">Ayuda</Link>
                    </li>
                </ul>
            </div>
            <div className="social_networks_logos">
                <Link to=""><FontAwesomeIcon icon={faFacebook} className="icon_social_network_footer"/></Link>
                <Link to=""><FontAwesomeIcon icon={faYoutube} className="icon_social_network_footer"/></Link>
                <Link to=""><FontAwesomeIcon icon={faInstagram} className="icon_social_network_footer"/></Link>
                <Link to=""><FontAwesomeIcon icon={faTwitter} className="icon_social_network_footer"/></Link>
            </div>
        </div>
    )
}
