import {useState,useRef, useContext} from 'react';
import Nav from 'react-bootstrap/Nav';
import { Link, useNavigate } from 'react-router-dom';
import AnnunciContext from '../../context/AnnunciContext';


function LoginComponent() {

    const { login } = useContext(AnnunciContext);
    const navigate = useNavigate();
    const [result,setResult] = useState("")

    
    const inputUsername = useRef<HTMLInputElement>(null)
    const inputPass = useRef<HTMLInputElement>(null)

    const takeInputData = async () => {
        const username = inputUsername.current?.value
        if(!username)
            return setResult("Nome utente non valido")
            
        const pass = inputPass.current?.value
        if(!pass)
            return setResult("Password non valida")
        
        const loginResult = await login(username,pass);

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
                        <div className="card-body pb-5 p-5 text-center">

                            <div className="mb-md-5 mt-md-4 ">

                            <h2 className="fw-bold mb-2 text-uppercase">Accedi</h2>
                            <p className="text-white-50 mb-5">Iserisci il tuo nome utente e la tua password</p>
                            

                            {result && result != "" && <div id="formAlert" className="alert alert-danger" role="alert">{result}</div>}

                            <div className="form-floating form-outline mb-4">
                                <input type="text" id="usernameInput" className="form-control form-control-lg bg-dark text-white" ref={inputUsername}/>
                                <label className="form-label" htmlFor="usernameInput">Nome utente</label>
                            </div>
                            
                            <div className="form-floating form-outline mb-4">
                                <input type="password" id="passwordInput" className="form-control form-control-lg bg-dark text-white" ref={inputPass}/>
                                <label className="form-label " htmlFor="passwordInput">Password</label>
                            </div>

                            <button onClick={takeInputData} id="loginButton" className="btn btn-outline-light btn-lg px-5 mt-2" type="button">Accedi</button>

                            </div>

                            <div>
                                <p className="mb-0">Non hai un Account?<Nav.Link as={Link} to="/signUp" className="signUpLink fw-bold">Registrati</Nav.Link></p>
                            </div>

                        </div>
                        </div>
                    </div>
                    </div>
                </div>
            </section>
     );
}

export default LoginComponent;