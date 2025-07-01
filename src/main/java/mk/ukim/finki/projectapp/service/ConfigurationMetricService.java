package mk.ukim.finki.projectapp.service;

import mk.ukim.finki.projectapp.model.Configur;
import mk.ukim.finki.projectapp.model.ConfigurationMetric;
import mk.ukim.finki.projectapp.model.Metric;
import java.util.List;

public interface ConfigurationMetricService {
    public List<ConfigurationMetric> getMetricsByConfiguration(Configur configuration);
    public ConfigurationMetric create(Metric metric, Configur configuration, int position, String range);
}
