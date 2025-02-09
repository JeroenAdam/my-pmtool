package com.adambahri.mypmtool.web;

import com.adambahri.mypmtool.domain.Project;
import com.adambahri.mypmtool.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
        return projectService.updateProject(id, projectDetails);
    }

    @DeleteMapping("/{ChannelId}")
    public ResponseEntity<Void> deleteProject(@PathVariable String ChannelId) {
        projectService.deleteProject(ChannelId);
        return ResponseEntity.noContent().build();
    }
}
