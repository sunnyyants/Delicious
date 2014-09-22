package com.service;

import com.models.Delivery;

import java.util.List;

/**
 * Created by lanshan on 4/24/14.
 */
public interface DeliveryService {
    void createDelivery(Delivery delivery);

    void deleteDelivery(Integer DeliveryId);

    List<Delivery> listOfDelivery();

    Delivery DeliveryById(Integer DeliveryId);

    public Long countDeliveries();
}
