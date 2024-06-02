package com.aditya.issue_management.respository;

import com.aditya.issue_management.dto.AgentIssueMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentIssueMappingRepository extends JpaRepository<AgentIssueMapping, Integer> {
    List<AgentIssueMapping> findByAgentId(Integer agent_id);
}
