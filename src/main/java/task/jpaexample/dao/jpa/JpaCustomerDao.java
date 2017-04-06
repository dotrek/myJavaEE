/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao.jpa;

import task.jpaexample.dao.CustomerDao;
import task.jpaexample.model.CustomerDTO;
import task.jpaexample.util.JpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author user
 */
public class JpaCustomerDao extends GenericJpaDao<CustomerDTO, Integer> implements CustomerDao {
    @Override
    public List<CustomerDTO> findBySurname(String surname) {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<CustomerDTO> query = em.createNamedQuery("CustomerDTO.findBySurname()", CustomerDTO.class);
        query.setParameter("psurname", surname);
        em.close();
        return query.getResultList();
    }
}
