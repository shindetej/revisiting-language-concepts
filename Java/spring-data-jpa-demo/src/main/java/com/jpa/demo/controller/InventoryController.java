package com.jpa.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.demo.models.InventoryItem;
import com.jpa.demo.responses.Response;
import com.jpa.demo.services.IInventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	private IInventoryService inventoryService;
	public InventoryController(IInventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

	
	@PostMapping
	public ResponseEntity<?> addInventory(@RequestBody InventoryItem item) {
		if (item != null) {
			InventoryItem retItem = inventoryService.addInventoryItem(item);
			return new ResponseEntity<>(new Response<>("Item added successfully", item, HttpStatus.CREATED.value()),
					HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>(new Response<>("Invalid Input", item, HttpStatus.BAD_REQUEST.value()),
					HttpStatus.BAD_REQUEST);
		}
	}

	
	@GetMapping
	public ResponseEntity<?> getInventoryList(@RequestParam(required = false) Long itemId, @RequestParam(required = false) String itemName,
			@RequestParam(required=false) Double itemPrice) {

		List<InventoryItem> list = inventoryService.getInventoryList(itemId, itemName, itemPrice);
		if (list != null)
			if(!list.isEmpty())
			return new ResponseEntity<>(new Response<>("Success", list, HttpStatus.OK.value()), HttpStatus.OK);
			else {
				return new ResponseEntity<>(new Response<>("Failed", list, HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
			}
		else
			return new ResponseEntity<>(new Response<>("Failed", list, HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/{itemId}")
    public ResponseEntity<?> updateInventoryItem(
            @PathVariable Integer itemId, 
            @RequestBody InventoryItem updatedItem) {
        InventoryItem updatedInventoryItem = inventoryService.updateInventoryItem(itemId, updatedItem);
          return new ResponseEntity<>(new Response<>("Success", updatedInventoryItem, HttpStatus.OK.value()), HttpStatus.OK);
    }

}