package com.jpa.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jpa.demo.models.InventoryItem;

@Repository
public interface IInventoryItemRepository extends  JpaRepository<InventoryItem,Integer>, JpaSpecificationExecutor<InventoryItem> {

}
