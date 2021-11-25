import { Fragment, useState } from "react";
import { isMobile } from "react-device-detect";
import ReactImageGallery from "react-image-gallery";
import GalleryModal from "../GalleryModal/GalleryModal";

import "./gallery.css";

export default function Gallery({ images }) {
	const [isPhone] = useState(isMobile && window.innerWidth < 1000);
	const [showModal, setShowModal] = useState(false);

	const imgs = [
		{
			original: images[0].urlImage,
			thumbnail: images[0].urlImage,
		},
		{
			original: images[1].urlImage,
			thumbnail: images[1].urlImage,
		},
		{
			original: images[2].urlImage,
			thumbnail: images[2].urlImage,
		},
		{
			original: images[3].urlImage,
			thumbnail: images[3].urlImage,
		},
		{
			original: images[4].urlImage,
			thumbnail: images[4].urlImage,
		},
	];

	const handleClick = () => {
		setShowModal((prev) => !prev);
	};

	return (
		<Fragment>
			{isPhone && (
				<ReactImageGallery
					items={imgs}
					showPlayButton={false}
					showFullscreenButton={false}
					showThumbnails={false}
				/>
			)}
			{!isPhone && (
				<div className='gallery_desktop'>
					<div className='gallery_desktop_main'>
						<img src={images[0].urlImage} alt='esta es la imagen principal' />
					</div>
					<div className='gallery_desktop_secondary'>
						{images.slice(1).map((ele, i) => {
							return <img src={ele.urlImage} alt={ele + i} />;
						})}
					</div>
					<button
						onClick={handleClick}
						className='gallery_desktop_btn'
						type='button'>
						Ver mas
					</button>
					<GalleryModal
						handleModal={() => setShowModal(false)}
						img={imgs}
						show={showModal}
					/>
				</div>
			)}
		</Fragment>
	);
}
