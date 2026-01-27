package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank @Size(min = 10)
    private String description;

    @NotBlank
    private String contactName;

    @NotBlank @Email
    private String contactEmail;

    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;

    /**
     * Get the name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the contact name
     * @return
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Set the contact name
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * Get the contact email
     * @return
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * Set the contact email
     * @param contactEmail
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Long getId() {
        return id;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        if (this.projects == null) {
            this.projects = new ArrayList<>();
        }
        this.projects.add(project);
    }
}
