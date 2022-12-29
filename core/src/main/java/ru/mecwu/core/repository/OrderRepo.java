package ru.mecwu.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mecwu.core.entity.OrderEntity;

@Repository
public interface OrderRepo extends CrudRepository<OrderEntity, Long> {
}
