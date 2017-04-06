/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao.jpa;

import task.jpaexample.dao.PurchaseDao;
import task.jpaexample.model.PurchaseDTO;
import task.jpaexample.util.JpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author user
 */
public class JpaPurchaseDao extends GenericJpaDao<PurchaseDTO, Integer> implements PurchaseDao {
    @Override
    public List<PurchaseDTO> findByClient(String name, String surname) {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<PurchaseDTO> query = em.createNamedQuery("PurchaseDTO.findByClient()", PurchaseDTO.class);
        query.setParameter("pName", name);
        query.setParameter("pSurname", surname);
        em.close();
        return query.getResultList();
    }

    @Override
    public List<PurchaseDTO> findAll() {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<PurchaseDTO> query = em.createQuery("SELECT p from PurchaseDTO p", PurchaseDTO.class);
        return query.getResultList();
    }
}
