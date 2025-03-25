/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package session;

import entities.Orders;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pc
 */
@Local
public interface OrderSessionBeanLocal {
    List<Orders> findAll();
    
    void insert(Orders orders);
    
    void delete(Long id);
    
    void update(Orders orders);
    
    Orders find(Long id);
}
