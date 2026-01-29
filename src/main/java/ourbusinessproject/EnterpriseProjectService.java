package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Collection;

@Service
@Transactional
public class EnterpriseProjectService {
    @PersistenceContext
    private EntityManager entityManager;

    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public Project newProject(String title, String description, Enterprise enterprise) {
        if (enterprise == null){
            throw new ConstraintViolationException("Enterprise is null", null);
        }
        Project project = new Project();

        project.setTitle(title);
        project.setDescription(description);
        project.setEnterprise(enterprise);

        enterprise.addProject(project);

        this.entityManager.persist(project);
        this.entityManager.flush();

        return project;
    }

    public Enterprise newEnterprise(String name, String description, String contactName, String contactEmail) {
        Enterprise enterprise = new Enterprise();

        enterprise.setName(name);
        enterprise.setDescription(description);
        enterprise.setContactName(contactName);
        enterprise.setContactEmail(contactEmail);

        this.entityManager.persist(enterprise);
        this.entityManager.flush();

        return enterprise;
    }

    public Project findProjectById(Long id) {
        Project project = this.entityManager.find(Project.class, id);
        return project;
    }

    public Enterprise findEnterpriseById(Long id) {
        Enterprise enterprise = this.entityManager.find(Enterprise.class, id);
        return enterprise;
    }

    public List<Project> findAllProjects() {
        String query = "SELECT p FROM Project p JOIN FETCH p.enterprise ORDER BY p.title";
        TypedQuery<Project> queryProject = this.entityManager.createQuery(query, Project.class);
        return queryProject.getResultList();
    }


}
