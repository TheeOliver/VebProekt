package mk.ukim.finki.projectapp.service;

import mk.ukim.finki.projectapp.dto.ManagerDTO;
import mk.ukim.finki.projectapp.model.Manager;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.Workspace;

import java.util.List;

public interface ManagerService {
    Manager findById(Long id);

    List<Manager> listAll();

    Manager create(String name);

    Manager findByName(String name);

    ManagerDTO convertToDTO(Manager manager);

    void deleteById(Long id);
}
