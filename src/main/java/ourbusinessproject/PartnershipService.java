package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PartnershipService {
    @PersistenceContext
    private EntityManager em;

    public Partnership newPartnership(Project project, Enterprise enterprise) {
        if  (enterprise==null || project==null) {
            throw new ConstraintViolationException("Enterprise is null or Project is null", null);
        }

        Partnership partnership = new Partnership();
        partnership.setProject(project);
        partnership.setEnterprise(enterprise);
        partnership.setCreationDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        em.persist(partnership);
        em.flush();
        return partnership;
    }

    public Partnership findPartnershipById(Long id) {
        String query = "SELECT p FROM Partnership p WHERE p.id = :id";
        TypedQuery<Partnership> queryPartnership = em.createQuery(query, Partnership.class);
        queryPartnership.setParameter("id", id);
        List<Partnership> result = queryPartnership.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    public void remove(Partnership partnership) {
        em.remove(partnership);
    }

}
