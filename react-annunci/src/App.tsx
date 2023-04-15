import React from 'react';
import AnnunciProvider from './components/context/AnnunciProvider';
import { BrowserRouter, Link, Route, Router, Routes } from 'react-router-dom'
import "bootstrap/dist/css/bootstrap.css"
import { Container, Nav, Navbar, NavDropdown } from 'react-bootstrap';
import NavbarComponent from './components/navbarComponent/NavbarComponent';
import SignUpComponent from './components/pages/signUpComponent/SignUpComponent';
import UserPageComponent from './components/pages/userPageComponent/UserPageComponent';
import CreaAnnuncioComponent from './components/pages/creaAnnuncioComponent/CreaAnnuncioComponet';
import LoginComponent from './components/pages/loginComponent/LoginComponent';
import ListaAnnunciComponent from './components/pages/listaAnnunciComponent/ListaAnnunciComponent';

function App() {
  
  return ( 

    <AnnunciProvider>
      <BrowserRouter>

        <NavbarComponent/>

        <Container className='mt-5 '>
          <Routes>
              <Route path='/' element={<ListaAnnunciComponent/>}></Route>
              <Route path='/login' element={<LoginComponent/>}></Route>
              <Route path='/signUp' element={<SignUpComponent/>}></Route>
              <Route path='/home' element={<UserPageComponent/>}></Route>
              <Route path='/creaAnnuncio' element={<CreaAnnuncioComponent/>}></Route>
          </Routes>
        </Container>

      </BrowserRouter>
    </AnnunciProvider>


  );
}
export default App;
