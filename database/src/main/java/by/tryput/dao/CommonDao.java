package by.tryput.dao;

import by.tryput.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CommonDao {

    private static CommonDao INSTANCE;

    private CommonDao() {
    }

    public static CommonDao getInstance() {
        if (INSTANCE == null) {
            synchronized (CommonDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CommonDao();
                }
            }
        }
        return INSTANCE;
    }

    public Person getPerson() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Person person = session.get(Person.class, 1L);
        person.getActor();
        person.getDirector();
        System.out.println(person);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return person;
    }
}
