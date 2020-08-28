package org.dxc.shopping.service;

import java.util.List;

import javax.transaction.Transactional;

import org.dxc.shopping.dao.ProductDAO;
import org.dxc.shopping.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	

	@Override
	@Transactional
	public void saveProduct(Product product) {
		productDAO.saveProduct(product);

	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public Product getProduct(int id) {
		
		return productDAO.getProduct(id);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
	 productDAO.deleteProduct(id);
	 
		
	}

}