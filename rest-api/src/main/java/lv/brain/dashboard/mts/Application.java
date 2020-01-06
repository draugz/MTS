package lv.brain.dashboard.mts;

import lv.brain.dashboard.mts.model.Action;
import lv.brain.dashboard.mts.model.ConfigType;
import lv.brain.dashboard.mts.model.Environment;
import lv.brain.dashboard.mts.model.User;
import lv.brain.dashboard.mts.repository.ActionRepository;
import lv.brain.dashboard.mts.repository.ConfigTypeRepository;
import lv.brain.dashboard.mts.repository.EnvironmentRepository;
import lv.brain.dashboard.mts.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	private ActionRepository actionRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ConfigTypeRepository configTypeRepository;

	@Autowired
	private EnvironmentRepository environmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			actionRepository.save(new Action("Add"));
			actionRepository.save(new Action("Update"));
			actionRepository.save(new Action("Delete"));

			environmentRepository.save(new Environment("DEV"));
			environmentRepository.save(new Environment("TST"));
			environmentRepository.save(new Environment("PROD"));

			userRepository.save(new User("user x"));
			userRepository.save(new User("user y"));

			configTypeRepository.save(new ConfigType("Type UNO"));
			configTypeRepository.save(new ConfigType("Type DUOS"));
			configTypeRepository.save(new ConfigType("Type TRES"));
		};
	}

}
