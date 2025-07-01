package mk.ukim.finki.projectapp.service.impl;

import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.Workspace;
import mk.ukim.finki.projectapp.model.WorkspaceMetric;
import mk.ukim.finki.projectapp.repository.WorkspaceMetricRepository;
import mk.ukim.finki.projectapp.service.WorkspaceMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkspaceMetricServiceImpl implements WorkspaceMetricService {

    private final WorkspaceMetricRepository workspaceMetricRepository;

    public WorkspaceMetricServiceImpl(WorkspaceMetricRepository workspaceMetricRepository) {
        this.workspaceMetricRepository = workspaceMetricRepository;
    }

    @Override
    public List<WorkspaceMetric> listMetricsFromWorkspace(Workspace workspace) {
        return workspaceMetricRepository.findByWorkspaceId(workspace.getId());
    }

    @Override
    public WorkspaceMetric create(Workspace workspace, Metric metric, int pos, String range) {
        return workspaceMetricRepository.save(new WorkspaceMetric(workspace, metric, pos, range));
    }

    @Override
    public void deleteByWorkspace(Workspace workspace) {
        List<WorkspaceMetric> tmp = listMetricsFromWorkspace(workspace);
        workspaceMetricRepository.deleteAll(tmp);

    }
}
