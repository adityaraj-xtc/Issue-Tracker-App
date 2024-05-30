package com.aditya.issue_management.controller;

import com.aditya.issue_management.dto.Issue;
import com.aditya.issue_management.respository.IssueRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private final IssueRepository issueRepository;
    public IssueController(IssueRepository issueRepository){
        this.issueRepository = issueRepository;
    }
    @PostMapping("/create")
    Issue create(@RequestBody Issue issue){
        return issueRepository.save(issue);
    }
}
