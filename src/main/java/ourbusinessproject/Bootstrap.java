package ourbusinessproject;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Bootstrap {
    @Autowired
    private InitializationService initializationService;

    public Bootstrap(InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    public InitializationService getInitializationService() {
        return this.initializationService;
    }

    @PostConstruct
    public void init(){
        try {
            this.initializationService.initProjects();
            this.initializationService.initPartnerships();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
