/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author m
 */
@NamedQuery(name = "PurchaseDTO.findByClient()", query = "select p from PurchaseDTO p where p.customer.firstName=:pName and p.customer.lastName=:pSurname")
@Entity
@Table(name = "PURCHASE", schema = "APP")
public class PurchaseDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "ID_CUSTOMER", referencedColumnName = "ID")
    private CustomerDTO customer;
    @JoinColumn()
    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private List<PurchaseItemDTO> purchaseItems = new LinkedList<PurchaseItemDTO>();
    private String deliverDestination;
    private Date date;
    @ManyToOne()
    private CourierDTO courier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public void addPurchaseItem(PurchaseItemDTO pi) {
        purchaseItems.add(pi);
        pi.setPurchase(this);
    }

    public List<PurchaseItemDTO> getPurchaseItems() {
        return purchaseItems;
    }

    public String getDeliverDestination() {
        return deliverDestination;
    }

    public void setDeliverDestination(String deliverDestination) {
        this.deliverDestination = deliverDestination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CourierDTO getCourier() {
        return courier;
    }

    public void setCourier(CourierDTO courier) {
        this.courier = courier;
    }
}
