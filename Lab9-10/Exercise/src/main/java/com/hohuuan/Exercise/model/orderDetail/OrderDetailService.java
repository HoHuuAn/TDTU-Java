package com.hohuuan.Exercise.model.orderDetail;

import com.hohuuan.Exercise.model.order.OrderProduct;
import com.hohuuan.Exercise.model.order.OrderRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository repository;
    public List<OrderDetail> getAll(){
        return repository.findAll();
    }

    public OrderDetail addOrderDetail(OrderDetail orderDetail){
        return repository.save(orderDetail);
    }


    public void deleteByOrderProduct(OrderProduct orderProduct){
        repository.deleteByOrder(orderProduct);
    }
    public List<OrderDetail> findAllByOrder(OrderProduct orderProduct){
        return repository.findAllByOrder(orderProduct);
    }
}
