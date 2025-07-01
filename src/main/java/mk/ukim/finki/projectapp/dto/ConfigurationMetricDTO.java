package mk.ukim.finki.projectapp.dto;

public class ConfigurationMetricDTO {
    private Long id;
    private Long metricId;
    private Long configurationId;
    private int position;
    private String range;

    public ConfigurationMetricDTO(Long id, Long metricId, Long configurationId, int position, String range) {
        this.id = id;
        this.metricId = metricId;
        this.configurationId = configurationId;
        this.position = position;
        this.range = range;
    }

    public Long getId() {
        return id;
    }

    public Long getMetricId() {
        return metricId;
    }

    public Long getConfigurationId() {
        return configurationId;
    }

    public int getPosition() {
        return position;
    }

    public String getRange() {
        return range;
    }
}
