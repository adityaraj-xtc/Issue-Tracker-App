package com.aditya.issue_management.dto;

import jakarta.persistence.*;

@Entity
public class AgentIssueTypes {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;
    private String issue_type;
}
