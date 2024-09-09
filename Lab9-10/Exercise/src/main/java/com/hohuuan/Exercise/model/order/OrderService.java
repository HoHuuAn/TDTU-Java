package com.hohuuan.Exercise.model.order;

import com.hohuuan.Exercise.model.orderDetail.OrderDetail;
import com.hohuuan.Exercise.model.orderDetail.OrderDetailRepository;
import com.hohuuan.Exercise.model.orderDetail.OrderDetailService;
import com.hohuuan.Exercise.model.product.Product;
import com.hohuuan.Exercise.model.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderProduct> getAll(){
        return repository.findAll();
    }

    public OrderProduct findById(String id){
        return repository.findById(id).orElse(null);
    }

    public OrderProduct addOrder(OrderProduct orderProduct){
        return repository.save(orderProduct);
    }

    public boolean updateOrder(String id, OrderDetail orderDetail){
        OrderProduct orderProduct = repository.findById(id).orElse(null);
        if(orderProduct == null) return false;

        orderProduct.setTotalSellingPrice(orderProduct.getTotalSellingPrice() +
                (long) orderDetail.getQuantity() * orderDetail.getProduct().getPrice());

        repository.save(orderProduct);

        return true;
    }

    public boolean deleteOrder(String id) {
        try {
            repository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
