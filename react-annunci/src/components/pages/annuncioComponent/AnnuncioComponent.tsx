import * as React from 'react';
import { Button, Card } from 'react-bootstrap';
import Annuncio from '../../../interfaces/Annuncio';
import convertDate from '../../../utils/ConvertDate';


function AnnuncioComponent({titolo,testo,publicazione,utente}:Annuncio){

    return ( 
        <Card style={{ width: '18rem' }} className="card bg-dark text-white">
            <Card.Body>
            
                <Card.Title className='display-6'>{titolo}</Card.Title>
            
                <Card.Text>
                    {testo}
                </Card.Text>

                <Card.Text>
                        <strong>{utente.username}</strong> <br />
                        <strong>{"Telefono:"}</strong> {utente.telefono} <br/>
                        <strong>{"Email:"}</strong> {utente.email}
                </Card.Text>

                <Card.Text>
                        <i className="far fa-clock"></i>
                        {convertDate(publicazione)}                    
                </Card.Text>

            </Card.Body>
        </Card>
     );
}

export default AnnuncioComponent;