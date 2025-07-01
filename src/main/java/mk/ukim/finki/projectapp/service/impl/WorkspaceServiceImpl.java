package mk.ukim.finki.projectapp.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.projectapp.model.Workspace;
import mk.ukim.finki.projectapp.model.exceptions.InvalidWorkspaceIdException;
import mk.ukim.finki.projectapp.repository.WorkspaceRepository;
import mk.ukim.finki.projectapp.service.WorkspaceService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Workspace> listAll() {
        return workspaceRepository.findAll();
    }

    @Override
    public Workspace create(String name) {
        return workspaceRepository.save(new Workspace(name));
    }

    @Override
    public Workspace deleteById(Long id) {
        Workspace workspace = findById(id);
        workspaceRepository.deleteById(id);
        return workspace;
    }
}
