package com.dao;

import com.models.LineItem;

import java.util.List;

/**
 * Created by Sunny on 4/17/14.
 */
public interface LineItemDAO {

    public void createLineItem(Integer orderId, Integer menuId, LineItem lineItem);

    public void updateLineItemQuantity(Integer lineItemId, Integer quantity);

    public void deleteLineItem(Integer lineItemId);

    public List<LineItem> findAllOrderByOrder(Integer orderId);
}
