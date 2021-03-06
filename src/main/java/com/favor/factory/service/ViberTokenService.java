package com.favor.factory.service;

import java.util.UUID;

public interface ViberTokenService {
    UUID getToken();
    UUID generateNewToken();
}
