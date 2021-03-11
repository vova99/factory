package com.favor.factory.viber;


import com.favor.factory.entity.OrderInfo;
import com.favor.factory.service.ViberTokenService;
import com.favor.factory.service.ViberUserProfileService;
import com.viber.bot.Response;
import com.viber.bot.api.MessageDestination;
import com.viber.bot.api.ViberBot;
import com.viber.bot.event.incoming.IncomingMessageEvent;
import com.viber.bot.message.Message;
import com.viber.bot.message.TextMessage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ViberListenerServiceImpl implements ViberListenerService {
    private final ViberUserProfileService viberUserProfileService;
    private final ViberTokenService viberTokenService;
    private final ViberBot viberBot;

    public ViberListenerServiceImpl(ViberUserProfileService viberUserProfileService, ViberTokenService viberTokenService,@Lazy ViberBot viberBot) {
        this.viberUserProfileService = viberUserProfileService;
        this.viberTokenService = viberTokenService;
        this.viberBot = viberBot;
    }

    @Override
    public void messageReceived(IncomingMessageEvent event, Message message, Response response) {
        TextMessage responseText = null;
        System.out.println(event.getChatId());
        System.out.println(event.getToken());
        System.out.println(event.getSender());
        System.out.println(message.toString());
        if(message.getType().equals("text")){
            TextMessage textMessage = (TextMessage) message;
            if(textMessage.getText().contains(viberTokenService.getToken().toString())){
                if(viberUserProfileService.findById(event.getSender().getId())==null) {
                    viberUserProfileService.save(event.getSender(), event.getChatId());
                }
                responseText = new TextMessage("Ви успішно підписані на сповіщення.");
            }

            if(textMessage.getText().contains("Stop") || textMessage.getText().contains("Стоп")){
                viberUserProfileService.deleteByID(event.getSender().getId());
                responseText = new TextMessage("Сповіщення вимкнено.");
            }
            if(responseText!=null) {
                response.send(responseText);
            }else {
                response.send(message);
            }
        }
    }

    @Override
    public void sendForAll(OrderInfo orderInfo) {
        String str = "Ім'я: "+orderInfo.getName()+
                "\nТелефон: "+orderInfo.getPhone()+
                "\nОпис: "+orderInfo.getDescription();


        TextMessage message = new TextMessage(str);
        for(MessageDestination msg : viberUserProfileService.findAllAndConvert()){
            viberBot.sendMessage(msg,message);
        }
    }

    @Override
    public void sendForAll(String name, String phone, String description) {
        TextMessage message;
        if(description==null || description.isEmpty()){
             message = new TextMessage(
                    "Ім'я: "+name+
                            "\nТелефон: "+phone
            );
        }else {
            message = new TextMessage(
                    "Ім'я: "+name+
                            "\nТелефон: "+phone+
                            "\nОпис: "+description
            );
        }
        for(MessageDestination msg : viberUserProfileService.findAllAndConvert()){
            viberBot.sendMessage(msg,message);
        }
    }
}
