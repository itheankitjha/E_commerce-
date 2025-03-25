package com.ecommerce.ShoppingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerce.ShoppingApp.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{

	List<Orders> findByPersonPersonId(long personId);
	@Query(value = "select * from orders ord where ord.person_person_id= ?1 and ord.product_product_id= ?2 order by created_at",nativeQuery = true)
	Orders findByProductDetails(long personId, long productId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE orders SET product_count=?3 where person_person_id= ?1 and product_product_id= ?2",nativeQuery = true)
	void updateByPersonProductId(long personId, long productId, long cnt);

}
