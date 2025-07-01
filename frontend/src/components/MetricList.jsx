import React, { useState, } from 'react';


export default function MetricList({ allMetrics, selectedCardIds, selectedCardTypes, onSelect, onCreate, onDelete }) {
    const [newMetricName, setNewMetricName] = React.useState("");
    return (
        <div
            className="container-fluid d-flex flex-wrap my-3 justify-content-evenly"
            style={{
                minHeight: "400px",
                gap: "12px",
                alignContent: "flex-start",
                border: "2px solid #333",
                borderRadius: "8px",
                padding: "10px",
                width: "1200px"
            }}
        >
            {allMetrics.map((metric) => {
                const isSelected = selectedCardIds.includes(metric.id);
                const isCustom = metric.type === "Custom";

                return (
                    <div
                        key={metric.id}
                        onClick={() => onSelect(metric.id)}
                        className={`card p-2 ${isSelected ? "border-primary border-3 bg-light" : ""} align-items-center`}
                        style={{
                            height: "100px",
                            width: "200px",
                            cursor: "pointer",
                            userSelect: "none"
                        }}
                    >

                        <div className="text-center mb-2">{metric.name}</div>
                        <select id={"sel" + metric.id} style={{width: "60px", textAlign: "center"}}
                                onClick={(e) => e.stopPropagation()}>
                            <option selected={selectedCardTypes[metric.id] !== '1_5'}>0_1</option>
                            <option selected={selectedCardTypes[metric.id] === '1_5'}>1_5</option>
                        </select>

                        {isCustom && (
                            <button
                                className="btn btn-sm btn-outline-danger position-absolute bottom-0 end-0 m-1 d-flex justify-content-center align-items-center"
                                style={{width:"20px", height:"20px"}}
                                onClick={(e) => {
                                    e.stopPropagation();
                                    onDelete(metric.id);
                                }}
                            >
                                ×
                            </button>
                        )}
                    </div>
                );
            })}

            <div
                className="card p-3 align-items-center d-flex justify-content-between"
                style={{
                    height: "100px",
                    width: "200px",
                    border: "2px dashed #888",
                    background: "#f8f9fa"
                }}
            >
                <input
                    type="text"
                    className="form-control mb-2"
                    placeholder="New Metric"
                    value={newMetricName}
                    onChange={(e) => setNewMetricName(e.target.value)}
                    style={{fontSize: "0.85rem", textAlign: "center"}}
                />
                <button
                    className="btn btn-sm btn-success"
                    onClick={() => {
                        onCreate(newMetricName);
                        setNewMetricName("");
                    }}
                >
                    Create
                </button>
            </div>
        </div>
    );
}
