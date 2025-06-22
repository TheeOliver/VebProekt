package mk.ukim.finki.projectapp.dto;

import lombok.Data;
import mk.ukim.finki.projectapp.model.MetricType;

import java.util.List;

@Data
public class CreateMetricDTO {
    private String name;
    private MetricType type;
    private List<String> comments;

    CreateMetricDTO(String name, MetricType type, List<String> comments) {
        this.name = name;
        this.type = type;
        this.comments = comments;
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
}
