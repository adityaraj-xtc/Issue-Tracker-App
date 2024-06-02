package com.aditya.issue_management.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class AgentIssueMapping {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Integer agentId;

    @Column(nullable = false, unique = true)
    private Integer issueId;

    public AgentIssueMapping(){
    }

    public AgentIssueMapping(Integer agentId, Integer issueId){
        this.agentId = agentId;
        this.issueId = issueId;
    }
}
