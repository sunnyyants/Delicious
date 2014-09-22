package com.service.impl;

import com.dao.DeliveryDAO;
import com.dao.impl.DeliveryDAOImpl;
import com.models.Delivery;
import com.service.DeliveryService;

import java.util.List;

/**
 * Created by Sunny on 4/17/14.
 */
public class DeliveryServiceImpl implements DeliveryService {
    @Override
    public void createDelivery(Delivery delivery) {
        DeliveryDAO deliveryDAO = new DeliveryDAOImpl();
        deliveryDAO.createDelivery(delivery);
    }

    @Override
    public void deleteDelivery(Integer DeliveryId) {
        DeliveryDAO deliveryDAO = new DeliveryDAOImpl();
        deliveryDAO.deleteDelivery(DeliveryId);
    }

    @Override
    public List<Delivery> listOfDelivery() {
        DeliveryDAO deliveryDAO = new DeliveryDAOImpl();
        List<Delivery> deliverys = deliveryDAO.listOfDelivery();
        return deliverys;
    }

    @Override
    public Delivery DeliveryById(Integer DeliveryId) {
        DeliveryDAO deliveryDAO = new DeliveryDAOImpl();
        Delivery delivery = deliveryDAO.DeliveryById(DeliveryId);
        return delivery;
    }

    @Override
    public Long countDeliveries() {
        DeliveryDAO deliveryDAO = new DeliveryDAOImpl();
        return deliveryDAO.CountDeliveries();
    }


}
