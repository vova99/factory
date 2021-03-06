package com.favor.factory.service;


import com.favor.factory.entity.ViberUserProfile;
import com.viber.bot.api.MessageDestination;
import com.viber.bot.profile.UserProfile;

import java.util.List;

public interface ViberUserProfileService {
    ViberUserProfile save(ViberUserProfile viberUserProfile);
    ViberUserProfile save(UserProfile user, String chatId);
    MessageDestination convertUser(ViberUserProfile user);
    ViberUserProfile findById(String id);
    List<ViberUserProfile> findAll();
    List<MessageDestination> findAllAndConvert();
    void deleteByID(String id);
}
