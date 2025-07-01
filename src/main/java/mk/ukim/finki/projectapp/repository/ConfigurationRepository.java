package mk.ukim.finki.projectapp.repository;


import mk.ukim.finki.projectapp.model.Configur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configur, Long> {
    Configur findByName(String name);
}
