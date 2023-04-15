import Utente from "./Utente";

export default interface Annuncio{
    codice: string,
    titolo?: string,
    testo?:string,
    publicazione?:string,
    utente:Utente   
}