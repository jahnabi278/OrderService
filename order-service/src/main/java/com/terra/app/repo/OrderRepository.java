package com.terra.app.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.terra.app.pojos.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
	@Query("{'listOfOrderLines.listOfAddresses.pinCode':?0}")
	List<Order> findByPinCode(int pinCode);

}
