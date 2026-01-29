package ourbusinessproject;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class Partnership {
    @NotNull
    private Date creationDate;

    @NotNull
    private Enterprise enterprise;

    @NotNull
    private Project project;

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
