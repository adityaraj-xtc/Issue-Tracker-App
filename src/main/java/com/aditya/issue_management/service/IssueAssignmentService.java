package com.aditya.issue_management.service;

import com.aditya.issue_management.dto.Agent;
import com.aditya.issue_management.dto.AgentExpertise;
import com.aditya.issue_management.dto.AgentIssueMapping;
import com.aditya.issue_management.dto.Issue;
import com.aditya.issue_management.respository.AgentExpertiseRepository;
import com.aditya.issue_management.respository.AgentIssueMappingRepository;
import com.aditya.issue_management.respository.IssueRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class IssueAssignmentService {

    private final AgentExpertiseRepository agentExpertiseRepository;
    private final AgentIssueMappingRepository agentIssueMappingRepository;
    private final IssueRepository issueRepository;
    public IssueAssignmentService(
            AgentExpertiseRepository agentExpertiseRepository,
            AgentIssueMappingRepository agentIssueMappingRepository,
            IssueRepository issueRepository
    ){
        this.agentExpertiseRepository = agentExpertiseRepository;
        this.agentIssueMappingRepository = agentIssueMappingRepository;
        this.issueRepository = issueRepository;
    }

    @Transactional
    public void assign(Issue issue){
        List<Agent> candidateAgents = agentExpertiseRepository.findAllByExpertise(issue.getType()).stream().
                map(AgentExpertise::getAgent).toList();
        Agent selectedAgent = getRandomAgent(candidateAgents);
        issue.setAgent(selectedAgent);
        agentIssueMappingRepository.save(new AgentIssueMapping(selectedAgent.getId(), issue.getId()));
    }

    public List<Issue> getIssues(Integer agent_id){
        return agentIssueMappingRepository.findByAgentId(agent_id).stream().
                map(agentIssueMapping -> issueRepository.findById(agentIssueMapping.getIssueId()).orElse(null))
                .toList();
    }

    private Agent getRandomAgent(List<Agent> candidateAgentList){
        Random random = new Random();
        return candidateAgentList.get(random.nextInt()  % candidateAgentList.size());
    }
}
