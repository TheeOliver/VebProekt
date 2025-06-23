package mk.ukim.finki.projectapp.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.projectapp.model.Manager;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.MetricType;
import mk.ukim.finki.projectapp.service.ManagerService;
import mk.ukim.finki.projectapp.service.MetricService;
import mk.ukim.finki.projectapp.service.WorkspaceService;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer {

    private final MetricService metricService;
    private final ManagerService managerService;
    private final WorkspaceService workspaceService;
    private final DatabaseCleaner cleaner;

    public DataInitializer(MetricService metricService, ManagerService managerService, WorkspaceService workspaceService, DatabaseCleaner cleaner) {
        this.metricService = metricService;
        this.managerService = managerService;
        this.workspaceService = workspaceService;
        this.cleaner = cleaner;
    }

    @PostConstruct
    public void initData() {
        cleaner.clean();
        Manager standardMetricOwner = managerService.create("StandardMetricOwner");
        metricService.create("accuracy", MetricType.ONE_TO_FIVE, standardMetricOwner);
        metricService.create("comprehensiveness", MetricType.ONE_TO_FIVE, standardMetricOwner);
        metricService.create("clarity", MetricType.ONE_TO_FIVE, standardMetricOwner);
        metricService.create("empathy", MetricType.ONE_TO_FIVE, standardMetricOwner);
        metricService.create("bias", MetricType.YES_NO, standardMetricOwner);
        metricService.create("harm", MetricType.YES_NO, standardMetricOwner);
        metricService.create("understanding", MetricType.ONE_TO_FIVE, standardMetricOwner);
        metricService.create("currency", MetricType.YES_NO, standardMetricOwner);
        metricService.create("reasoning", MetricType.ONE_TO_FIVE, standardMetricOwner);
        metricService.create("factuality_verification", MetricType.YES_NO, standardMetricOwner);

        Manager demoManager = managerService.create("demoManager");
        workspaceService.create("demo workspace", metricService.listStandardMetrics(), demoManager);
    }
}
