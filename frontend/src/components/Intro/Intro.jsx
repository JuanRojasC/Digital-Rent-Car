import introImage from "../../Assets/Intro_Car-Image.png";
import "./intro.css";

export default function Intro(){
    return(
        <div className="intro_landing_page">
            <section className="intro_landing_page_text_section">
                <div className="intro_landing_page_text">
                    <h2>Los mejores caminos para los mejores autos</h2>
                    <p>Elija un automovil para todas la ocasiones, carretera, offroad, pista o familia.</p>
                    <a href="#car-options" className="intro_landing_page_btn_rent">Alquilar</a>
                </div>
                <div className="intro_image_family_car">
                    <img src={introImage} alt="Car with family board" className="intro_car_family_image"/>
                    <div className="intro_circle_yellow"></div>
                </div>
            </section>
            <section className="intro_landing_page_finder_section">
                <form action="" className="intro_landing_page_form_finder">
                    <select name="intro_landing_page_finder_select_location" id="intro_landing_page_finder_select_location" defaultValue="Ubicacion">
                        <option value="Ubicacion" disabled hidden>Ubicación</option>
                        <option value="Bogotá DC">Bogotá DC</option>
                        <option value="Ciudad de Buenos Aires">Ciudad de Buenos Aires</option>
                    </select>
                    <input type="date" id= "intro_landing_page_finder_select_fecha_recepcion" name="intro_landing_page_finder_select_fecha_recepcion" placeholder="Fecha de Recepción"/>
                    <input type="date" id= "intro_landing_page_finder_select_fecha_regreso" name="intro_landing_page_finder_select_fecha_regreso" placeholder="Fecha de Regreso"/>
                    <button className="intro_landing_page_finder_btn_buscar" type="submit">Buscar</button>
                </form>
            </section>
        </div>
    );
}