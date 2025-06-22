package mk.ukim.finki.projectapp.service.impl;

import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.MetricType;
import mk.ukim.finki.projectapp.model.exceptions.InvalidMetricIdException;
import mk.ukim.finki.projectapp.repository.MetricRepository;
import mk.ukim.finki.projectapp.service.MetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricServiceImpl implements MetricService {

    private final MetricRepository metricRepository;

    public MetricServiceImpl(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @Override
    public Metric findById(Long id) {
        return metricRepository.findById(id).orElseThrow(InvalidMetricIdException::new);
    }

    @Override
    public List<Metric> listAll() {
        return metricRepository.findAll();
    }

    @Override
    public Metric create(String name, MetricType type, List<String> comments) {
        return metricRepository.save(new Metric(name, type, comments));
    }

    @Override
    public Metric create(String name, MetricType type) {
        return metricRepository.save(new Metric(name, type));
    }

    @Override
    public void deleteById(Long id) {
        metricRepository.deleteById(id);
    }
}
