package com.adambahri.mypmtool.repository;
import com.adambahri.mypmtool.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    void deleteByChannelId(String channelId);
}