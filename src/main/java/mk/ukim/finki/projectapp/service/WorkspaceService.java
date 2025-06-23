package mk.ukim.finki.projectapp.service;

import mk.ukim.finki.projectapp.model.Manager;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.Workspace;

import java.util.List;

public interface WorkspaceService{
    Workspace findById(Long id);
    List<Workspace> findByManagerId(Long managerId);
    List<Workspace> listAll();
    Workspace create(String title, List<Metric> selectedMetrics,Metric mostImportantMetric, Manager owner);
    Workspace create(String title, List<Metric> selectedMetrics, Manager owner);
    Workspace save(Workspace workspace);

    void deleteById(Long id);
}


