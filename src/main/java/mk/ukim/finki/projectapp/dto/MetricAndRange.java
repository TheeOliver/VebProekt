package mk.ukim.finki.projectapp.dto;

public class MetricAndRange {
    private Long metricId;
    private String range;

    public MetricAndRange(Long metricId, String range) {
        this.metricId = metricId;
        this.range = range;
    }

    public Long getMetricId() {
        return metricId;
    }

    public String getRange() {
        return range;
    }
}
