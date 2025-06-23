package mk.ukim.finki.projectapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import mk.ukim.finki.projectapp.model.Metric;

import java.util.List;

@Data
public class CreateWorkspaceDTO {
    private String name;
    private List<Long> selectedMetricIds;
    private Metric mostImportantMetric;
    private String managerName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getSelectedMetricIds() {
        return selectedMetricIds;
    }

    public void setSelectedMetricIds(List<Long> selectedMetricIds) {
        this.selectedMetricIds = selectedMetricIds;
    }

    public Metric getMostImportantMetric() {
        return mostImportantMetric;
    }

    public void setMostImportantMetric(Metric mostImportantMetric) {
        this.mostImportantMetric = mostImportantMetric;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public CreateWorkspaceDTO(String name, List<Long> selectedMetricIds, Metric mostImportantMetric, String managerName) {
        this.name = name;
        this.selectedMetricIds = selectedMetricIds;
        this.mostImportantMetric = mostImportantMetric;
        this.managerName = managerName;
    }
}
