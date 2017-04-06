/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.dao;

import task.jpaexample.model.PurchaseDTO;

import java.util.List;

public interface PurchaseDao extends GenericDao<PurchaseDTO, Integer> {
    List<PurchaseDTO> findAll();

    List<PurchaseDTO> findByClient(String name, String surname);
}

