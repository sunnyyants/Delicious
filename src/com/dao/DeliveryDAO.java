package com.dao;

import com.models.Delivery;

import java.util.List;

/**
 * Created by lanshan on 4/24/14.
 */
public interface DeliveryDAO {
    public void createDelivery(Delivery delivery);

    public void deleteDelivery(Integer DeliveryId);

    public List<Delivery> listOfDelivery();

    public Delivery DeliveryById(Integer DeliveryId);

    public Long CountDeliveries();
}
