package mk.ukim.finki.projectapp.repository;

import mk.ukim.finki.projectapp.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricRepository extends JpaRepository<Metric, Long> {
}
