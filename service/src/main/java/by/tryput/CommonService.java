package by.tryput;

import by.tryput.dao.CommonDao;
import by.tryput.entity.CommonEntity;

public class CommonService {

    public CommonEntity getEntity(String text) {
        return new CommonDao().getEntity(text);
    }
}
