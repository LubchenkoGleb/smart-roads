package com.kpi.diploma.smartroads.repository.user;

import com.kpi.diploma.smartroads.model.document.user.Driver;
import com.kpi.diploma.smartroads.model.document.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<Driver, String> {

    Driver findByInviteKey(String inviteUrl);

    Driver findByEmail(String email);

    Driver findByIdAndBossId(String id, String bossId);
}
