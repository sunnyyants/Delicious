package com.service.impl;

import com.dao.LikesDAO;
import com.dao.LineItemDAO;
import com.dao.impl.LineItemDAOImpl;
import com.models.LineItem;
import com.service.LineItemService;

import java.util.List;

/**
 * Created by Sunny on 4/18/14.
 */
public class LineItemServiceImpl implements LineItemService {

    @Override
    public void createLineItems(Integer orderId, Integer menuId, LineItem lineItem) {
        LineItemDAO lineItemDAO = new LineItemDAOImpl();
        lineItemDAO.createLineItem(orderId,menuId,lineItem);
    }

    @Override
    public List<LineItem> findAllOrderByOrder(Integer orderId) {
        LineItemDAO lineItemDAO = new LineItemDAOImpl();
        List<LineItem> items = lineItemDAO.findAllOrderByOrder(orderId);
        return items;
    }

    @Override
    public void updateItemQuantitiy(Integer lineItemId, Integer quantity) {
        LineItemDAO lineItemDAO = new LineItemDAOImpl();
        lineItemDAO.updateLineItemQuantity(lineItemId,quantity);
    }

    @Override
    public void deleteItem(Integer lineItemId) {
        LineItemDAO lineItemDAO = new LineItemDAOImpl();
        lineItemDAO.deleteLineItem(lineItemId);
    }
}
