package mk.ukim.finki.projectapp.web;

import mk.ukim.finki.projectapp.dto.CreateMetricDTO;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.service.MetricService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metric")
public class MetricController {

    private final MetricService metricService;

    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }


    @GetMapping
    public List<Metric> getAllMetrics() {
        return metricService.listAll();
    }

    @PostMapping
    public Metric addMetric(@RequestBody CreateMetricDTO metric) {
        return metricService.create(metric.getName(), metric.getType(), metric.getComments());
    }

}
