package mk.ukim.finki.projectapp.service.impl;

import mk.ukim.finki.projectapp.model.Configur;
import mk.ukim.finki.projectapp.model.ConfigurationMetric;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.repository.ConfigurationMetricRepository;
import mk.ukim.finki.projectapp.service.ConfigurationMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationMetricServiceImpl implements ConfigurationMetricService {

    private final ConfigurationMetricRepository configurationMetricRepository;

    public ConfigurationMetricServiceImpl(ConfigurationMetricRepository configurationMetricRepository) {
        this.configurationMetricRepository = configurationMetricRepository;
    }

    @Override
    public List<ConfigurationMetric> getMetricsByConfiguration(Configur configuration) {
        return configurationMetricRepository.findByConfigurationId(configuration.getId());
    }

    @Override
    public ConfigurationMetric create(Metric metric, Configur configuration, int position, String range) {
        if(configurationMetricRepository.findByConfigurationIdAndMetricId(configuration.getId(), metric.getId()) != null)
            return configurationMetricRepository.findByConfigurationIdAndMetricId(configuration.getId(), metric.getId());
        return configurationMetricRepository.save(new ConfigurationMetric(configuration, metric, position, range));
    }
}
