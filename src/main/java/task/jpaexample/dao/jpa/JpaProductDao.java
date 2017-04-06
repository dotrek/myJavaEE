/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao.jpa;

import task.jpaexample.dao.ProductDao;
import task.jpaexample.model.ProductDTO;
import task.jpaexample.util.JpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author user
 */
public class JpaProductDao extends GenericJpaDao<ProductDTO, Integer> implements ProductDao {

    @Override
    public List<ProductDTO> findAll() {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<ProductDTO> query = em.createQuery("SELECT p from ProductDTO p", ProductDTO.class);
        List<ProductDTO> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public List<ProductDTO> findByPriceRange(double pricelow, double pricehigh) {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<ProductDTO> query = em.createNamedQuery("ProductDTO.findByPriceRange()", ProductDTO.class);
        query.setParameter("ppricelow", pricelow);
        query.setParameter("ppricehigh", pricehigh);
        List<ProductDTO> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public List<ProductDTO> findMostExpensive() {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<ProductDTO> query = em.createQuery("select p from  ProductDTO p where p.price=(select max (p2.price)from ProductDTO p2)", ProductDTO.class);
        em.close();
        return query.getResultList();
    }

    @Override
    public void changePrice(double percent) {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<ProductDTO> query = em.createNamedQuery("ProductDTO.changePrice()", ProductDTO.class);
        query.setParameter("ppercent", percent);
        em.close();
    }

    @Override
    public List<ProductDTO> findWorst() {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<ProductDTO> query = em.createNamedQuery("ProductDTO.findWorst()", ProductDTO.class);
        em.close();
        return query.getResultList();
    }

    @Override
    public List<ProductDTO> findBest() {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<ProductDTO> query = em.createNamedQuery("ProductDTO.findBest()", ProductDTO.class);
        em.close();
        return query.getResultList();
    }

}
