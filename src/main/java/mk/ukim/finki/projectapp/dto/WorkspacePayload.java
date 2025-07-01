package mk.ukim.finki.projectapp.dto;
import java.util.List;

public class WorkspacePayload {
    private String workspaceName;
    private List<Long> ids;
    private List<String> types;
    private List<Integer> positions;

    public WorkspacePayload(String workspaceName, List<Long> ids, List<String> types, List<Integer> positions) {
        this.workspaceName = workspaceName;
        this.ids = ids;
        this.types = types;
        this.positions = positions;
    }

    public String getWorkspaceName() {
        return workspaceName;
    }

    public List<Long> getIds() {
        return ids;
    }

    public List<String> getTypes() {
        return types;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
