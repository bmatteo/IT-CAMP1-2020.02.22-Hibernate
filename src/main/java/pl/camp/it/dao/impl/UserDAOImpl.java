package pl.camp.it.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.dao.IUserDAO;
import pl.camp.it.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void persistUser(User user) {
        Transaction tx = null;
        try {
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();
            //update tylko po ID
            session.saveOrUpdate(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
            /*
            Query q = session.createQuery("FROM pl.camp.it.model.User WHERE id = " + id);
            User user = (User) q.uniqueResult();
            */
        User user = (User) session
                .createQuery("FROM pl.camp.it.model.User WHERE id = " + id)
                .uniqueResult();

        return user;
        /*
        return (User) sessionFactory.openSession().createQuery("FROM pl.camp.it.model.User WHERE id = " + id)
                .uniqueResult();
                */
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        return session.createQuery("FROM pl.camp.it.model.User").list();
    }
}
