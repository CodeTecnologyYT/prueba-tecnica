package com.nisum.pruebatecnica.converts;

import com.nisum.pruebatecnica.models.entities.PhoneEntity;
import com.nisum.pruebatecnica.models.requests.PhoneRequest;

public class PhoneConvert extends AbstractConvert<PhoneRequest, PhoneEntity>{
    @Override
    public PhoneEntity fromRequest(PhoneRequest phoneRequest) {
        return PhoneEntity.builder()
                .number(phoneRequest.getNumber())
                .cityCode(phoneRequest.getCitycode())
                .countryCode(phoneRequest.getCountrycode())
                .build();
    }
}
