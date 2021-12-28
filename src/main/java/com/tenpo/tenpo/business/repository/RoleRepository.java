package com.tenpo.tenpo.business.repository;

import com.tenpo.tenpo.business.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String roleName);

}
