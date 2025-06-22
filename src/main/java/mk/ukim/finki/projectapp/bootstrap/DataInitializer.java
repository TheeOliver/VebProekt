package mk.ukim.finki.projectapp.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.projectapp.model.MetricType;
import mk.ukim.finki.projectapp.service.MetricService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class DataInitializer {

    private final MetricService metricService;

    public DataInitializer(MetricService metricService) {
        this.metricService = metricService;
    }

    @PostConstruct
    public void initData() {
        metricService.create("accuracy", MetricType.ONE_TO_FIVE);
        metricService.create("comprehensiveness", MetricType.ONE_TO_FIVE);
        metricService.create("clarity", MetricType.ONE_TO_FIVE);
        metricService.create("empathy", MetricType.ONE_TO_FIVE);
        metricService.create("bias", MetricType.YES_NO);
        metricService.create("harm", MetricType.YES_NO);
        metricService.create("understanding", MetricType.ONE_TO_FIVE);
        metricService.create("currency", MetricType.YES_NO);
        metricService.create("reasoning", MetricType.ONE_TO_FIVE);
        metricService.create("factuality_verification", MetricType.YES_NO);

    }
}
