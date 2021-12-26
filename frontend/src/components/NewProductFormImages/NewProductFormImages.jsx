import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faPlusCircle, faFileImage, faLink } from "@fortawesome/free-solid-svg-icons";
import "./newProductFormImages.css";

export default function NewProductFormImages({ imageIndex, setImageIndex }) {
	
    const [ displayImages ] = useState(false);

    useEffect(() => {
        // const addNewImageInput = () => {
        //     document.querySelector("#form_new_product_group_images_gallery").innerHTML += `
        //     <div class='form_new_product_group_images form_new_product_group'>
        //         <input name="image_vehicle_${imageIndex}" id="input_text_new_product_image_gallery" class="input_text_new_product_image_gallery input_text_new_product_images" placeholder="url" autocomplete="off"/>
        //         <div class="form_new_product_image_type_input">
        //             <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="file-image" class="svg-inline--fa fa-file-image fa-w-12 icon_type_input_file form_new_image_icon_type_input" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512"><path fill="currentColor" d="M384 121.941V128H256V0h6.059a24 24 0 0 1 16.97 7.029l97.941 97.941a24.002 24.002 0 0 1 7.03 16.971zM248 160c-13.2 0-24-10.8-24-24V0H24C10.745 0 0 10.745 0 24v464c0 13.255 10.745 24 24 24h336c13.255 0 24-10.745 24-24V160H248zm-135.455 16c26.51 0 48 21.49 48 48s-21.49 48-48 48-48-21.49-48-48 21.491-48 48-48zm208 240h-256l.485-48.485L104.545 328c4.686-4.686 11.799-4.201 16.485.485L160.545 368 264.06 264.485c4.686-4.686 12.284-4.686 16.971 0L320.545 304v112z"></path></svg>
        //             <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link fa-w-16  icon_type_input_link form_new_image_icon_type_input" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M326.612 185.391c59.747 59.809 58.927 155.698.36 214.59-.11.12-.24.25-.36.37l-67.2 67.2c-59.27 59.27-155.699 59.262-214.96 0-59.27-59.26-59.27-155.7 0-214.96l37.106-37.106c9.84-9.84 26.786-3.3 27.294 10.606.648 17.722 3.826 35.527 9.69 52.721 1.986 5.822.567 12.262-3.783 16.612l-13.087 13.087c-28.026 28.026-28.905 73.66-1.155 101.96 28.024 28.579 74.086 28.749 102.325.51l67.2-67.19c28.191-28.191 28.073-73.757 0-101.83-3.701-3.694-7.429-6.564-10.341-8.569a16.037 16.037 0 0 1-6.947-12.606c-.396-10.567 3.348-21.456 11.698-29.806l21.054-21.055c5.521-5.521 14.182-6.199 20.584-1.731a152.482 152.482 0 0 1 20.522 17.197zM467.547 44.449c-59.261-59.262-155.69-59.27-214.96 0l-67.2 67.2c-.12.12-.25.25-.36.37-58.566 58.892-59.387 154.781.36 214.59a152.454 152.454 0 0 0 20.521 17.196c6.402 4.468 15.064 3.789 20.584-1.731l21.054-21.055c8.35-8.35 12.094-19.239 11.698-29.806a16.037 16.037 0 0 0-6.947-12.606c-2.912-2.005-6.64-4.875-10.341-8.569-28.073-28.073-28.191-73.639 0-101.83l67.2-67.19c28.239-28.239 74.3-28.069 102.325.51 27.75 28.3 26.872 73.934-1.155 101.96l-13.087 13.087c-4.35 4.35-5.769 10.79-3.783 16.612 5.864 17.194 9.042 34.999 9.69 52.721.509 13.906 17.454 20.446 27.294 10.606l37.106-37.106c59.271-59.259 59.271-155.699.001-214.959z"></path></svg>
        //         </div>
        //     </div>
        //     `;
        // }
        // if(imageIndex > 1) addNewImageInput();
    }, [imageIndex])

    const changeTypeInput = () => {

    }

	return displayImages ? (
        <div className='form_new_product_divider'>
			<h3>Imagenes de color</h3>
			<h3>Imagenes generales</h3>
        </div>
	) : (
		<div className='form_new_product_divider_images_color'>
			<h3>Principales</h3>
            {/* <button onClick={()=>{setDisplayImages(prev =>!prev)}}>images</button> */}
            <div className='form_new_product_group_images form_new_product_group'>
                <div className="form_new_product_color_div">
                    <div className="form_new_product_image_color form_new_product_image_color_white"></div>
                    <p>White:</p>
                </div>
                <input name="image_vehicle_White" id="image_vehicle_White" className="input_text_new_product_images" placeholder="url*" required autoComplete="off"/>
                <div className="form_new_product_image_type_input">
                    <FontAwesomeIcon icon={faFileImage} className="icon_type_input_file form_new_image_icon_type_input" onClick={changeTypeInput}/>
                    <FontAwesomeIcon icon={faLink} className=" icon_type_input_link form_new_image_icon_type_input" onClick={changeTypeInput}/>
                </div>
            </div>
            <div className='form_new_product_group_images form_new_product_group'>
                <div className="form_new_product_color_div">
                    <div className="form_new_product_image_color form_new_product_image_color_red"></div>
                    <p>Red:</p>
                </div>
                <input name="image_vehicle_Red" className="input_text_new_product_images" placeholder="url" autoComplete="off"/>
                <div className="form_new_product_image_type_input">
                    <FontAwesomeIcon icon={faFileImage} className="icon_type_input_file form_new_image_icon_type_input" onClick={changeTypeInput}/>
                    <FontAwesomeIcon icon={faLink} className=" icon_type_input_link form_new_image_icon_type_input" onClick={changeTypeInput}/>
                </div>
            </div>
            <div className='form_new_product_group_images form_new_product_group'>
                <div className="form_new_product_color_div">
                    <div className="form_new_product_image_color form_new_product_image_color_blue"></div>
                    <p>Blue:</p>
                </div>
                <input name="image_vehicle_Blue" className="input_text_new_product_images" placeholder="url" autoComplete="off"/>
                                <div className="form_new_product_image_type_input">
                    <FontAwesomeIcon icon={faFileImage} className="icon_type_input_file form_new_image_icon_type_input" onClick={changeTypeInput}/>
                    <FontAwesomeIcon icon={faLink} className=" icon_type_input_link form_new_image_icon_type_input" onClick={changeTypeInput}/>
                </div>
            </div>
            <div className='form_new_product_group_images form_new_product_group'>
                <div className="form_new_product_color_div">
                    <div className="form_new_product_image_color form_new_product_image_color_black"></div>
                    <p>Black:</p>
                </div>
                <input name="image_vehicle_Black" className="input_text_new_product_images" placeholder="url" autoComplete="off"/>
                                <div className="form_new_product_image_type_input">
                    <FontAwesomeIcon icon={faFileImage} className="icon_type_input_file form_new_image_icon_type_input" onClick={changeTypeInput}/>
                    <FontAwesomeIcon icon={faLink} className=" icon_type_input_link form_new_image_icon_type_input" onClick={changeTypeInput}/>
                </div>
            </div>
			<h3>Galeria</h3>
            <div id="form_new_product_group_images_gallery">
                {Array.apply(null, Array(imageIndex)).map((image,index) => {
                    return(
                        <div className='form_new_product_group_images form_new_product_group' key={index}>
                            <input name={`image_vehicle_${imageIndex}`} id="input_text_new_product_image_gallery" className="input_text_new_product_images" placeholder="url"/>
                            <div className="form_new_product_image_type_input">
                                <FontAwesomeIcon icon={faFileImage} className="icon_type_input_file form_new_image_icon_type_input" onClick={changeTypeInput}/>
                                <FontAwesomeIcon icon={faLink} className=" icon_type_input_link form_new_image_icon_type_input" onClick={changeTypeInput}/>
                            </div>
                        </div>
                    );
                })}
            </div>
            <div className="btn_add_new_image" onClick={() => setImageIndex(prev => prev + 1)}>
                <FontAwesomeIcon icon={faPlusCircle} className="new_image_icon" />
                Add New
            </div>
        </div>
	);
}