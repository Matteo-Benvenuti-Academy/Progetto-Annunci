import { useContext, useRef, useState } from "react";
import { Card, Container, FloatingLabel} from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import AnnunciContext from "../../context/AnnunciContext";

function CreaAnnuncioComponent() {
    
    const { insert } = useContext(AnnunciContext);
    const [result,setResult] = useState("")

    const inputTitolo = useRef<HTMLInputElement>(null)
    const inputTesto = useRef<HTMLTextAreaElement>(null)
    const navigate = useNavigate();


    const takeInputData = async () => {
        const titolo = inputTitolo.current?.value
        if(!titolo)
            return setResult("Il titolo non può essere vuoto")
            
        const testo = inputTesto.current?.value
        if(!testo)
            return setResult("La descrizione non può essere vuota")
        
        const loginResult = await insert(titolo,testo);

        if (loginResult === "Errore di accesso")
            return navigate("/")

        if (loginResult === "")
            return navigate("/home")
        
        return setResult(loginResult)
    }
    
    return ( 
        <>
            <h1 className='display-2 mb-5'>Crea Annuncio</h1>
            <Container >
                <Card className="p-5 card bg-dark text-white">
                    
                    {result && result != "" && <div id="formAlert" className="alert alert-danger" role="alert">{result}</div>}

                    
                    <form >
                        <div className="form-floating form-outline mb-4">
                            <input type="text"  className="form-control form-control-lg bg-dark text-white" ref={inputTitolo}/>
                            <label className="form-label" >Titolo</label>
                        </div>
                        
                        <div className="form-floating form-outline mb-4">

                        <FloatingLabel controlId="floatingTextarea" label="Decsrizione" className="bg-dark text-white">
                            <textarea className="form-control form-control-lg bg-dark text-white h-100" maxLength={672} rows={6} ref={inputTesto}></textarea>
                        </FloatingLabel>

                        </div>
        
                        <Container className="w-100 d-flex justify-content-center mt-5">
                            <button onClick={takeInputData} type="button" className="btn btn-primary w-25">Crea Annuncio</button>
                        </Container>
                    </form>
                </Card>

            </Container>
        </>
     );
}

export default CreaAnnuncioComponent;