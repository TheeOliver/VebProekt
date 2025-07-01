package mk.ukim.finki.projectapp.dto;

public class ConfigurationDTO {

    private Long id;
    private String name;

    public ConfigurationDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
