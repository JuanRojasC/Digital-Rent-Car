import { Fragment, useState } from "react";
import GalleryModal from "../GalleryModal/GalleryModal";
import "./gallery.css";

export default function Gallery({ images }) {
	const [ showModal, setShowModal ] = useState(false);

	return (
		<Fragment>
			<div className="gallery_square">
				{images.map((image, index) => index <= 3? <img src={image.urlImage} className="square_image" key={index} alt="gallery product" /> : "")}
				<button className="btn_view_more_gallery" onClick={()=>setShowModal((prev) => !prev)}>Ver más</button>
				<GalleryModal handleModal={() => setShowModal(false)} images={images} show={showModal} />
			</div>
		</Fragment>
	);
}
