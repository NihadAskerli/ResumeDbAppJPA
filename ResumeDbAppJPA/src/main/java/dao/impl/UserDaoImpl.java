package dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import entity.User;
import dao.inter.AbstractDao;
import dao.inter.UserDaoInter;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {





    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        EntityManager em = em();
        String jpql = "select u from User u where 1=1 ";
        Query q = em.createQuery(jpql, User.class);

//            String sql = "SELECT"
//                    + "\tu.*,"
//                    + "\tn.nationality,"
//                    + "\tc.nationality AS birthplace "
//                    + "FROM"
//                    + "\tUSER u"
//                    + "\tLEFT JOIN country n ON u.nationality_id = n.id "
//                    + "\tLEFT JOIN country c on u.birthplace_id=c.id where 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname";
        }
        if (nationalityId != null) {
            jpql += " and u.nationality.id=:nid";
        }

        Query query = em.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);

        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (nationalityId != null) {
            query.setParameter("nid", nationalityId);
        }

        return query.getResultList();
    }
//JPQl
    @Override
    public User findByEmailAndPassword(String email, String password) {

        EntityManager em = em();
        Query q = em.createQuery("select u from User u u.email=:e and u.password=:p",
                User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);
        List<User> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;

    }
//    Criterial Builder
//    @Override
//    public User findByEmail(String email){
//        
//        EntityManager em = em();
//        CriteriaBuilder cb=em.getCriteriaBuilder();
//        CriteriaQuery<User> q1=cb.createQuery(User.class);
//        Root<User> postRoot=q1.from(User.class);
//        CriteriaQuery<User>q2=q1
//        .where(cb.equal( postRoot.get("email"),email));
//        Query query = em.createQuery(q2);
////        q.setParameter("e", email);
////        q.setParameter("p", password);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
// jpql
    @Override
    public User findByEmail(String email) {
        EntityManager em = em();
        Query q = em.createQuery("select u from User u where u.email=:e",
                User.class);
        q.setParameter("e", email);

        List<User> list = q.getResultList();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
//    Named Query
//        @Override
//    public User findByEmail(String email){
//                EntityManager em = em();
//             Query query = em.createNamedQuery("User.findByEmail",User.class);
//
//        query.setParameter("email", email);
//
//        List<User> list = query.getResultList();
//        if (list.size() > 0) {
//            return list.get(0);
//        }
//        return null;
//  
//    }
//            @Override
//    public User findByEmail(String email){
//                EntityManager em = em();
//             Query query = em.createNativeQuery("select * from user where email=?",User.class);
//
//        query.setParameter(1, email);
//
//        List<User> list = query.getResultList();
//        if (list.size() > 0) {
//            return list.get(0);
//        }
//        return null;
//  
//    }

    @Override
    public User getById(int userId) {
        EntityManager em = em();
        User u = em.find(User.class, userId);
        em.close();
        return u;
    }

    @Override
    public boolean updateUser(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }
    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeUser(int id) {

        EntityManager em = em();
        User u = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
