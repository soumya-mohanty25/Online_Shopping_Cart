package com.aashditcart.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashditcart.test.model.OrderItem;
import com.aashditcart.test.repository.OrderItemRepository;
import com.aashditcart.test.service.OrderItemService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
    private OrderItemRepository orderItemRepository;

	
	@Override
    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();
        try {
            orderItems = orderItemRepository.findAll();
            log.info("Fetched {} order items successfully.", orderItems.size());
        } catch (Exception e) {
            log.error("Exception occurred while fetching all order items: {}", e.getMessage(), e);
        }
        return orderItems;
    }

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        try {
            orderItemRepository.save(orderItem);
            log.info("OrderItem saved successfully: Order ID = {}, Product ID = {}, Quantity = {}",
                     orderItem.getOrder().getId(),
                     orderItem.getProduct().getId(),
                     orderItem.getQuantity());
        } catch (Exception e) {
            log.error("Exception occurred while saving OrderItem: {}", e.getMessage(), e);
        }
    }

    @Override
    public void deleteOrderItem(Long id) {
        try {
            if (orderItemRepository.existsById(id)) {
                orderItemRepository.deleteById(id);
                log.info("OrderItem deleted successfully with ID: {}", id);
            } else {
                log.warn("No OrderItem found with ID: {} for deletion.", id);
            }
        } catch (Exception e) {
            log.error("Exception occurred while deleting OrderItem with ID {}: {}", id, e.getMessage(), e);
        }
    }
}
