import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import MetricOrderPopup from "../components/MetricOrderPopup";
import MetricList from "../components/MetricList";
import MetricPreviewPopup from "../components/MetricPreviewPopup";



export default function WorkspacePage() {
    const [workspaces, setWorkspaces] = useState([]);
    const [configurations, setConfigurations] = useState([])
    const [metrics, setMetrics] = useState([])

    useEffect(() => {
        fetch('http://localhost:8080/workspace')
            .then(res => res.json())
            .then(data => setWorkspaces(data))
            .catch(err => console.error('Error fetching workspaces:', err));
    }, []);

    useEffect(() => {
        fetch('http://localhost:8080/configuration')
            .then(res => res.json())
            .then(data => setConfigurations(data))
            .catch(err => console.error('Error fetching configurations:', err));
    }, []);

    useEffect(() => {
        fetch('http://localhost:8080/metric')
            .then(res => res.json())
            .then(data => setMetrics(data))
            .catch(err => console.error('Error fetching configurations:', err));
    }, []);

    const handleChange = async (event) => {
        const selectId = event.target.id;
        const selectedValue = event.target.value;

        let endpoint = "";
        if (selectId === "configuration") {
            endpoint = `http://localhost:8080/configuration/metric/${selectedValue}`;
        } else if (selectId === "workspace") {
            endpoint = `http://localhost:8080/workspace/metric/${selectedValue}`;
        }

        try {
            const response = await fetch(endpoint);
            const data = await response.json();

            const ids = data.map((item) => item.metricId);
            const typesMap = {};
            data.forEach((item) => {
                typesMap[item.metricId] = item.range;
            });
            setSelectedCardIds(ids);
            setSelectedCardTypes(typesMap);
        } catch (error) {
            console.error("Failed to fetch data:", error);
        }

    };

    const [selectedCardIds, setSelectedCardIds] = useState([]);
    const [selectedCardTypes, setSelectedCardTypes] = useState({});

    const handleSelect = (id) => {
        setSelectedCardIds((prevSelected) => {
            const alreadySelected = prevSelected.includes(id);

            // Deselect if already selected
            if (alreadySelected) {
                return prevSelected.filter((itemId) => itemId !== id);
            }

            // Enforce limit of 7
            if (prevSelected.length >= 7) {
                alert("You can select a maximum of 7 metrics.");
                return prevSelected; // Do not update the state
            }

            console.log(metrics)
            // Otherwise, select the new ID
            return [...prevSelected, id];
        });
    };

    const [showOrderPopup, setShowOrderPopup] = useState(false);

    const moveMetric = (fromIndex, toIndex) => {
        if (toIndex < 0 || toIndex >= selectedCardIds.length) return;
        const updated = [...selectedCardIds];
        const [moved] = updated.splice(fromIndex, 1);
        updated.splice(toIndex, 0, moved);
        setSelectedCardIds(updated);
    };

    const [showPreview, setShowPreview] = useState(false);
    const [answers, setAnswers] = useState({}); // stores selected button per metric

    const generatePreviewData = () => {
        return selectedCardIds.map((id, index) => {
            const metric = metrics.find((m) => m.id === id);
            const selectElement = document.getElementById("sel" + id);
            const type = selectElement ? selectElement.value : "0_1";

            return {
                id,
                name: metric?.name || "Unknown",
                type,
                position: index
            };
        });
    };

    const handleSubmit = async () => {
        const workspaceName = document.getElementById("workspaceName").value;

        if (!workspaceName) {
            alert("Please enter a workspace name.");
            return;
        }

        const payload = selectedCardIds.map((id, index) => {
            const selectElement = document.getElementById("sel" + id);
            const type = selectElement ? selectElement.value : "0_1";
            return {
                id,
                type,
                position: index
            };
        });

        const ids = payload.map(item => item.id);
        const types = payload.map(item => item.type);
        const positions = payload.map(item => item.position);

        const body = {
            workspaceName,
            ids,
            types,
            positions
        };

        try {
            const response = await fetch("http://localhost:8080/workspace", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(body)
            });

            if (response.ok) {
                alert("Workspace created successfully!");
                window.location.reload();
            } else {
                const error = await response.text();
                alert("Failed to create workspace: " + error);
            }
        } catch (err) {
            console.error("Error submitting workspace:", err);
            alert("An error occurred while submitting the workspace.");
        }
    };

    const createMetric = async (name) => {
        if (!name.trim()) return alert("Metric name cannot be empty.");

        try {
            const response = await fetch("http://localhost:8080/metric", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ name })
            });

            if (response.ok) {
                const newMetric = await response.json();
                setMetrics((prev) => [...prev, newMetric]);
            } else {
                alert("Failed to create metric.");
            }
        } catch (error) {
            console.error("Error creating metric:", error);
            alert("An error occurred.");
        }
    };

    const deleteMetric = async (id) => {
        try {
            const response = await fetch(`http://localhost:8080/metric/delete/${id}`, {
                method: "POST"
            });
            if (response.ok) {
                setMetrics((prev) => prev.filter((m) => m.id !== id));
                // Optionally remove from selectedCardIds or selectedCardTypes too
            } else {
                alert("Failed to delete metric.");
            }
        } catch (err) {
            console.error("Error deleting metric:", err);
            alert("Error occurred.");
        }
    };


    return (
        <div className={"container-fluid d-flex flex-column"}
        style={{width:"100%", minHeight: '100vh'}}
        >
            <h1 className={"align-self-start block d-flex justify-content-center m-5"} style={{width:"100%"}}>Create a new Workspace!</h1>
            <div className={"d-flex justify-content-between position-relative"} style={{left:"150px",height:"30px", width:"1200px"}}>
                <input type={"text"} id={"workspaceName"} placeholder={"Enter Your Workspace Name"} />
                <select value={"selected"} onChange={handleChange} id={"workspace"}>
                    <option value="">-- Select Configuration From Workspaces --</option>
                    {workspaces.map((workspace) => (
                        <option key={workspace.id} value={workspace.id}>
                            {workspace.name}
                        </option>
                    ))}
                </select>

                <select value={"selected"} onChange={handleChange} id={"configuration"}>
                    <option value="">-- Select Configuration --</option>
                    {configurations.map((configuration) => (
                        <option key={configuration.id} value={configuration.id}>
                            {configuration.name}
                        </option>
                    ))}
                </select>


            </div>

            <MetricList
                allMetrics={metrics}
                selectedCardIds={selectedCardIds}
                selectedCardTypes={selectedCardTypes}
                onSelect={handleSelect}
                onCreate={createMetric}
                onDelete={deleteMetric}
            />

            <div className={"position-relative"}
            style={{left:"150px", width:"1200px"}}>
                <button className={"btn btn-outline-primary"} onClick={() => setShowOrderPopup(true)}> Order Metrics </button>
                <button className={"btn btn-outline-primary mx-2"} onClick={() => setShowPreview(true)}> Preview </button>
                <button className={"btn btn-outline-primary float-end"} onClick={handleSubmit}>Create Workspace</button>
            </div>

            {showOrderPopup && (
                <MetricOrderPopup
                    metrics={metrics}
                    selectedIds={selectedCardIds}
                    onReorder={setSelectedCardIds}
                    onClose={() => setShowOrderPopup(false)}
                />)}

            {showPreview && (
                <MetricPreviewPopup
                    metrics={metrics}
                    selectedIds={selectedCardIds}
                    answers={answers}
                    setAnswers={setAnswers}
                    onClose={() => setShowPreview(false)}
                />
            )}
        </div>
    )
}

