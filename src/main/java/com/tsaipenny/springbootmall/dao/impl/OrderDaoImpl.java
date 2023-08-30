package com.tsaipenny.springbootmall.dao.impl;

import com.tsaipenny.springbootmall.dao.OrderDao;
import com.tsaipenny.springbootmall.dto.OrderQueryParams;
import com.tsaipenny.springbootmall.model.Order;
import com.tsaipenny.springbootmall.model.OrderItem;
import com.tsaipenny.springbootmall.rowmapper.OrderItemRowMapper;
import com.tsaipenny.springbootmall.rowmapper.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer countOrder(OrderQueryParams orderQueryParams) {
        String sql = "SELECT count(*)  FROM `order` WHERE user_id = :userId";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", orderQueryParams.getUserId());

        Integer count = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
        return count;
    }

    @Override
    public List<Order> getOrders(OrderQueryParams orderQueryParams) {
        String sql = "SELECT order_id, user_id, total_amount, created_date, last_modified_date " +
                "FROM `order` WHERE user_id = :userId";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", orderQueryParams.getUserId());

        // 排序
        sql = sql + " ORDER BY created_date DESC";

        // 分頁
        sql = sql + " LIMIT :limit OFFSET :offset";
        map.put("limit", orderQueryParams.getLimit());
        map.put("offset", orderQueryParams.getOffset());

        List<Order> orderList = namedParameterJdbcTemplate.query(sql, map, new OrderRowMapper());

        return orderList;
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Integer orderId) {
        String sql = "SELECT oi.order_item_id, oi.order_id, oi.product_id, oi.quantity, " +
                "oi.amount, p.product_name, p.image_url FROM order_item AS oi LEFT JOIN product AS p " +
                "ON oi.product_id = p.product_id WHERE oi.order_Id = :orderId";
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", orderId);

        List<OrderItem> orderItemList = namedParameterJdbcTemplate.query(sql, map, new OrderItemRowMapper());

        return orderItemList;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        String sql = "SELECT order_id, user_id, total_amount, created_date, last_modified_date " +
                "FROM `order` WHERE order_id = :orderId";
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", orderId);

        List<Order> orderList = namedParameterJdbcTemplate.query(sql, map, new OrderRowMapper());

        if(orderList.size() > 0){
            return orderList.get(0);
        }else {
            return null;
        }
    }



    @Override
    public Integer createOrder(Integer userId, Integer totalAmount) {
        String sql = "INSERT INTO `order`(user_id, total_amount, created_date, last_modified_date)" +
                " VALUES(:userId, :totalAmount, :createdDate, :lastModifiedDate)";
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("totalAmount", totalAmount);
        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int orderId = keyHolder.getKey().intValue();

        return orderId;
    }

    @Override
    public void createOrderItems(Integer orderId, List<OrderItem> orderItemList) {
        String sql = "INSERT INTO order_item(order_id, product_id, quantity, amount) " +
                "VALUES(:orderId, :productId, :quantity, :amount)";

        MapSqlParameterSource[] sqlParameterSources = new MapSqlParameterSource[orderItemList.size()];

        for (int i=0; i< sqlParameterSources.length; i++){
            OrderItem orderItem = orderItemList.get(i);

            sqlParameterSources[i] = new MapSqlParameterSource();
            sqlParameterSources[i].addValue("orderId", orderId);
            sqlParameterSources[i].addValue("productId", orderItem.getProductId());
            sqlParameterSources[i].addValue("quantity", orderItem.getQuantity());
            sqlParameterSources[i].addValue("amount", orderItem.getAmount());
        }

        namedParameterJdbcTemplate.batchUpdate(sql, sqlParameterSources);
    }
}
