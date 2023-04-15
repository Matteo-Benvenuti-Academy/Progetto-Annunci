import React,{useContext, useRef, useState} from 'react';
import { Nav } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import AnnunciContext from '../../context/AnnunciContext';

function SignUpComponent() {

    const { signUp } = useContext(AnnunciContext);
    const [result,setResult] = useState("");
    const navigate = useNavigate();

    const inputUsername = useRef<HTMLInputElement>(null)
    const inputPass = useRef<HTMLInputElement>(null)
    const inputEmail = useRef<HTMLInputElement>(null)
    const inputTelefono = useRef<HTMLInputElement>(null)


    const takeInputData = async () => {
        const username = inputUsername.current?.value
        if(!username)
            return setResult("Nome utente non valido")

        const pass = inputPass.current?.value
        if(!pass)
            return setResult("Password non valida")

        const email = inputEmail.current?.value
        if(!email)
        return setResult("Email non valida")
            
        const telefono = inputTelefono.current?.value
        if(!telefono)
            return setResult("Numero di Telefono non valido")
        
        const loginResult = await signUp(username,pass,email,telefono);

        if (loginResult === "")
            return navigate("/home")
        
        return setResult(loginResult)
    }

    return ( 
        <section>
            <div className="container h-100">
            <div className="row d-flex justify-content-center align-items-center h-100">
                <div className="col-12 col-md-8 col-lg-6 col-xl-5">
                <div className="card bg-dark text-white">
                    <div className="card-body pb-1 p-5 text-center">
        
                    <div className="mb-md-5 mt-md-4 pb-1">
        
                        <h2 className="fw-bold mb-2 text-uppercase">Registrati</h2>
                        <p className="text-white-50 mb-5">Inserisci la tua email, e scegli il nome utente e la password</p>
                        
                        {result && result != "" && <div id="formAlert" className="alert alert-danger" role="alert">{result}</div>}


                        <div className="form-floating form-outline mb-4">
                        <input type="text" id="usernameInput" className="form-control form-control-lg bg-dark text-white" ref={inputUsername}/>
                        <label className="form-label" htmlFor="usernameInput">Nome utente</label>
                        </div>
                        
                        <div className="form-floating form-outline mb-4">
                        <input type="password" id="passwordInput" className="form-control form-control-lg bg-dark text-white" ref={inputPass}/>
                        <label className="form-label " htmlFor="passwordInput">Password</label>
                        </div>
        
                        <div className="form-floating form-outline mb-4">
                            <input type="email" id="emailInput" className="form-control form-control-lg bg-dark text-white" ref={inputEmail}/>
                            <label className="form-label " htmlFor="emailInput">Email</label>
                        </div>

                        <div className="form-floating form-outline mb-4">
                            <input type="text" id="telefonoInput" className="form-control form-control-lg bg-dark text-white" ref={inputTelefono}/>
                            <label className="form-label " htmlFor="telefonoInput">Numero di Telefono</label>
                        </div>

                        <button onClick= {takeInputData} id="loginButton" className="btn btn-outline-light btn-lg px-5 mt-2" type="button">Registrati</button>
        
                    </div>
        
                    <div>
                        <p className="mb-0">Hai gia un Account?<Nav.Link as={Link} to="/login" className=" signUpLink fw-bold">Accedi</Nav.Link></p>
                    </div>
        
                    </div>

                </div>
                </div>
            </div>
            </div>
        </section>
     );
}

export default SignUpComponent;