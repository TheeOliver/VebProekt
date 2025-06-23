package mk.ukim.finki.projectapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import mk.ukim.finki.projectapp.model.MetricType;

import java.util.List;

@Data
public class CreateMetricDTO {
    private String name;
    private MetricType type;
    private List<String> comments;
    private Long managerId;

    public CreateMetricDTO(String name, MetricType type, List<String> comments, Long managerId) {
        this.name = name;
        this.type = type;
        this.comments = comments;
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MetricType getType() {
        return type;
    }

    public void setType(MetricType type) {
        this.type = type;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}
