package guru.springframework.reposervices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.domain.Order;
import guru.springframework.repositories.OrderRepository;
import guru.springframework.services.OrderService;

@Service
@Profile({"springdatajpa", "jpadao"})
public class OrderServiceRepoImpl implements OrderService{
	
	OrderRepository orderRepository;
	
	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	public List<?> listAll() {
		List<Order> orderList = new ArrayList<>();
		orderRepository.findAll().forEach(orderList::add);
		return orderList;
	}

	@Override
	public Order getById(Integer id) {
		return orderRepository.findOne(id);
	}

	@Override
	public Order saveOrUpdate(Order domainObject) {
		return orderRepository.save(domainObject);
	}

	@Override
	public void delete(Integer id) {
		orderRepository.delete(id);
		
	}

}
