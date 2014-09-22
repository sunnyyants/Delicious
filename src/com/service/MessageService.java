package com.service;

import com.models.Message;

import java.util.List;

/**
 * Created by Sunny on 4/24/14.
 */
public interface MessageService {

    public void createMesage(Integer userId,Message message);

    public List<Message> findAllMessage();

    public void updateMesaageStatus(int messageId, String status);

    public Long unreadMessage();

}
