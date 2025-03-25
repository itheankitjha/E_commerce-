package com.ecommerce.ShoppingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ecommerce.ShoppingApp.entity.Orders;
import com.ecommerce.ShoppingApp.entity.Person;
import com.ecommerce.ShoppingApp.repository.OrdersRepository;
import com.ecommerce.ShoppingApp.repository.UserRepository;

@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Orders> findAllByName(String name) {
		// TODO Auto-generated method stub
		Person person = userRepository.findByPersonEmail(name);
		return ordersRepository.findByPersonPersonId(person.getPersonId());
	}

	@Override
	public void save(Orders orders) {
		// TODO Auto-generated method stub
		ordersRepository.save(orders);
		
	}

	@Override
	public List<Orders> findByPersonPersonId(long personId) {
		// TODO Auto-generated method stub
		return ordersRepository.findByPersonPersonId(personId);
	}

	@Override
	public Orders findByProductDetails(long personId, long productId) {
		// TODO Auto-generated method stub
		return ordersRepository.findByProductDetails(personId,productId);
	}

	@Override
	public void updateByPersonProductId(long personId, long productId, long cnt) {
		// TODO Auto-generated method stub
		ordersRepository.updateByPersonProductId(personId,productId,cnt);
	}

	@Override
	public void deleteBy(Orders order) {
		// TODO Auto-generated method stub
		ordersRepository.deleteById(order.getOrderId());
	}

}
