package lv.brain.dashboard.mts.repository;

import lv.brain.dashboard.mts.model.ConfigType;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ConfigTypeRepository extends JpaRepository<ConfigType, Long> {
}
