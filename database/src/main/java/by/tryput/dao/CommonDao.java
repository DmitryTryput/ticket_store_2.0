package by.tryput.dao;

import by.tryput.entity.CommonEntity;

public class CommonDao {

    public CommonEntity getEntity(String text) {
        return new CommonEntity(text);
    }
}
