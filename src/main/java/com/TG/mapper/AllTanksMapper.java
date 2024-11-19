package com.TG.mapper;

public interface AllTanksMapper {
    String getTankName(int tank_id);
    int getTankIdByName(String tankName);
}
