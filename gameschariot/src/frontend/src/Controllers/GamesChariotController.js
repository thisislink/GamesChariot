import axios from "axios";
import {useState, useEffect } from "react";

function Greeting() {
    const [ getGamesList, setGamesList ] = useState([]);

    useEffect(() => {
        const url = "http://localhost:8080"

        const gamesList = () => {
            axios.get(url)
                .then( response => {
                    setGamesList(response.data.content);
                })
                .catch( error => console.log(`Error: ${error}`))
        }

        gamesList();
    }, []);

    return(
        <>
            <div>{getGamesList}</div>
        </>
    );
}

export default Greeting;
