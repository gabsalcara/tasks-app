package com.task.app.repository;

import com.task.app.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskAppRepository extends JpaRepository<Task,Long> {

}
