package io.jokerr.springboot.jpa.repository;

import io.jokerr.springboot.jpa.domain.RobotMaster;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jokerr
 */
@Repository
public class RobotMasterRepository {

    @Autowired
    private EntityManager em;

    public List<RobotMaster> search(String name, String weapon, Double endurance, Double intelligence, Double speed, Double battle) {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<RobotMaster> robotMaster = cq.from(RobotMaster.class);

        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<>();
        if(name != null) {
            predicates.add(qb.like(
                    qb.lower(robotMaster.get("name")),
                    "%" + name.toLowerCase() + "%"));
        }
        if(weapon != null) {
            predicates.add(qb.like(
                    qb.lower(robotMaster.get("weapon")),
                    "%" + weapon.toLowerCase() + "%"));
        }
        if(endurance != null) {
            predicates.add(qb.equal(robotMaster.get("endurance"), endurance));
        }
        if(intelligence != null) {
            predicates.add(qb.equal(robotMaster.get("intelligence"), intelligence));
        }
        if(speed != null) {
            predicates.add(qb.equal(robotMaster.get("speed"), speed));
        }
        if(battle != null) {
            predicates.add(qb.equal(robotMaster.get("battle"), battle));
        }

        //make query and return
        cq.select(robotMaster).where(predicates.toArray(new Predicate[]{}));
        return em.createQuery(cq).getResultList();
    }

    public RobotMaster find(String id) {
        return em.find(RobotMaster.class, id);
    }
}
