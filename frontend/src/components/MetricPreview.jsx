import { useState } from 'react';

export default function MetricPreview({ selectedMetrics }) {
    const [responses, setResponses] = useState({});

    const handleSelect = (metricId, index) => {
        setResponses(prev => ({ ...prev, [metricId]: index }));
    };

    return (
        <div style={{ display: 'flex', gap: '2rem' }}>
            {selectedMetrics.map(metric => (
                <div key={metric.id}>
                    <strong>{metric.name}</strong>
                    <div>
                        {metric.comments.map((comment, idx) => (
                            <button
                                key={idx}
                                style={{
                                    backgroundColor: responses[metric.id] === idx ? '#ccc' : '',
                                    margin: '0 2px',
                                }}
                                onClick={() => handleSelect(metric.id, idx)}
                                title={comment}
                            >
                                {idx}
                            </button>
                        ))}
                    </div>
                </div>
            ))}
        </div>
    );
}
