package mk.ukim.finki.projectapp.service;

import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.Workspace;
import mk.ukim.finki.projectapp.model.WorkspaceMetric;

import java.util.List;

public interface WorkspaceMetricService {
    List<WorkspaceMetric> listMetricsFromWorkspace(Workspace workspace);
    WorkspaceMetric create(Workspace workspace, Metric metric, int pos, String range);
}
