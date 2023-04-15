import { useState } from 'react'
import axios from 'axios'
import AnnunciContext from './AnnunciContext'

const AnnunciProvider = ({children}) => {

    const [annunci, setAnnunci] = useState([]);
    const [annunciUtente,setAnnunciUtente] = useState([]);
    const [logUser,setLogUser] = useState(null)

    const  refreshAnnunci = async () => {
        const annunci = await findAllAnnunci()
        setAnnunci(annunci)
    }

    const login = async (username,pass) => {
        return await userLogin(username,pass);
    }

    const logout = () => {
        setLogUser(null)
    }

    const signUp = async (username,pass,email,telefono) => {
        return await userSignUp(username,pass,email,telefono)
    }

    const insert = async (titolo,testo) => {
        return await insertAnnuncio(titolo,testo)
    }

    const refreshAnnunciUtente = async () => {
        const annunci = await findAnnunciUtente()
        
        if (annunci == "Errore di accesso")
        return "Errore di accesso";
        
        if (!annunci)
        return setAnnunciUtente([])
        
        console.log([...annunci])
        return setAnnunciUtente( annunciUtente => [...annunci])

    }

    const delate = async (codice) => {
        const annuncioCancellato = await daleteAnnuncio(codice)
        if (annuncioCancellato === "Errore di accesso")
            return "Errore di accesso"
    }

    async function daleteAnnuncio(codice){
        if(!logUser)
            return "Errore di accesso"
        

        axios.delete("http://localhost:8080/Annunci/utente/rimoviAnnuncio",{
            data:{
                codice,
                utente:logUser
            }
        }).then((response) =>{
            if(response.data.status === "ok")
                return response.data.data;
            else
                return null;
        }).catch(errore => console.log(errore))
    }

    async function findAnnunciUtente(){
        if(!logUser)
            return "Errore di accesso"

        return axios.post("http://localhost:8080/Annunci/utente/listaAnnunci",logUser)
        .then((response) =>{
            if(response.data.status === "ok")
                return response.data.data
        }).catch(errore => console.log(errore))
    }
    
    async function findAllAnnunci(){
        return axios.get("http://localhost:8080/Annunci")
        .then((response) =>{
            if(response.data.status === "ok")
                return response.data.data
        }).catch(errore => console.log(errore))
    }
    
    async function userLogin(username,pass){
        return axios.post("http://localhost:8080/Annunci/utente/login",{
            username,
            pass
        })
        .then((response) => {
            if(response.data.status === "ok"){
                setLogUser(response.data.data)
                return "";
            }else{
                return "Nome utente o password non validi!"
            }
        }).catch(errore => {return "Errore! Riprova."});
    }

    async function userSignUp(username,pass,email,telefono) {
        return axios.post("http://localhost:8080/Annunci/utente/registrati",{
            username,
            pass,
            email,
            telefono
        })
        .then((response) => {
            if(response.data.status === "ok"){
                setLogUser(response.data.data)
                return "";
            }else{
                return "Dati non validi!"
            }
        }).catch(errore => {return "Errore! Riprova."});
    }

    async function insertAnnuncio(titolo,testo) {
        if(!logUser)
            return "Errore di accesso"
        
        return axios.post("http://localhost:8080/Annunci/utente/creaAnnuncio",{
            titolo,
            testo,
            utente:logUser
        })
        .then((response) => {
            if(response.data.status === "ok"){
                return "";
            }else{
                return "Dati non validi!"
            }
        }).catch(errore => {return "Errore! Riprova."});
    }

    return (
        <AnnunciContext.Provider value={ 
            { annunci, refreshAnnunci, logUser, login , logout , signUp , insert,
              annunciUtente , refreshAnnunciUtente , delate 
            } }>
            {children}
        </AnnunciContext.Provider>
    )
} 

export default AnnunciProvider;


