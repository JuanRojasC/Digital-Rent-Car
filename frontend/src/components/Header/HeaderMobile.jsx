import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBars, faTimes } from '@fortawesome/free-solid-svg-icons';
import { faFacebook, faTwitter, faInstagram, faYoutube } from '@fortawesome/free-brands-svg-icons';
import "./header.css";

export default function HeaderMobile({userLogged, userData, logOut, setMenuDeploy}){

    return(
        !userLogged? 
            <>
                <FontAwesomeIcon icon={faBars} className="header_bar_menu" onClick={()=>setMenuDeploy(true)}/>
            </>
        :
            <>
                <div className='btns_nav_header'>

                </div>
                <FontAwesomeIcon icon={faBars} className="header_bar_menu" onClick={()=>setMenuDeploy(true)}/>
                <div className='btns_nav_header_menu_mobile'>
                    <FontAwesomeIcon icon={faTimes} className="header_close_menu_mobile" onClick={()=>setMenuDeploy(false)}/>
                    <div className="menu_title_nav_header_mobile">
                        <div className="nav_header_profile_user">
                            <div className="circle_user_profile">{userData.nombre.slice(0,1)+userData.apellido.slice(0,1)}</div>
                            <p className="user_profile_greeting">Hola</p>
                            <p className="user_title">{userData.nombre+ " " + userData.apellido}</p>
                        </div>
                    </div>
                    <Link to='/' className='btn_nav_header_mobile' onClick={()=>setMenuDeploy(false)}>Inicio</Link>
                    <hr className="line_horizontal_menu_mobile"/>
                    <Link to='/' className='btn_nav_header_mobile' id="btn_logout_mobile" onClick={()=>{setMenuDeploy(false);logOut()}}>Cerrar sesion</Link>
                    <hr className="line_horizontal_menu_mobile"/>
                    <div className="social_networks_logos_mobile_menu">
                        <Link to=""><FontAwesomeIcon icon={faFacebook} className="icon_social_network_mobile_menu"/></Link>
                        <Link to=""><FontAwesomeIcon icon={faYoutube} className="icon_social_network_mobile_menu"/></Link>
                        <Link to=""><FontAwesomeIcon icon={faInstagram} className="icon_social_network_mobile_menu"/></Link>
                        <Link to=""><FontAwesomeIcon icon={faTwitter} className="icon_social_network_mobile_menu"/></Link>
                    </div>
                </div>
            </>
    );
}