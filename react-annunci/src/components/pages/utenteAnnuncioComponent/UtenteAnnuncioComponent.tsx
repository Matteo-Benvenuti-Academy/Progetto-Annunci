import { type } from "os";
import { useContext } from "react";
import { Button, Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Annuncio from "../../../interfaces/Annuncio";
import convertDate from "../../../utils/ConvertDate";
import AnnunciContext from "../../context/AnnunciContext";

type delateFunction = (c:string) => void;

type Props = {
    annuncio: Annuncio,
    delateAnnuncio: delateFunction
}

function UtenteAnnuncioComponent({annuncio,delateAnnuncio}:Props) {
    

    return ( 
        <Card style={{ width: '18rem' }} className="card bg-dark text-white">
            <Card.Body>
            
                <Card.Title className='display-6'>{annuncio.titolo}</Card.Title>
            
                <Card.Text>
                    {annuncio.testo}
                </Card.Text>

                <Card.Text>
                        <i className="far fa-clock"></i>
                        {convertDate(annuncio.publicazione)}                    
                </Card.Text>

                <div className="d-grid">
                    <Button onClick={() => delateAnnuncio(annuncio.codice)} className="btn btn-danger" >Elimina</Button>

                </div>

            </Card.Body>
        </Card>
    );
}

export default UtenteAnnuncioComponent;