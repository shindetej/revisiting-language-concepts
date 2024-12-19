package com.jpa.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.demo.models.ItemOrder;

@Repository
public interface IOrderRepository extends JpaRepository<ItemOrder, Integer> {

	@Query("SELECT o FROM ItemOrder o JOIN o.items i WHERE i.itemId = :inventoryId")
    List<ItemOrder> findOrdersByInventoryItem(@Param("inventoryId") Long inventoryId);

}
