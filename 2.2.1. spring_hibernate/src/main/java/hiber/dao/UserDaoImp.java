package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   
   @Override
   @SuppressWarnings("unchecked")
   public User getUserByCar(String model, int series) {
	   String hql = "from User where car.series = :s and car.model = :m";
	   TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
	   query.setParameter("s", series);
	   query.setParameter("m", model);
	   return query.getSingleResult();
   }

}

