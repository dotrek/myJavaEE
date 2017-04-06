/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author m
 */
@NamedQueries({
        @NamedQuery(name = "ProductDTO.findByPriceRange()", query = "SELECT p from ProductDTO p where p.price between :ppricelow and :ppricehigh"),
        @NamedQuery(name = "ProductDTO.changePrice()", query = "update ProductDTO p set p.price=p.price+p.price*:ppercent"),
        @NamedQuery(name = "ProductDTO.findWorst()", query = "SELECT  p from ProductDTO p where not exists (select pi from PurchaseItemDTO pi where p.id=pi.product.id)"),
        @NamedQuery(name = "ProductDTO.findBest()", query = "select max(sum(pi.quantity))from ProductDTO p, PurchaseItemDTO pi where p.id=pi.product.id")
})
@Entity
@Table(name = "PRODUCT", schema = "APP")
public class ProductDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    public ProductDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + id + "," + name + "," + price;
    }
}
