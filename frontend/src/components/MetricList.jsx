export default function MetricList({ allMetrics}) {
    return (
        <div>
            {allMetrics.map(metric => (
                <div key={metric.id}>
                    <label>
                        <input
                            type="checkbox"
                        />
                        {metric.name}
                    </label>
                </div>
            ))}
        </div>
    );
}
