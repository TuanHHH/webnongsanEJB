/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package session;

import entities.Orders;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pc
 */
@Stateless
public class OrderSessionBean implements OrderSessionBeanLocal {
    
    @PersistenceContext(unitName = "webnongsan-ejbPU")
    private EntityManager em;

    @Override
    public List<Orders> findAll() {
        
        Query q = em.createNamedQuery("Orders.findAll", Orders.class);
        return q.getResultList();
    }

    @Override
    public void insert(Orders orders) {
        em.persist(orders);
    }

    @Override
    public void delete(Long id) {
         Orders orders = em.find(Orders.class, id);
        if (orders != null) {
            em.remove(orders);
        }
    }

    @Override
    public void update(Orders orders) {
        em.merge(orders);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Orders find(Long id) {
        
        return em.find(Orders.class, id);
    }
}
