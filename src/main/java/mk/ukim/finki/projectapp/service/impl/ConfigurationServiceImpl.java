package mk.ukim.finki.projectapp.service.impl;

import mk.ukim.finki.projectapp.model.Configur;
import mk.ukim.finki.projectapp.model.exceptions.InvalidConfigurationIdException;
import mk.ukim.finki.projectapp.repository.ConfigurationRepository;
import mk.ukim.finki.projectapp.service.ConfigurationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public ConfigurationServiceImpl(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    @Override
    public Configur findById(Long id) {
        return configurationRepository.findById(id).orElseThrow(InvalidConfigurationIdException::new);
    }

    @Override
    public Configur create(String name) {
        if(findByName(name) != null)
            return findByName(name);
        return configurationRepository.save(new Configur(name));
    }

    @Override
    public void delete(Configur config) {

    }

    @Override
    public List<Configur> listAll() {
        return configurationRepository.findAll();
    }

    @Override
    public Configur findByName(String name) {
        return configurationRepository.findByName(name);
    }
}
