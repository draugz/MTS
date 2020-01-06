package lv.brain.dashboard.mts.repository;

import lv.brain.dashboard.mts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
