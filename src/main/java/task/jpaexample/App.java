/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task.jpaexample;

import task.jpaexample.dao.CourierDao;
import task.jpaexample.dao.CustomerDao;
import task.jpaexample.dao.ProductDao;
import task.jpaexample.dao.PurchaseDao;
import task.jpaexample.dao.jpa.JpaCourierDao;
import task.jpaexample.dao.jpa.JpaCustomerDao;
import task.jpaexample.dao.jpa.JpaProductDao;
import task.jpaexample.dao.jpa.JpaPurchaseDao;
import task.jpaexample.model.*;

import java.sql.Date;

/**
 * @author user
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CustomerDao cdao = new JpaCustomerDao();
        ProductDao pdao = new JpaProductDao();
        PurchaseDao dao = new JpaPurchaseDao();
        CourierDao codao = new JpaCourierDao();

        // utworzenie klienta
        CustomerDTO c1 = new CustomerDTO();
        c1.setFirstName("jan");
        c1.setLastName("kowalski");
        c1.setEmail("jan.kowalski@dot.com");
        // zapis klienta
        cdao.save(c1);

        // utworzenie produktu
        ProductDTO p1 = new ProductDTO();
        p1.setName("monitor");
        p1.setPrice(599.99);
        // zapis produktu
        pdao.save(p1);

        // utworzenie zamowienia
        PurchaseDTO pe = new PurchaseDTO();
        pe.setCustomer(c1);
        PurchaseItemDTO pi = new PurchaseItemDTO();
        pi.setProduct(p1);
        pi.setQuantity(10);
        pe.addPurchaseItem(pi);
        pe.setDeliverDestination("Warszawa");
        pe.setDate(new Date(System.currentTimeMillis()));

        // zapis zamowienia
        dao.save(pe);

        // utworzenie firmy kurierskiej
        CourierDTO co1 = new CourierDTO();
        co1.setName("DPD");
        co1.setAddress("Bialystok");
        co1.setEmail("dpd@dpd.com");
        co1.addPurchase(pe);

        // zapis firmy
        codao.save(co1);

        c1.setFirstName("janek");
        cdao.update(c1);

        for (ProductDTO p : pdao.findAll()) {
            System.out.println(p);
        }

    }

}
