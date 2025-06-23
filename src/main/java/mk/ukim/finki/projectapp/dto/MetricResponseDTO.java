package mk.ukim.finki.projectapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import mk.ukim.finki.projectapp.model.Metric;

import java.util.List;

@Data
public class MetricResponseDTO {
    private List<MetricDTO> standardMetrics;
    private List<MetricDTO> managerSpecificMetrics;

    public List<MetricDTO> getStandardMetrics() {
        return standardMetrics;
    }

    public void setStandardMetrics(List<MetricDTO> standardMetrics) {
        this.standardMetrics = standardMetrics;
    }

    public List<MetricDTO> getManagerSpecificMetrics() {
        return managerSpecificMetrics;
    }

    public void setManagerSpecificMetrics(List<MetricDTO> managerSpecificMetrics) {
        this.managerSpecificMetrics = managerSpecificMetrics;
    }

    public MetricResponseDTO(List<MetricDTO> standardMetrics, List<MetricDTO> managerSpecificMetrics) {
        this.standardMetrics = standardMetrics;
        this.managerSpecificMetrics = managerSpecificMetrics;
    }
}
