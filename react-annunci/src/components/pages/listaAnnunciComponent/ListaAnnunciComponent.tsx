import React,{useContext, useEffect} from 'react';
import { Col, Row } from 'react-bootstrap';
import Annuncio from '../../../interfaces/Annuncio';
import AnnunciContext from '../../context/AnnunciContext';
import AnnuncioComponent from '../annuncioComponent/AnnuncioComponent';


function ListaAnnunciComponent() {
    
    const {annunci,refreshAnnunci} = useContext(AnnunciContext);
    
    useEffect(() => {
        refreshAnnunci()
    },[])

    return ( 
        <div>
            <h1 className='display-2 mb-5'>Tutti gli annunci</h1>
            <Row>
            {annunci.map((obj:Annuncio,idx:number) => (
                <Col  key={idx} md={3} className="mb-5">
                    <AnnuncioComponent
                        codice = {obj.codice}
                        titolo={obj.titolo} 
                        testo={obj.testo}  
                        publicazione={obj.publicazione}
                        utente={obj.utente}/>
                </Col>
            ))}
            </Row>
        </div>
    );
}

export default ListaAnnunciComponent;