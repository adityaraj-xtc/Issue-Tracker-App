package com.aditya.issue_management.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(indexes = {
        @Index(name="idx_agent_id", columnList = "agent_id")
})
public class AgentExpertise {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;
    private String expertise;

    public AgentExpertise(){

    }

    public AgentExpertise(Agent agent, String expertise){
        this.agent = agent;
        this.expertise = expertise;
    }
}
