package ourbusinessproject;

import jakarta.validation.constraints.NotBlank;

public class Project {
    @NotBlank
    private String title;

    private String description;

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
}
