/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import entities.Orders;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import session.OrderSessionBeanLocal;

/**
 *
 * @author pc
 */
@ManagedBean(name = "orderBean")
public class OrderBean implements Serializable{
    @EJB
    private OrderSessionBeanLocal orderSessionBean;
    private Orders orders;
    
    public OrderBean() {
        this.orders = new Orders();
    }
    
    public List<Orders> getOrdersList() {
        return orderSessionBean.findAll();
    }
    
    public void delete(Long id) {
        orderSessionBean.delete(id);
    }
    
    public String edit(Long id) {
        orders = orderSessionBean.find(id);
        return "editOrders";
    }
    
    public Orders getOrders() {
        return orders;
    }
    
    public void insert() {
        orderSessionBean.insert(orders);
    }
    
    public void update() {
        orderSessionBean.update(orders);
    }
}

