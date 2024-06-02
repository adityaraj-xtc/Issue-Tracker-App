package com.aditya.issue_management.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Agent {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public Agent() {
    }

    public Agent(String name){
        this.name = name;
    }
}
