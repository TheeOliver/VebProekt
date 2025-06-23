import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import WorkspaceButton from "../components/WorkspaceButton";
import { useNavigate } from 'react-router-dom';



export default function WorkspacePage() {
    const [workspaces, setWorkspaces] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api')
            .then(res => res.json())
            .then(data => setWorkspaces(data))
            .catch(err => console.error('Error fetching workspaces:', err));
    }, []);

    const navigate = useNavigate();

    const goToCreation = () => {
        navigate('/create');
    };

    return (
        <div className={"container-fluid justify-content-center align-items-center d-flex"}
        style={{width:"100%", minHeight: '100vh'}}
        >
            <div className={"card w-50 h-75 p-5  justify-content-center d-flex"}>
                <h1 className={"d-flex justify-content-center p-3"}>
                    Workspaces
                </h1>
                <h6 className={"d-flex justify-content-center p-3"}>
                    Please choose your workspace here
                </h6>
                {workspaces.map(w => (
                    <WorkspaceButton
                        id={w.id}
                        name={w.name}
                    />
                ))}

                <button className={"btn m-2 d-flex justify-content-center align-items-center"}
                        style={{background: "rgb(244,244,244)", height:"70px", fontSize:"40px", color:"#58A7BF"}}
                        onClick={goToCreation}>
                    +
                </button>

            </div>

        </div>
    )
}

