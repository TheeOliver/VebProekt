package mk.ukim.finki.projectapp.web;

import mk.ukim.finki.projectapp.dto.MetricDTO;
import mk.ukim.finki.projectapp.dto.MetricRequest;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.MetricType;
import mk.ukim.finki.projectapp.service.MetricService;
import org.springframework.http.ResponseEntity;
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
    public List<MetricDTO> getMetrics() {
        return metricService.listAll().stream().map(x->new MetricDTO(x.getId(), x.getName(), x.getType().toString())).toList();
    }

    @PostMapping
    public ResponseEntity<?> createMetric(@RequestBody MetricRequest request) {
        String name = request.getName();
        Metric newMetric = metricService.create(name, MetricType.Custom);
        return ResponseEntity.ok(newMetric);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteMetric(@PathVariable Long id) {
        metricService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
