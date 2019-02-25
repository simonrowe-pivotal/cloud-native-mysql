package io.pivotal.fe.cloudnativemysql;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CounterRepository extends CrudRepository<Counter, String> {

    Optional<Counter> findByPage(String page);
}
