package ourbusinessproject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    private EnterpriseProjectService enterpriseProjectService;
    public ProjectController(EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }
    @GetMapping("/api/projects")
    public ResponseEntity<List<Project>> findAllProjectsWithEnterprises() {
        return ResponseEntity.ok().body(this.enterpriseProjectService.findAllProjects());
    }
}
