package mk.ukim.finki.projectapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Manager owner;

    @ManyToMany
    private List<Metric> metrics = new ArrayList<>();

    @ManyToOne
    private Metric mostImportantMetric;

    public Workspace(String name, Manager owner, List<Metric> metrics, Metric mostImportantMetric) {
        this.name = name;
        this.owner=owner;
        this.metrics = metrics;
        this.mostImportantMetric = mostImportantMetric;
    }

    public Workspace() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getOwner() {
        return owner;
    }

    public void setOwner(Manager owner) {
        this.owner = owner;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

    public Metric getMostImportantMetric() {
        return mostImportantMetric;
    }

    public void setMostImportantMetric(Metric mostImportantMetric) {
        this.mostImportantMetric = mostImportantMetric;
    }
}

