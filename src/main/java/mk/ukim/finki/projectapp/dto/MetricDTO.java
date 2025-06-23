package mk.ukim.finki.projectapp.dto;
import mk.ukim.finki.projectapp.model.MetricType;

import java.util.List;

public record MetricDTO(
            Long id,
            String name,
            MetricType type,
            List<String> comments,
            ManagerDTO creator
    ) {}
