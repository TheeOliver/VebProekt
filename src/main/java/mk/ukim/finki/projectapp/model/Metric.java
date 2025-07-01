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

    public Metric(String name, MetricType type) {
        this.name = name;
        this.type = type;
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

}
