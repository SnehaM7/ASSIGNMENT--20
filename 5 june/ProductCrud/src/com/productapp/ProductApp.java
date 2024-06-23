package com.productapp;

import java.util.Iterator;
import java.util.List;

import com.productapp.daoimpl.ProductDAOImpl;
import com.productapp.model.Product;

public class ProductApp {

	public static void main(String[] args) {
		
//		Product p = new Product(6,"IPS Panel",7865);
//		
//		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
//		int result = productDAOImpl.save(p);
//		System.out.println(result);
//		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
//		List<Product> productsList = productDAOImpl.getAll();
//		Iterator<Product> productIterator = productsList.iterator();
//		while(productIterator.hasNext()) {
//			Product product = productIterator.next();
//			System.out.println(product);
//		}
		
//		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
//		Product product = productDAOImpl.getById(784);
//		if(product!=null) {
//			System.out.println(product);
//		}
//		else {
//			System.out.println("Product with given id not found !");
//		}
//		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
//		int result = productDAOImpl.remove(40);
//		System.out.println(result + "row/s deleted");
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		int result = productDAOImpl.update(3, new Product(5,"wireless mouse",1384));
		System.out.println(result);
		
		
		
		
		
	}

}
