import React, { useState, useEffect } from 'react';
import MetricList from '../components/MetricList';
import SelectedMetricList from '../components/SelectedMetricList';
import AddMetricModal from '../components/AddMetricModal';
import MetricPreview from '../components/MetricPreview';

export default function MetricChooserPage() {
    const [allMetrics, setAllMetrics] = useState([]); // From DB

    useEffect(() => {
        fetch('http://localhost:8080/api/metric')
            .then(res => res.json())
            .then(data => setAllMetrics(data))
            .catch(err => console.error('Error fetching metrics:', err));
    }, []);


    return (
        <body className={"container-fluid"}>
            <div className={"d-flex container-fluid"}>
                <div className={"col-6"}>
                    <MetricList
                        allMetrics={allMetrics}/>

                </div>

                <div className={"col-6"}>

                test
                </div>

            </div>
            <
        </body>
    );


}
