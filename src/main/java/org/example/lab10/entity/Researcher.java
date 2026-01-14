package org.example.lab10.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Builder;
import lombok.Builder.Default;

import java.util.HashSet;
import java.util.Set;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Researcher extends Employee {

    private String researchArea;

    @OneToMany(mappedBy = "researcher", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<ResearcherProject> projects = new HashSet<>();

    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

    public Set<ResearcherProject> getProjects() {
        return projects;
    }

    public void setProjects(Set<ResearcherProject> projects) {
        this.projects = projects;
    }
}
