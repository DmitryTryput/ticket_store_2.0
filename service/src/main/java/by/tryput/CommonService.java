package by.tryput;

import by.tryput.dao.CommonDao;
import by.tryput.entity.Person;

public class CommonService {



    public Person getPerson() {
        return CommonDao.getInstance().getPerson();
    }
}
