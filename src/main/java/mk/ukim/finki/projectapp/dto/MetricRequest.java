package mk.ukim.finki.projectapp.dto;

public class MetricRequest {
    String name;

    public MetricRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
