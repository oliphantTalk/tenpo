package com.tenpo.tenpo.business.repository;

import com.tenpo.tenpo.business.model.SessionData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionDataRepository extends CrudRepository<SessionData, String> {
}
