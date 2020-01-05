package com.start.mts.db;

import com.start.mts.domain.EnvDeploy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvDeployRepository extends JpaRepository<EnvDeploy, Integer> {

}
