package com.favor.factory.viber;


import com.favor.factory.entity.OrderInfo;
import com.viber.bot.event.callback.OnMessageReceived;

public interface ViberListenerService extends OnMessageReceived {
    void sendForAll(OrderInfo orderInfo);
    void sendForAll(String name, String phone, String description);
}
