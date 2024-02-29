package com.example.projectmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectmanagementsystem.model.Project;
import com.example.projectmanagementsystem.service.ProjectService;




@RestController
public class ProjectControl {
    @Autowired
    ProjectService projectService;

    @PostMapping("/project/add")
    public Project addProject(@RequestBody Project project)
    {
        return projectService.addProject(project);
    }
    @GetMapping("/project/get")
    public List<Project> getAllProject()
    {
        return projectService.getAllProject();
    }
    @GetMapping("/project/get/{projectId}")
    public Optional<Project> getProject(@PathVariable Long projectId)
    {
        return projectService.getProject(projectId);
    }
    @PutMapping("/project/update/{projectId}")
    public Project updateProject(@PathVariable Long projectId,@RequestBody Project project)
    {
        return projectService.updateProject(projectId,project);
    }
    @DeleteMapping("/project/delete/{projectId}")
    public void deleteProject(@PathVariable Long projectId)
    {
        projectService.deleteProject(projectId);
    }
    @GetMapping("/project/getsort/{field}")
    public ResponseEntity<List<Project>> getMethodName(@PathVariable String field) {
        return new ResponseEntity<>(projectService.getSort(field),HttpStatus.OK);
    }
    
    @GetMapping("/project/getpage/{pageNumber}/{pageSize}")
    public List<Project> getMethodName(@PathVariable int pageNumber,@PathVariable int pageSize) {
        return projectService.getPage(pageNumber, pageSize);
    }
    
    @GetMapping("/project/getsortpage/{field}/{offset}/{pageSize}")
    public List<Project> getMethodName(@PathVariable String field,@PathVariable int offset,@PathVariable int pageSize) {
        return projectService.getsortpage(field,offset,pageSize);
    }
    
}
