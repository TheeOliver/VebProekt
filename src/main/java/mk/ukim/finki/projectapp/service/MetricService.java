package mk.ukim.finki.projectapp.service;

import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.MetricType;

import java.util.List;

public interface MetricService {
    Metric findMetricById(Long id);
    List<Metric> listAll();
    Metric create(String name, MetricType type);
    void deleteById(Long id);
    Metric findMetricByName(String name);
}
