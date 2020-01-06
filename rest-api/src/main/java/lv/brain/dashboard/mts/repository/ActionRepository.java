package lv.brain.dashboard.mts.repository;

import lv.brain.dashboard.mts.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ActionRepository extends JpaRepository<Action, Long> {
}
