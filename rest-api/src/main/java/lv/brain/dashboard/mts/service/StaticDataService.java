package lv.brain.dashboard.mts.service;

import lombok.RequiredArgsConstructor;
import lv.brain.dashboard.mts.model.Action;
import lv.brain.dashboard.mts.model.ConfigType;
import lv.brain.dashboard.mts.model.Environment;
import lv.brain.dashboard.mts.model.User;
import lv.brain.dashboard.mts.repository.ActionRepository;
import lv.brain.dashboard.mts.repository.ConfigTypeRepository;
import lv.brain.dashboard.mts.repository.EnvironmentRepository;
import lv.brain.dashboard.mts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaticDataService {

    private final ActionRepository actionRepository;

    private final UserRepository userRepository;

    private final ConfigTypeRepository configTypeRepository;

    private final EnvironmentRepository environmentRepository;

    public List<User> findUserAll() {
        return userRepository.findAll();
    }
    public List<Action> findActionAll() {
        return actionRepository.findAll();
    }
    public List<ConfigType> findConfigTypeAll() {
        return configTypeRepository.findAll();
    }
    public List<Environment> findEnvironmentAll() {
        return environmentRepository.findAll();
    }
}
