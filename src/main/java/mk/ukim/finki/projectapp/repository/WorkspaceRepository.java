package mk.ukim.finki.projectapp.repository;
import mk.ukim.finki.projectapp.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
}

