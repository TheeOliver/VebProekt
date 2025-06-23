package mk.ukim.finki.projectapp.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.projectapp.dto.ManagerDTO;
import mk.ukim.finki.projectapp.dto.MetricDTO;
import mk.ukim.finki.projectapp.model.Manager;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.MetricType;
import mk.ukim.finki.projectapp.model.exceptions.InvalidMetricIdException;
import mk.ukim.finki.projectapp.repository.MetricRepository;
import mk.ukim.finki.projectapp.service.ManagerService;
import mk.ukim.finki.projectapp.service.MetricService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class MetricServiceImpl implements MetricService {

    private final MetricRepository metricRepository;
    private final ManagerService managerService;
    private final List<String> oneToFiveComments = List.of("Horrible", "Bad", "Alright", "Good", "Great");
    private final List<String> yesNoComments = List.of("Doesn't have", "Has");

    public MetricServiceImpl(MetricRepository metricRepository,ManagerService managerService) {
        this.metricRepository = metricRepository;
        this.managerService = managerService;
    }

    @Override
    public Metric findById(Long id) {
        return metricRepository.findById(id).orElseThrow(InvalidMetricIdException::new);
    }

    @Override
    public List<Metric> findAllByIds(List<Long> ids) {
        return metricRepository.findAllById(ids);
    }

    @Override
    public List<Metric> listAll() {
        return metricRepository.findAll();
    }

    @Override
    public List<Metric> listByManagerId(Long id) {
        return metricRepository.findAll().stream().filter(m->m.getCreator().getId().equals(id)).toList();
    }

    @Override
    public List<MetricDTO> listByManagerIdDTO(Long id) {
        return listByManagerId(id).stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    private MetricDTO convertToDTO(Metric metric) {
        return new MetricDTO(
                metric.getId(),
                metric.getName(),
                metric.getType(),
                metric.getComments(),
                new ManagerDTO(metric.getCreator().getId(), metric.getCreator().getName())
        );
    }

    @Override
    public List<Metric> listStandardMetrics() {
        return listByManagerId(managerService.findByName("StandardMetricOwner").getId());
    }

    @Override
    public List<MetricDTO> listStandardMetricsDTO() {
        return listStandardMetrics().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Metric create(String name, MetricType type, List<String> comments, Manager creator) {
        int sizeOfComments = type == MetricType.YES_NO ? 2 : 5;
        List<String> fixedComments = new ArrayList<>(sizeOfComments);
        for (int i = 0; i < sizeOfComments; i++) {
            if (Objects.equals(comments.get(i).strip(), "")) {
                fixedComments.set(i, type == MetricType.YES_NO ? yesNoComments.get(i) : oneToFiveComments.get(i));
            }
            else {
                fixedComments.set(i, comments.get(i));
            }
        }
        return metricRepository.save(new Metric(name, type, fixedComments,creator));
    }

    @Override
    public Metric create(String name, MetricType type, Manager creator) {
        List<String> comments = type == MetricType.YES_NO ? yesNoComments : oneToFiveComments;
        return metricRepository.save(new Metric(name, type, comments,creator));
    }

    @Override
    public void deleteById(Long id) {
        metricRepository.deleteById(id);
    }
}
