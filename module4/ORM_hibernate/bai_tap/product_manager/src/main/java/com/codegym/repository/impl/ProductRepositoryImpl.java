package com.codegym.repository.impl;

import com.codegym.entity.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAll() {

        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void createProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        TypedQuery<Product> typedQuery;
        typedQuery = BaseRepository.entityManager.createQuery("select p from product p where id =:idProduct", Product.class);
        typedQuery.setParameter("idProduct", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void updateProduct(Product product) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();

    }

    @Override
    public void deleteProductById(Integer id) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();

    }
}
