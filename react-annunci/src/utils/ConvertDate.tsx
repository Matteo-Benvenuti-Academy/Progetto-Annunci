
export default function convertDate(date:string | undefined):string{
    let formatDate= "  "
    if(date){
        formatDate+= date.slice(8,10)+"/"
        formatDate+= date.slice(5,7)+"/"
        formatDate+= date.slice(0,4)

        formatDate+= "  " +date.slice(11,16)

        return formatDate
    }

    return ""
}