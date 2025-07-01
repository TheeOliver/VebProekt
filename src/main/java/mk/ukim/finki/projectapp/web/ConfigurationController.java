package mk.ukim.finki.projectapp.web;

import mk.ukim.finki.projectapp.dto.ConfigurationDTO;
import mk.ukim.finki.projectapp.dto.MetricAndRange;
import mk.ukim.finki.projectapp.dto.MetricDTO;
import mk.ukim.finki.projectapp.model.Configur;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.service.ConfigurationMetricService;
import mk.ukim.finki.projectapp.service.ConfigurationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    private final ConfigurationService configurationService;
    private final ConfigurationMetricService configurationMetricService;

    public ConfigurationController(ConfigurationService configurationService, ConfigurationMetricService configurationMetricService) {
        this.configurationService = configurationService;
        this.configurationMetricService = configurationMetricService;
    }

    @GetMapping
    public List<ConfigurationDTO> getConfigurations() {
        return configurationService.listAll().stream().map(x->new ConfigurationDTO(x.getId(), x.getName())).toList();
    }

    @PostMapping
    public Configur createConfiguration(String name) {
        return configurationService.create(name);
    }

    @GetMapping("/metric/{id}")
    public List<MetricAndRange> getMetricsByConfiguration(@PathVariable Long id) {
        return configurationMetricService.getMetricsByConfiguration(configurationService.findById(id)).stream().map(x->new MetricAndRange(x.getMetric().getId(), x.getRange())).toList();
    }
}
