package mk.ukim.finki.projectapp.model;

import jakarta.persistence.*;

@Entity
public class ConfigurationMetric {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "configuration_id", nullable = false)
    private Configur configuration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metric_id", nullable = false)
    private Metric metric;

    private int position;
    private String range;

    public ConfigurationMetric(Configur configuration, Metric metric, int position, String range) {
        this.configuration = configuration;
        this.metric = metric;
        this.position = position;
        this.range = range;
    }

    public ConfigurationMetric(){}

    public Long getId() {
        return id;
    }

    public Configur getConfiguration() {
        return configuration;
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
