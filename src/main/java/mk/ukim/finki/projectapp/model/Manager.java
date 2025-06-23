package mk.ukim.finki.projectapp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("creator")
    private List<Metric> customMetrics = new ArrayList<>();

    public Manager(String name){this.name=name;}

    public Manager() {

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

    public List<Metric> getCustomMetrics() {
        return customMetrics;
    }

    public void setCustomMetrics(List<Metric> customMetrics) {
        this.customMetrics = customMetrics;
    }
}

