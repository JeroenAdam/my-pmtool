package com.adambahri.mypmtool.repository;
import com.adambahri.mypmtool.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByParentMessageId (String parentMessageId);
    List<Task> findByStatusNot(String status);
}