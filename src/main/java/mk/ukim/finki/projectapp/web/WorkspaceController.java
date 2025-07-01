package mk.ukim.finki.projectapp.web;

import mk.ukim.finki.projectapp.dto.*;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.Workspace;
import mk.ukim.finki.projectapp.service.MetricService;
import mk.ukim.finki.projectapp.service.WorkspaceMetricService;
import mk.ukim.finki.projectapp.service.WorkspaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {

    private final WorkspaceMetricService workspaceMetricService;
    private final WorkspaceService workspaceService;
    private final MetricService metricService;

    public WorkspaceController(WorkspaceMetricService workspaceMetricService, WorkspaceService workspaceService, MetricService metricService) {
        this.workspaceMetricService = workspaceMetricService;
        this.workspaceService = workspaceService;
        this.metricService = metricService;
    }

    @GetMapping
    public List<WorkspaceDTO> getWorkspaces() {
        return workspaceService.listAll().stream().map(x->new WorkspaceDTO(x.getId(), x.getName())).toList();
    }

    @GetMapping("/metric/{id}")
    public List<MetricAndRange> getMetricsByWorkspace(@PathVariable Long id) {
        return workspaceMetricService.listMetricsFromWorkspace(workspaceService.findById(id)).stream().map(x->new MetricAndRange(x.getMetric().getId(), x.getRange())).toList();
    }

    @PostMapping
    public ResponseEntity<?> createWorkspace(@RequestBody WorkspacePayload payload) {
        String name = payload.getWorkspaceName();
        List<Long> ids = payload.getIds();
        List<String> types = payload.getTypes();
        List<Integer> positions = payload.getPositions();

        Workspace workspace = workspaceService.create(name);
        for(int i = 0; i < ids.size(); i++) {
            Metric m = metricService.findMetricById(ids.get(i));
            String type = types.get(i);
            int position = positions.get(i);
            workspaceMetricService.create(workspace, m, position, type);
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete/{id}")
    public Workspace deleteWorkspace(@PathVariable Long id) {
        workspaceMetricService.deleteByWorkspace(workspaceService.findById(id));
        return workspaceService.deleteById(id);
    }

}
