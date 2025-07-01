package mk.ukim.finki.projectapp.service;

import mk.ukim.finki.projectapp.model.Configur;
import java.util.List;

public interface ConfigurationService {
    Configur create(String name);
    void delete(Configur config);
    List<Configur> listAll();
    Configur findById(Long id);
    Configur findByName(String name);
}
