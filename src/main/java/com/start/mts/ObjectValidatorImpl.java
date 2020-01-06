package com.start.mts;

import com.start.mts.domain.Record;
import org.springframework.stereotype.Component;

@Component
public class ObjectValidatorImpl implements ObjectValidator {
    @Override
    public boolean isValidObject(Record record) {
        return true;
    }
}
