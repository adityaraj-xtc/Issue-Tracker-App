package com.aditya.issue_management.respository;

import com.aditya.issue_management.dto.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
}
