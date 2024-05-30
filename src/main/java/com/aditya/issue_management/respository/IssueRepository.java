package com.aditya.issue_management.respository;

import com.aditya.issue_management.dto.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Integer> {
}
