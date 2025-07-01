import React from 'react';

export default function MetricPreviewPopup({ metrics, selectedIds, onClose, answers, setAnswers }) {
    const generatePreviewData = () =>
        selectedIds.map((id, index) => {
            const metric = metrics.find(m => m.id === id);
            const selectElement = document.getElementById("sel" + id);
            const type = selectElement ? selectElement.value : "0_1";
            return { id, name: metric?.name || "Unknown", type, position: index };
        });

    const handleAnswer = (id, value) => {
        setAnswers(prev => ({ ...prev, [id]: value }));
    };

    return (
        <div style={{
            position: "fixed", top: "50%", left: "50%",
            transform: "translate(-50%, -50%)",
            background: "#fff", padding: "20px",
            borderRadius: "10px", boxShadow: "0 0 10px rgba(0,0,0,0.3)",
            zIndex: 999, maxWidth: "800px", width: "90%"
        }}>
            <h4 className="mb-4">Preview Workspace</h4>
            <div className="d-flex flex-wrap gap-4">
                {generatePreviewData().map(item => (
                    <div key={item.id} style={{ minWidth: "120px" }}>
                        <div className="fw-bold text-center mb-2">{item.name}</div>
                        <div className="d-flex justify-content-center flex-wrap gap-2">
                            {[...Array(item.type === "0_1" ? 2 : 5)].map((_, i) => {
                                const label = item.type === "0_1" ? i : i + 1;
                                const isSelected = answers[item.id] === label;
                                return (
                                    <button
                                        key={label}
                                        className={`btn btn-sm ${isSelected ? 'btn-primary' : 'btn-outline-primary'}`}
                                        onClick={() => handleAnswer(item.id, label)}
                                    >
                                        {label}
                                    </button>
                                );
                            })}
                        </div>
                    </div>
                ))}
            </div>
            <div className="d-flex justify-content-end mt-4">
                <button className="btn btn-secondary" onClick={onClose}>Close</button>
            </div>
        </div>
    );
}
