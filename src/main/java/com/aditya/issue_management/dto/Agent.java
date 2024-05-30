package com.aditya.issue_management.dto;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
public class Agent {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public Agent() {
    }

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<AgentIssueTypes> issue_types;
}
