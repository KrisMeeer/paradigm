package org.example.lab10.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.Builder;

import java.util.HashSet;
import java.util.Set;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Lecturer extends Researcher {

    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<TeachingAssignment> teachingAssignments = new HashSet<>();

    public Set<TeachingAssignment> getTeachingAssignments() {
        return teachingAssignments;
    }

    public void setTeachingAssignments(Set<TeachingAssignment> teachingAssignments) {
        this.teachingAssignments = teachingAssignments;
    }
}
