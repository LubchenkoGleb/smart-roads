package com.kpi.diploma.smartroads.repository.user;

import com.kpi.diploma.smartroads.model.document.user.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}

