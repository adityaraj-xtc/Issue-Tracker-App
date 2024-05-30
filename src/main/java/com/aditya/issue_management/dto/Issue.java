package com.aditya.issue_management.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Setter;

@Entity
@Setter
public class Issue {
    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String message;

    public Issue() {
    }
}
