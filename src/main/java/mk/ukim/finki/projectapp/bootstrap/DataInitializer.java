package mk.ukim.finki.projectapp.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.projectapp.model.Configur;
import mk.ukim.finki.projectapp.model.Metric;
import mk.ukim.finki.projectapp.model.MetricType;
import mk.ukim.finki.projectapp.service.*;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer {

    private final MetricService metricService;
    private final WorkspaceService workspaceService;
    private final ConfigurationService configurationService;
    private final WorkspaceMetricService workspaceMetricService;
    private final ConfigurationMetricService configurationMetricService;

    public DataInitializer(MetricService metricService, WorkspaceService workspaceService, ConfigurationService configurationService, WorkspaceMetricService workspaceMetricService, ConfigurationMetricService configurationMetricService) {
        this.metricService = metricService;
        this.workspaceService = workspaceService;
        this.configurationService = configurationService;
        this.workspaceMetricService = workspaceMetricService;
        this.configurationMetricService = configurationMetricService;
    }

    @PostConstruct
    public void initData() {

        Metric m1 = metricService.create("accuracy", MetricType.Default);
        Metric m2 = metricService.create("comprehensiveness", MetricType.Default);
        Metric m3 =  metricService.create("clarity", MetricType.Default);
        Metric m4 = metricService.create("empathy", MetricType.Default);
        Metric m5 =  metricService.create("bias",MetricType.Default);
        Metric m6 =   metricService.create("harm", MetricType.Default);
        Metric m7 =    metricService.create("understanding", MetricType.Default);
        Metric m8 =    metricService.create("currency", MetricType.Default);
        Metric m9 =    metricService.create("reasoning", MetricType.Default);
        Metric m10 =   metricService.create("factuality_verification", MetricType.Default);

        Configur conf1 = configurationService.create("default1");
        Configur conf2 = configurationService.create("default2");
        Configur conf3 = configurationService.create("default3");

        configurationMetricService.create(m1, conf1, 1, "0_1");
        configurationMetricService.create(m2, conf1, 2, "1_5");
        configurationMetricService.create(m5, conf1, 3, "0_1");
        configurationMetricService.create(m6, conf1, 4, "1_5");
        configurationMetricService.create(m8, conf1, 5, "1_5");

        configurationMetricService.create(m2, conf2, 1, "0_1");
        configurationMetricService.create(m3, conf2, 2, "1_5");
        configurationMetricService.create(m4, conf2, 3, "0_1");
        configurationMetricService.create(m8, conf2, 4, "1_5");
        configurationMetricService.create(m9, conf2, 5, "1_5");
        configurationMetricService.create(m10, conf2, 6, "0_1");

        configurationMetricService.create(m1, conf3, 1, "1_5");
        configurationMetricService.create(m3, conf3, 2, "1_5");
        configurationMetricService.create(m4, conf3, 3, "0_1");
        configurationMetricService.create(m5, conf3, 4, "1_5");
        configurationMetricService.create(m7, conf3, 5, "0_1");
        configurationMetricService.create(m6, conf3, 6, "1_5");
        configurationMetricService.create(m10, conf3, 7, "1_5");
    }
}
