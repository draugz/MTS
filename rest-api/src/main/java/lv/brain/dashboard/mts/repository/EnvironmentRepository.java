package lv.brain.dashboard.mts.repository;

import lv.brain.dashboard.mts.model.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
}
