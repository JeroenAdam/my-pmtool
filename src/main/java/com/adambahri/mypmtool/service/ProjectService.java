package com.adambahri.mypmtool.service;

import com.adambahri.mypmtool.domain.Project;
import com.adambahri.mypmtool.repository.ProjectRepository;
import com.adambahri.mypmtool.web.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
    }

    public Project createProject(Project project) {
        project.setCreated(new Date());
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
        project.setTeam(projectDetails.getTeam());
        project.setChannelName(projectDetails.getChannelName());
        project.setChannelId(projectDetails.getChannelId());
        project.setOwner(projectDetails.getOwner());
        project.setCreated(new Date());
        return projectRepository.save(project);
    }

    @Transactional
    public void deleteProject(String ChannelId) {
        projectRepository.deleteByChannelId(ChannelId);
    }
}