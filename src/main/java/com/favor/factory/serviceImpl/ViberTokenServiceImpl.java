package com.favor.factory.serviceImpl;

import com.favor.factory.entity.ViberToken;
import com.favor.factory.jpa.ViberTokenJPA;
import com.favor.factory.service.ViberTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ViberTokenServiceImpl implements ViberTokenService {
    private ViberTokenJPA tokenJPA;
    @Override
    public UUID getToken() {
        ViberToken viberToken = tokenJPA.findById(1).orElse(null);
        if(viberToken==null){
            return generateNewToken();
        }
        return viberToken.getUuid();
    }

    @Override
    public UUID generateNewToken() {
        ViberToken viberToken = new ViberToken(1,UUID.randomUUID());
        tokenJPA.save(viberToken);
        return viberToken.getUuid();
    }
}
