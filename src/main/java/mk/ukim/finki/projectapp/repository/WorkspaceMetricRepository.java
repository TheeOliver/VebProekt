package mk.ukim.finki.projectapp.repository;

import mk.ukim.finki.projectapp.model.WorkspaceMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkspaceMetricRepository extends JpaRepository<WorkspaceMetric, Long> {
    List<WorkspaceMetric> findByWorkspaceId(Long workspaceId);
}
