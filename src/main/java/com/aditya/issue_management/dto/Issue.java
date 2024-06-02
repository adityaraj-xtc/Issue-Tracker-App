package com.aditya.issue_management.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Issue {
    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String message;

    @CreationTimestamp
    private LocalDateTime created_at;

    @OneToOne
    @JoinColumn(name="agent_id")
    private Agent agent;
    public Issue() {
    }
}
