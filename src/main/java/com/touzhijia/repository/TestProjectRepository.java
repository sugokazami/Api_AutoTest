package com.touzhijia.repository;

import com.touzhijia.domain.entity.TestProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenxl on 2018/3/1.
 */

public interface TestProjectRepository extends JpaRepository<TestProject,Integer>{


    List<TestProject> getByCreateUser(String createUser) ;


}
