import axios from "axios";
import {useState, useEffect } from "react";

function GamesChariot() {
    const [ getGamesList, setGamesList ] = useState([]);

    useEffect(() => {
        const url = "http://localhost:8080"

        const gamesList = () => {
            axios.get(url)
                .then( response => {
                    setGamesList(response.data.content);
                    console.log(response.data);
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

export default GamesChariot;
