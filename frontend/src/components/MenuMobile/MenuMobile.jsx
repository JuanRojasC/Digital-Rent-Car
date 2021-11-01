import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTimes } from '@fortawesome/free-solid-svg-icons';
import { faFacebook, faTwitter, faInstagram, faYoutube } from '@fortawesome/free-brands-svg-icons';
import "./menu_mobile.css";

export default function MenuMobile({setMenuDeploy}){
    return(
        <div className='header_menu_mobile'>
            <div className="header_menu_mobile_div">
                <FontAwesomeIcon icon={faTimes} className="header_close_menu_mobile" onClick={()=>setMenuDeploy(false)}/>
                <h3 className="menu_title_nav_header_mobile">MENU</h3>
                <Link to='/' className='btn_nav_header_mobile' onClick={()=>setMenuDeploy(false)}>Inicio</Link>
                <hr className="line_horizontal_menu_mobile"/>
                <Link to='/login' className='btn_nav_header_mobile' onClick={()=>setMenuDeploy(false)}>Login</Link>
                <hr className="line_horizontal_menu_mobile"/>
                <Link to='/registro' className='btn_nav_header_mobile' onClick={()=>setMenuDeploy(false)}>Registrarse</Link>
                <div className="social_networks_logos_mobile_menu">
                    <Link to=""><FontAwesomeIcon icon={faFacebook} className="icon_social_network_mobile_menu"/></Link>
                    <Link to=""><FontAwesomeIcon icon={faYoutube} className="icon_social_network_mobile_menu"/></Link>
                    <Link to=""><FontAwesomeIcon icon={faInstagram} className="icon_social_network_mobile_menu"/></Link>
                    <Link to=""><FontAwesomeIcon icon={faTwitter} className="icon_social_network_mobile_menu"/></Link>
                </div>
            </div>
        </div>
    );
}