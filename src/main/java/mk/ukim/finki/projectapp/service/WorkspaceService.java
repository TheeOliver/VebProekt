package mk.ukim.finki.projectapp.service;

import mk.ukim.finki.projectapp.model.Workspace;

import java.util.List;

public interface WorkspaceService{
    Workspace findById(Long id);
    List<Workspace> listAll();
    Workspace create(String name);

    Workspace deleteById(Long id);
}


