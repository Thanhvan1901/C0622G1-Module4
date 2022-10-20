package codegym.repository;

import codegym.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

import static codegym.repository.ConnectionUtil.sessionFactory;

@Repository
public class ProductManagerRepository implements IProductManagerRepository {

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = sessionFactory.openSession();
            productList = session.createQuery("FROM Product ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void save(Product produc) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(produc);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select p from Product as p where p.id = : id", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Product update(Product product) {
        Session session = null ;
        Transaction transaction = null ;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product origin = findById(product.getId());
            origin.setId(product.getId());
            origin.setName(product.getName());
            origin.setPrice(product.getPrice());
            origin.setDescription(product.getDescription());
            origin.setProducer(product.getProducer());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin ;
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
        }
    }finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        Transaction transaction = null ;
        Session session = null ;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product origin = findById(id);
            session.remove(origin);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> search(String name) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select p from Product as p where p.name like :name", Product.class);
        query.setParameter("name","%"+ name+"   %");
        return query.getResultList();
    }
}
