package com.kpi.diploma.smartroads.model.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class DriverDto extends UserDto {

    String firstName;
    String lastName;
    String accessToken;

    public static DriverDto convert(Object object) {
        log.info("'convert' invoked with params'{}'", object);

        DriverDto driverDto = mapper.convertValue(object, DriverDto.class);
        log.info("'driverDto={}'", driverDto);

        return driverDto;
    }
}
