package com.dao;

import com.models.Message;

import java.util.List;

/**
 * Created by Sunny on 4/24/14.
 */
public interface MessageDAO {

    public void createMesage(Integer userId,Message message);

    public List<Message> findAllMessage();

    public void updateMesaageStatus(int messageId, String status);

    public Long unreadMessage();

}
