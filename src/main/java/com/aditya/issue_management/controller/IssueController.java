package com.aditya.issue_management.controller;

import com.aditya.issue_management.dto.Issue;
import com.aditya.issue_management.respository.IssueRepository;
import com.aditya.issue_management.service.IssueAssignmentService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issue")
public class IssueController {

    private final IssueRepository issueRepository;
    private final IssueAssignmentService issueAssignmentService;
    public IssueController(
            IssueRepository issueRepository,
            IssueAssignmentService issueAssignmentService
    ){
        this.issueRepository = issueRepository;
        this.issueAssignmentService = issueAssignmentService;
    }
    @PostMapping("/create")
    @Transactional
    Issue create(@RequestBody Issue issue){
        Issue created_issue = issueRepository.save(issue);
        issueAssignmentService.assign(created_issue);
        return issue;
    }
}
