import { Link } from 'react-router-dom';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useContext } from 'react';
import AnnunciContext from '../context/AnnunciContext';

export default function NavbarComponent() {
  
  const {logUser, logout} = useContext(AnnunciContext);
  
  const loginLink = ( <Nav  className='ms-auto'>
                        <Nav.Link as={Link} className="navbar-brand text-white border-left" to="/login"> Login</Nav.Link >
                      </Nav>)
  
  const logOut = (<Nav  className='ms-auto'>
                     <Nav.Link onClick = {logout} as={Link} className="navbar-brand text-white border-left" to="/"> Logout </Nav.Link >
                  </Nav>)

  const userPage = (<Nav>
                      <Nav.Link as={Link} className="navbar-brand text-white" to="/home"> I miei Annunci  </Nav.Link >
                    </Nav>)

  const creaAnnuncio = (<Nav>
                          <Nav.Link as={Link} className="navbar-brand text-white" to="/creaAnnuncio"> Crea annuncio </Nav.Link >
                        </Nav>)


  return (
    
    <Navbar collapseOnSelect expand="lg" variant="dark" className="bg-dark">
        <Nav>
            <Nav.Link as={Link} className="navbar-brand text-white" to="/"> &nbsp; Avvisi </Nav.Link >
        </Nav>

        { logUser && userPage}
        
        { logUser && creaAnnuncio}  

        { logUser ? logOut : loginLink}    

    </Navbar>

  );
}