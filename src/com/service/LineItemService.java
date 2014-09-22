package com.service;

import com.models.LineItem;

import java.util.List;

/**
 * Created by Sunny on 4/18/14.
 */
public interface LineItemService {

    public void createLineItems(Integer orderId, Integer menuId, LineItem lineItem);


    public List<LineItem> findAllOrderByOrder(Integer orderId);

    public void updateItemQuantitiy(Integer lineItemId, Integer quantity);

    public void deleteItem(Integer lineItemId);
}
