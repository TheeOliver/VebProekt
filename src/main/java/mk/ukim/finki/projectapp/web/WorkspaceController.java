package mk.ukim.finki.projectapp.web;

import mk.ukim.finki.projectapp.dto.CreateMetricDTO;
import mk.ukim.finki.projectapp.dto.CreateWorkspaceDTO;
import mk.ukim.finki.projectapp.dto.ManagerDTO;
import mk.ukim.finki.projectapp.dto.MetricResponseDTO;
import mk.ukim.finki.projectapp.model.Manager;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.Workspace;
import mk.ukim.finki.projectapp.service.ManagerService;
import mk.ukim.finki.projectapp.service.MetricService;
import mk.ukim.finki.projectapp.service.WorkspaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkspaceController {

    private final MetricService metricService;
    private final ManagerService managerService;
    private final WorkspaceService workspaceService;

    public WorkspaceController(MetricService metricService, ManagerService managerService, WorkspaceService workspaceService) {
        this.metricService = metricService;
        this.managerService = managerService;
        this.workspaceService = workspaceService;
    }

    @GetMapping("/metric")
    public ResponseEntity<MetricResponseDTO> getAllMetrics() {
        return ResponseEntity.ok(new MetricResponseDTO(metricService.listStandardMetricsDTO(), metricService.listByManagerIdDTO(managerService.findByName("demoManager").getId())));
    }

    @GetMapping("/workspaces")
    public ResponseEntity<List<Workspace>> getWorkspacesForManager(@RequestParam Long managerId) {
        try {
            List<Workspace> workspaces = workspaceService.findByManagerId(managerId);
            return ResponseEntity.ok(workspaces);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/workspace/{id}")
    public ResponseEntity<Workspace> getWorkspaceById(@PathVariable Long id) {
        try {
            Workspace workspace = workspaceService.findById(id);
            return ResponseEntity.ok(workspace);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/metric")
    public Metric addMetric(@RequestBody CreateMetricDTO metric) {
        return metricService.create(metric.getName(), metric.getType(), metric.getComments(), managerService.findById(metric.getManagerId()));
    }

    @PostMapping("/workspace")
    public ResponseEntity<Workspace> createWorkspace(@RequestBody CreateWorkspaceDTO workspaceDTO) {
        Manager manager = managerService.findByName(workspaceDTO.getManagerName());

        // Fetch the selected metrics by their IDs
        List<Metric> selectedMetrics = metricService.findAllByIds(workspaceDTO.getSelectedMetricIds());

        // Create workspace entity and set fields
        Workspace workspace = new Workspace();
        workspace.setName(workspaceDTO.getName());
        workspace.setOwner(manager);
        workspace.setMetrics(selectedMetrics);

        // Save workspace
        Workspace savedWorkspace = workspaceService.save(workspace);

        return ResponseEntity.ok(savedWorkspace);
    }

    @GetMapping("/manager")
    public ResponseEntity<ManagerDTO> getManagerByName(@RequestParam String name) {
        try {
            ManagerDTO manager = managerService.convertToDTO(managerService.findByName(name));
            System.out.println(manager);
            return ResponseEntity.ok(manager);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
