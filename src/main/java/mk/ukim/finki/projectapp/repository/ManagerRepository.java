package mk.ukim.finki.projectapp.repository;

import mk.ukim.finki.projectapp.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}

