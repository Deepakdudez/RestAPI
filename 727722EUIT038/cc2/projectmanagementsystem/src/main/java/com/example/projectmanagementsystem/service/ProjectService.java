package com.example.projectmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.projectmanagementsystem.model.Project;
import com.example.projectmanagementsystem.repository.ProjectRepo;

@Service
public class ProjectService {
    @Autowired
    ProjectRepo projectRepo;
    @SuppressWarnings("null")
    public Project addProject(Project project)
    {
        return projectRepo.save(project);
    }

    public List<Project> getAllProject()
    {
        return projectRepo.findAll();
    }
    @SuppressWarnings("null")
    public Optional<Project> getProject(Long projectId)
    {
        return projectRepo.findById(projectId);
    }
    @SuppressWarnings("null")
    public Project updateProject(Long projectId,Project project)
    {
        Project projectavail = projectRepo.findById(projectId).orElse(null);
        if(projectavail!=null)
        {
            projectavail.setProjectName(project.getProjectName());
            projectavail.setProjectRequirement(project.getProjectRequirement());
            projectavail.setProjectDescription(project.getProjectDescription());
            projectavail.setProjectStart(project.getProjectStart());
            projectavail.setProjectDeadline(project.getProjectDeadline());
            projectavail.setProjectStatus(project.getProjectStatus());
            return projectRepo.save(projectavail);
        }
        else
        return null;
    }
    @SuppressWarnings("null")
    public void deleteProject(Long projectId)
    {
        projectRepo.deleteById(projectId);
    }


    public List<Project> getSort(String field)
    {
        Sort sort = Sort.by(field);
        return projectRepo.findAll(sort);
    }

    public List<Project> getPage(int pageNumber,int pageSize)
    {
        return projectRepo.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    public List<Project> getsortpage(String field,int offset,int pageSize)
    {
        return projectRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field))).getContent();
    }
}
