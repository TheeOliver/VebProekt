export default function MetricList({ allMetrics, selectedMetrics, toggleMetric }) {
    return (
        <div>
            {allMetrics.map(metric => (
                <div key={metric.id}>
                    <label>
                        <input
                            type="checkbox"
                            checked={selectedMetrics.some(m => m.id === metric.id)}
                            onChange={() => toggleMetric(metric)}
                        />
                        {metric.name}
                    </label>
                </div>
            ))}
        </div>
    );
}
