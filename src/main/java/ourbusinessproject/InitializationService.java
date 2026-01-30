package ourbusinessproject;

import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {
    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    @Autowired
    private PartnershipService partnershipService;

    private Project p1e1, p1e2, p2e1;
    private Enterprise e1,e2;
    private Partnership partnership1, partnership2,  partnership3;
    public void initProjects(){

        /*
        Après l'insertion d'un projet non valide (titre null) on peut observer qu'aucun projet n'a été créé.
        Ceci est tout à fait normal grâce à l'utilisation du @Transaction,
        Si une requête lève une exception, toute la fonction est rollback et on revient à l'état initial.
         */

        this.e1 = this.enterpriseProjectService.newEnterprise("~Enterprise 1", "First Enterprise", "First Contact", "firstcontact@email.com");
        this.e2 = this.enterpriseProjectService.newEnterprise("~Enterprise 2", "Second Enterprise", "Second Contact", "secondcontact@email.com");

        this.p1e1 = this.enterpriseProjectService.newProject("~Project 1 Enterprise 1", "First Project Enterprise 1", this.e1);
        this.p2e1 = this.enterpriseProjectService.newProject("~Project 2 Enterprise 1", "Second Project Enterprise 1", this.e1);
        this.p1e2 = this.enterpriseProjectService.newProject("~Project 1 Enterprise 2", "First Project Enterprise 2", this.e2);
    }

    public void initPartnerships(){
        this.partnership1 = this.partnershipService.newPartnership(this.p1e1,this.e2);
        this.partnership2 = this.partnershipService.newPartnership(this.p2e1,this.e2);
        this.partnership3 = this.partnershipService.newPartnership(this.p1e2,this.e1);
    }

    public Project getProject1E1() {
        return this.p1e1;
    }
    public Project getProject1E2() {
        return this.p1e2;
    }
    public Project getProject2E1() {
        return this.p2e1;
    }

    public Enterprise getEnterprise1(){
        return this.e1;
    }
    public Enterprise getEnterprise2(){
        return this.e2;
    }

    public Partnership getPartnershipP1E1WithE2(){return this.partnership1;}
    public Partnership getPartnershipP2E1WithE2(){return this.partnership2;}
    public Partnership getPartnershipP1E2WithE1(){return this.partnership3;}
}
