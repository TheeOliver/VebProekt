package mk.ukim.finki.projectapp.dto;

public class WorkspaceMetricDTO {
    private Long id;
    private Long metricId;
    private Long workspaceId;
    private int position;
    private String range;

    public WorkspaceMetricDTO(Long id, Long metricId, Long workspaceId, int position, String range) {
        this.id = id;
        this.metricId = metricId;
        this.workspaceId = workspaceId;
        this.position = position;
        this.range = range;
    }

    public Long getId() {
        return id;
    }

    public Long getMetricId() {
        return metricId;
    }

    public Long getWorkspaceId() {
        return workspaceId;
    }

    public int getPosition() {
        return position;
    }

    public String getRange() {
        return range;
    }
}
