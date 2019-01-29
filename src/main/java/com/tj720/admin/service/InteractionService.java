package com.tj720.admin.service;

import java.io.IOException;

public interface InteractionService {
    String createUser(String id) throws UnknownError, Exception;
    String createCulturalRelic(String culturalRelicId, String type) throws Exception;
}
