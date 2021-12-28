package com.tenpo.tenpo.business.repository;

import com.tenpo.tenpo.business.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String privilegeName);

}
