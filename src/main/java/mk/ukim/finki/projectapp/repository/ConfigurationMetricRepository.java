package mk.ukim.finki.projectapp.repository;

import mk.ukim.finki.projectapp.model.ConfigurationMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConfigurationMetricRepository extends JpaRepository<ConfigurationMetric, Long> {
    List<ConfigurationMetric> findByConfigurationId(Long configurationId);
    ConfigurationMetric findByConfigurationIdAndMetricId(Long configurationId, Long metricId);
}
