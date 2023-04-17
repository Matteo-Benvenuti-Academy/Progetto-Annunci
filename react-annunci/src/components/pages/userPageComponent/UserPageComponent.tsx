import { useContext, useEffect } from "react";
import { Col, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Annuncio from "../../../interfaces/Annuncio";
import AnnunciContext from "../../context/AnnunciContext";
import UtenteAnnuncioComponent from "../utenteAnnuncioComponent/UtenteAnnuncioComponent";

function UserPageComponent() {
    const { delate, annunciUtente,refreshAnnunciUtente} = useContext(AnnunciContext);
    const navigate = useNavigate();

    useEffect(() => {
        const result = refreshAnnunciUtente()

        if(result === "Errore di accesso")
            return navigate("/")
    },[])

    const delateAnnuncio = async (codice:string) =>{
        const response = delate(codice)

        if (response === "Errore di accesso")
            return navigate("/")
    }


    return ( 
        <div>
            <h1 className='display-2 mb-5'>I miei Annunci</h1>
            <Row>
            {annunciUtente.map((obj:Annuncio,idx:number) => (
                <Col  key={idx} md={3} className="mb-5">
                    <UtenteAnnuncioComponent
                        annuncio={obj}
                        delateAnnuncio = {delateAnnuncio}
                        />
                </Col>
            ))}
            </Row>
        </div>
    );
}

export default UserPageComponent;