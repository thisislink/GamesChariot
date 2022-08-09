import axios from "axios";
import {useState, useEffect } from "react";

function GamesChariotApi() {
    const [ getConfigs, setConfigs ] = useState([]);

    useEffect(() => {
        const url = "http://localhost:8080/api"

        const gamesList = () => {
            axios.get(url)
                .then(response => {
                    const updatedConfigs = {
                        apiUrl: response.data.apiUrl,
                        databaseServer: response.data.databaseServer,
                        databaseUsername: response.data.databaseUsername,
                        databasePassword: response.data.databasePassword,
                    };
                    setConfigs([updatedConfigs])
                })
                .catch( error => console.log(`Error: ${error}`))
        }
        gamesList();
    }, []);

    return(
        <>
            <ul>
                {getConfigs.map((configItem) =>
                    (
                        <div key={Math.random()}>
                    <li key={Math.random()}>apiUrl: {configItem.apiUrl}</li>
                    <li key={Math.random()}>databaseServer: {configItem.databaseServer}</li>
                    <li key={Math.random()}>databaseUsername: {configItem.databaseUsername}</li>
                    <li key={Math.random()}>databasePassword: {configItem.databasePassword}</li>
                        </div>
                ))}
            </ul>
        </>
    );
}

export default GamesChariotApi;
