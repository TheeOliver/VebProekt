package mk.ukim.finki.projectapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Metric {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MetricType type;

    @ElementCollection
    @OrderColumn
    private List<String> comments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)  // Eager fetching ensures creator is loaded
    @JsonIgnoreProperties("customMetrics")
    private Manager creator;

    public Metric(String name, MetricType type, List<String> comments,Manager creator) {
        this.name = name;
        this.type = type;
        this.comments = comments;
        this.creator = creator;
    }

    public Metric() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MetricType getType() {
        return type;
    }

    public List<String> getComments() {
        return comments;
    }

    public Manager getCreator() {
        return creator;
    }

}
