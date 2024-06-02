package com.aditya.issue_management.controller;

import com.aditya.issue_management.dto.Agent;
import com.aditya.issue_management.dto.AgentExpertise;
import com.aditya.issue_management.dto.AgentRequest;
import com.aditya.issue_management.dto.Issue;
import com.aditya.issue_management.respository.AgentExpertiseRepository;
import com.aditya.issue_management.respository.AgentRepository;
import com.aditya.issue_management.service.IssueAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private final AgentRepository agentRepository;
    private final IssueAssignmentService issueAssignmentService;
    private final AgentExpertiseRepository agentExpertiseRepository;
    public AgentController(
            AgentRepository agentRepository,
            IssueAssignmentService issueAssignmentService,
            AgentExpertiseRepository agentExpertiseRepository
    ){
        this.agentRepository = agentRepository;
        this.issueAssignmentService = issueAssignmentService;
        this.agentExpertiseRepository = agentExpertiseRepository;
    }

    @PostMapping("/create")
    Agent create(@RequestBody AgentRequest agentRequest){
        Agent agent = agentRepository.save(new Agent(agentRequest.getName()));
        agentRequest.getExpertiseList().forEach(expertise -> {
            agentExpertiseRepository.save(new AgentExpertise(agent, expertise));
        });
        return agent;
    }

    @GetMapping("/{agent_id}/issues")
    List<Issue> assignedIssues(@PathVariable Integer agent_id){
        return issueAssignmentService.getIssues(agent_id);
    }
}
