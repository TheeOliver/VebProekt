// MetricOrderPopup.js
import React from "react";

export default function MetricOrderPopup({ metrics, selectedIds, onClose, onReorder }) {
    const moveMetric = (fromIndex, toIndex) => {
        if (toIndex < 0 || toIndex >= selectedIds.length) return;
        const updated = [...selectedIds];
        const [moved] = updated.splice(fromIndex, 1);
        updated.splice(toIndex, 0, moved);
        onReorder(updated);
    };

    return (
        <div style={{
            position: "fixed", top: "50%", left: "50%",
            transform: "translate(-50%, -50%)",
            background: "#fff", padding: "20px",
            borderRadius: "8px", boxShadow: "0 0 10px rgba(0,0,0,0.3)",
            zIndex: 1000, width: "400px"
        }}>
            <h5 className="mb-3">Reorder Selected Metrics</h5>
            {selectedIds.map((id, index) => {
                const metric = metrics.find(m => m.id === id);
                return (
                    <div key={id} className="d-flex justify-content-between align-items-center mb-2">
                        <span>{metric?.name}</span>
                        <div>
                            <button className="btn btn-sm btn-outline-secondary me-1"
                                    disabled={index === 0}
                                    onClick={() => moveMetric(index, index - 1)}>
                                ↑
                            </button>
                            <button className="btn btn-sm btn-outline-secondary"
                                    disabled={index === selectedIds.length - 1}
                                    onClick={() => moveMetric(index, index + 1)}>
                                ↓
                            </button>
                        </div>
                    </div>
                );
            })}
            <div className="d-flex justify-content-end mt-3">
                <button className="btn btn-secondary" onClick={onClose}>Close</button>
            </div>
        </div>
    );
}
