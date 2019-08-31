package com.savaleks.ppmtool.services;

import com.savaleks.ppmtool.domain.Project;
import com.savaleks.ppmtool.exceptions.ProjectIdExceptions;
import com.savaleks.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project savedOrUpdateProject(Project project){

        // Logic
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e){
            throw new ProjectIdExceptions("Project Id " + project.getProjectIdentifier().toUpperCase() + " already exists.");
        }

    }
}
