package com.ecommerce.ShoppingApp.service;

import java.util.List;

import com.ecommerce.ShoppingApp.entity.Orders;

public interface OrdersService {

	List<Orders> findAllByName(String name);

	void save(Orders orders);

	List<Orders> findByPersonPersonId(long personId);

	Orders findByProductDetails(long personId, long productId);

	void updateByPersonProductId(long personId, long productId, long l);

	void deleteBy(Orders order);

}
