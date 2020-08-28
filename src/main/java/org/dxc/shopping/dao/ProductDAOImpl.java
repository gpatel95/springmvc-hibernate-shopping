package org.dxc.shopping.dao;

import java.util.List;

import org.dxc.shopping.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);

	}

	@Override
	public List<Product> getProducts() {
		Query<Product> query = sessionFactory.getCurrentSession().createQuery("from Product");
		return query.getResultList();
	}

	@Override
	public Product getProduct(int id) {
		Session currentsession = sessionFactory.getCurrentSession();
		Product product = currentsession.get(Product.class, id);
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		Session currentsession = sessionFactory.getCurrentSession();
		Query query =  currentsession.createQuery("delete from Product where id=:productId");
		query.setParameter("productId", id);
		query.executeUpdate();
	}

}
