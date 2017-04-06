/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao;

import task.jpaexample.model.ProductDTO;

import java.util.List;

public interface ProductDao extends GenericDao<ProductDTO, Integer> {
    List<ProductDTO> findAll();

    List<ProductDTO> findByPriceRange(double pricelow, double pricehigh);

    List<ProductDTO> findMostExpensive();

    void changePrice(double percent);

    List<ProductDTO> findWorst();

    List<ProductDTO> findBest();
}
