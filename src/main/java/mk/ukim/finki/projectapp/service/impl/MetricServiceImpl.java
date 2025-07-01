package mk.ukim.finki.projectapp.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.MetricType;
import mk.ukim.finki.projectapp.model.exceptions.InvalidMetricIdException;
import mk.ukim.finki.projectapp.repository.MetricRepository;
import mk.ukim.finki.projectapp.service.MetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MetricServiceImpl implements MetricService {

    private final MetricRepository metricRepository;

    public MetricServiceImpl(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @Override
    public List<Metric> listAll() {
        return metricRepository.findAll();
    }

    @Override
    public Metric create(String name, MetricType type) {
        if(findMetricByName(name) != null)
            return findMetricByName(name);
        return metricRepository.save(new Metric(name, type));
    }

    @Override
    public void deleteById(Long id) {
        metricRepository.deleteById(id);
    }

    @Override
    public Metric findMetricById(Long id) {
        return metricRepository.findById(id).orElseThrow(InvalidMetricIdException::new);
    }

    @Override
    public Metric findMetricByName(String name) {
        return metricRepository.findByName(name);
    }
}
