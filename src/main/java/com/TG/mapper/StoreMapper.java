package com.TG.mapper;

import com.TG.pojo.Store;
import java.util.List;

public interface StoreMapper {
    List<Store> getAll();
    List<Store> getItemById(int id);
    int getGoldPrice(int itemId);
    int getAttribute(int itemId);
}
