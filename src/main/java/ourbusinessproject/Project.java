package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    @ManyToOne
    private Enterprise enterprise;

    /**
     * Set the title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set the description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the description
     * @return
     */
    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }
}
