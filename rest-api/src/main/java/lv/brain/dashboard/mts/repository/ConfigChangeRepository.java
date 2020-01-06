package lv.brain.dashboard.mts.repository;

import lv.brain.dashboard.mts.model.ConfigChange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigChangeRepository extends JpaRepository<ConfigChange, Long> {
}
