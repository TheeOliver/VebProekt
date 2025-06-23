package mk.ukim.finki.projectapp.service;

import mk.ukim.finki.projectapp.dto.MetricDTO;
import mk.ukim.finki.projectapp.model.Manager;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.MetricType;

import java.util.List;

public interface MetricService {
    Metric findById(Long id);
    List<Metric> findAllByIds(List<Long> ids);
    List<Metric> listAll();
    List<Metric> listByManagerId(Long id);
    List<MetricDTO> listByManagerIdDTO(Long id);
    List<Metric> listStandardMetrics();
    List<MetricDTO> listStandardMetricsDTO();

    Metric create(String name, MetricType type, List<String> comments, Manager owner);
    Metric create(String name, MetricType type,Manager owner);
    void deleteById(Long id);
}
