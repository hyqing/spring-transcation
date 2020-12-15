package org.example.spring.transcation.repository;

import org.example.spring.transcation.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hyq on 2020/12/15 11:50.
 */
public interface AppRepository extends JpaRepository<App, Integer> {
}
