import React from 'react';

function MetricButton({ label, tooltip, isSelected, onClick }) {
    return (
        <button
            title={tooltip}
            onClick={onClick}
            className={`px-3 py-1 border rounded transition-colors duration-200
                ${isSelected ? 'bg-blue-500 text-white' : 'bg-gray-200 hover:bg-gray-300'}`}
        >
            {label}
        </button>
    );
}

export default MetricButton;
