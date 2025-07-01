package mk.ukim.finki.projectapp.model;

import jakarta.persistence.*;

@Entity
public class WorkspaceMetric {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metric_id", nullable = false)
    private Metric metric;

    private int position;
    private String range;

    public WorkspaceMetric(Workspace workspace, Metric metric, int position, String range) {
        this.workspace = workspace;
        this.metric = metric;
        this.position = position;
        this.range = range;
    }

    public WorkspaceMetric(){}

    public Long getId() {
        return id;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public Metric getMetric() {
        return metric;
    }

    public int getPosition() {
        return position;
    }

    public String getRange() {
        return range;
    }
}
