package mk.ukim.finki.projectapp.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.projectapp.model.Manager;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.Workspace;
import mk.ukim.finki.projectapp.model.exceptions.InvalidWorkspaceIdException;
import mk.ukim.finki.projectapp.repository.WorkspaceRepository;
import mk.ukim.finki.projectapp.service.WorkspaceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class WorkspaceServiceImpl implements WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    public WorkspaceServiceImpl(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    @Override
    public Workspace findById(Long id) {
        return workspaceRepository.findById(id).orElseThrow(InvalidWorkspaceIdException::new);
    }

    @Override
    public List<Workspace> findByManagerId(Long managerId) {
        return listAll().stream().filter(w -> Objects.equals(w.getOwner().getId(), managerId)).collect(Collectors.toList());
    }

    @Override
    public List<Workspace> listAll() {
        return workspaceRepository.findAll();
    }

    @Override
    public Workspace create(String title, List<Metric> selectedMetrics, Metric mostImportantMetric, Manager owner) {

        return workspaceRepository.save(new Workspace(title, owner, selectedMetrics, mostImportantMetric));
    }

    @Override
    public Workspace create(String title, List<Metric> selectedMetrics, Manager owner) {
        return workspaceRepository.save(new Workspace(title, owner, selectedMetrics, selectedMetrics.getFirst()));
    }

    @Override
    public Workspace save(Workspace workspace) {
        return workspaceRepository.save(workspace);
    }

    @Override
    public void deleteById(Long id) {
        workspaceRepository.deleteById(id);
    }
}
