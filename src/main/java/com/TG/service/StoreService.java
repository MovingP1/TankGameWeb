package com.TG.service;

import com.TG.pojo.Store;

import java.io.IOException;
import java.util.List;

public interface StoreService {
    List<Store> getAll() throws IOException;
    List<Store> getItemById(int id) throws IOException;
    int getTankIdByName(String name) throws IOException;
    int getGoldPrice(int itemId) throws IOException;
    int getAttribute(int itemId) throws IOException;
}
