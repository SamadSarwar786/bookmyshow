package com.example.BMS.services;

import org.springframework.stereotype.Service;

@Service
public interface CacheService {

    void set(String key, String value);

    String get(String key);

    void delete(String key);

    void getAllKeysAndValues();

    void deleteAll();
}