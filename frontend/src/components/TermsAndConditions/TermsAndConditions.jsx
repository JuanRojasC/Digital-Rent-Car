import "./terms_and_conditions.css";

export default function TermsAndConditions({termsAndConditions}){

    return(
        <div className="product_terms_and_conditions">
            <h3 className="terms_and_conditions_title" >Terminos y Condiciones</h3>
            <div className="terms_and_conditions_divs">
                {termsAndConditions.map((tyC, index) => 
                    <div className="term_and_condition" key={index}>
                        <img src={tyC.icon?.urlImage} alt="Term And Condition Icon" className="term_and_condition_icon" />
                        <div className="term_and_condition_text_div">
                            <p className="term_and_condition_title">{tyC.title}</p>
                            <p className="term_and_condition_description">{tyC.description}</p>
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
}