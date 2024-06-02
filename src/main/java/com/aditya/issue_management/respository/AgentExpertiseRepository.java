package com.aditya.issue_management.respository;

import com.aditya.issue_management.dto.AgentExpertise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentExpertiseRepository extends JpaRepository<AgentExpertise, Integer> {
    List<AgentExpertise> findAllByExpertise(String exp);
}
