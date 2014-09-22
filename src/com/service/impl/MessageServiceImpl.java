package com.service.impl;

import com.dao.MessageDAO;
import com.dao.impl.MessageDAOImpl;
import com.models.Message;
import com.service.MessageService;

import java.util.List;

/**
 * Created by Sunny on 4/24/14.
 */
public class MessageServiceImpl implements MessageService {
    @Override
    public void createMesage(Integer userId, Message message) {
        MessageDAO messageDAO = new MessageDAOImpl();
        messageDAO.createMesage(userId, message);
    }

    @Override
    public List<Message> findAllMessage() {
        MessageDAO messageDAO = new MessageDAOImpl();
        List<Message> messages = messageDAO.findAllMessage();
        return messages;
    }

    @Override
    public void updateMesaageStatus(int messageId, String status) {
        MessageDAO messageDAO = new MessageDAOImpl();
        messageDAO.updateMesaageStatus(messageId, status);
    }

    @Override
    public Long unreadMessage() {
        MessageDAO messageDAO = new MessageDAOImpl();
        return messageDAO.unreadMessage();
    }
}
