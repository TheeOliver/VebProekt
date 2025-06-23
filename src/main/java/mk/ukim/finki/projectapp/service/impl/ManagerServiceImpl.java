package mk.ukim.finki.projectapp.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.projectapp.dto.ManagerDTO;
import mk.ukim.finki.projectapp.model.Manager;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.exceptions.InvalidManagerIdException;
import mk.ukim.finki.projectapp.repository.ManagerRepository;
import mk.ukim.finki.projectapp.service.ManagerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public Manager findById(Long id) {
        return managerRepository.findById(id).orElseThrow(InvalidManagerIdException::new);
    }
    @Override
    public Manager findByName(String name) {
        return listAll().stream().filter(m->m.getName().equals(name)).findFirst().orElseThrow(InvalidManagerIdException::new);
    }
    @Override
    public ManagerDTO convertToDTO(Manager manager){
        return new ManagerDTO(manager.getId(), manager.getName());
    }

    @Override
    public List<Manager> listAll() {
        return managerRepository.findAll();
    }

    @Override
    public Manager create(String name) {
        return managerRepository.save(new Manager(name));
    }

    @Override
    public void deleteById(Long id) {
        managerRepository.deleteById(id);
    }
}
