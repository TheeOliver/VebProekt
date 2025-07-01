package mk.ukim.finki.projectapp.dto;

public class WorkspaceDTO {
    private Long id;
    private String name;

    public WorkspaceDTO(Long id, String name) {
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
