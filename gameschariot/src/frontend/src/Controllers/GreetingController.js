import axios from "axios";
import {useState, useEffect } from "react";

function Greeting() {
    const [ getGreeting, setGreeting ] = useState("");
    //const [ getGamesList, setGamesList ] = useState([]);

    useEffect(() => {
        const url = "http://localhost:8080"

        const defaultGreeting = () => {
            axios.get(url)
                .then( response => {
                    setGreeting(response.data.content);
                })
                .catch( error => console.log(`Error: ${error}`))
        }

        defaultGreeting();
    }, []);

    return(
        <>
            <div>{getGreeting}</div>
        </>
    );
}

export default Greeting;
