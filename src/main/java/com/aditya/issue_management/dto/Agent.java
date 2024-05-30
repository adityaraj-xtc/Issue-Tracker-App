package com.aditya.issue_management.dto;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Agent {
    private Integer id;
    private String name;
    private List<String> expertise;
}
