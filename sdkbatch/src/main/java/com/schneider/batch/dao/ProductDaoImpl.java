package com.schneider.batch.dao;

import com.schneider.batch.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * Created by SESA439295 on 6/21/2017.
 */
@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;
    Session session=null;


    @Override
    public List<Product> getList() {
        System.out.println("transaction status in DAO layer GET is:    " + TransactionSynchronizationManager.isActualTransactionActive());
        session=sessionFactory.getCurrentSession();
        return session.createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

    }

    @Override
    public Product addProduct(Product product) throws Exception {
        System.out.println("transaction status in DAO layer POST is:   " + TransactionSynchronizationManager.isActualTransactionActive());
        session=sessionFactory.getCurrentSession();
        try {
            session.save(product);
            session.flush();
        }catch(Exception ex){
            //TODO: Needs proper exception handling
            ex.printStackTrace();
            throw new Exception();
        }
        return product;

    }
}
