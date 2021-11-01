import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBars, faTimes } from '@fortawesome/free-solid-svg-icons';
import { faFacebook, faTwitter, faInstagram, faYoutube } from '@fortawesome/free-brands-svg-icons';
import "./header.css";

export default function HeaderMobile({userLogged, userData, logOut, setMenuDeploy}){

    return(
        <FontAwesomeIcon icon={faBars} className="header_bar_menu" onClick={()=>setMenuDeploy(true)}/>
    );
}