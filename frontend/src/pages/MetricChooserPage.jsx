import React, { useState, useEffect } from 'react';
import MetricList from '../components/MetricList';
import SelectedMetricList from '../components/SelectedMetricList';
import AddMetricModal from '../components/AddMetricModal';
import MetricPreview from '../components/MetricPreview';

export default function MetricChooserPage() {
    const [allMetrics, setAllMetrics] = useState([]); // From DB
    const [selectedMetrics, setSelectedMetrics] = useState([]);
    const [showModal, setShowModal] = useState(false);

    useEffect(() => {
        fetch('http://localhost:8080/metric')
            .then(res => res.json())
            .then(data => setAllMetrics(data))
            .catch(err => console.error('Error fetching metrics:', err));
    }, []);

    // useEffect(() => {
    //     // Simulated fetch
    //     setAllMetrics([
    //         { id: 1, name: 'metric 1', type: 'ONE_TO_FIVE', comments: ['', '', '', '', ''] },
    //         { id: 2, name: 'metric 2', type: 'YES_NO', comments: ['', ''] },
    //         { id: 3, name: 'metric 3', type: 'ONE_TO_FIVE', comments: ['', '', '', '', ''] },
    //         { id: 4, name: 'metric 4', type: 'YES_NO', comments: ['', ''] },
    //         { id: 5, name: 'metric 5', type: 'ONE_TO_FIVE', comments: ['', '', '', '', ''] },
    //     ]);
    // }, []);

    const toggleMetric = (metric) => {
        if (selectedMetrics.find(m => m.id === metric.id)) {
            setSelectedMetrics(prev => prev.filter(m => m.id !== metric.id));
        } else if (selectedMetrics.length < 10) {
            setSelectedMetrics(prev => [...prev, metric]);
        }
    };

    const handleAddMetric = (newMetric) => {
        setAllMetrics(prev => [...prev, newMetric]);
    };

    return (
        <div>
            <div style={{ display: 'flex', gap: '2rem' }}>
                <MetricList
                    allMetrics={allMetrics}
                    selectedMetrics={selectedMetrics}
                    toggleMetric={toggleMetric}
                />
                <SelectedMetricList
                    selectedMetrics={selectedMetrics}
                    setSelectedMetrics={setSelectedMetrics}
                />
            </div>

            <button onClick={() => setShowModal(true)}>Add</button>
            {showModal && (
                <AddMetricModal
                    onClose={() => setShowModal(false)}
                    onAdd={handleAddMetric}
                />
            )}

            <hr />
            <MetricPreview selectedMetrics={selectedMetrics} />
        </div>
    );
}
