package com.start.mts;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class RecordService {

    public static RecordService getInstance() {
        return new RecordService();
    }

   /* public  List<EnvDeploy> findEnvs(Record record) {
        return envDeployRepository.findByRecordId(record.getRecordId());
    }*/


}

