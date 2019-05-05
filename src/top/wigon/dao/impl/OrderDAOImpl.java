package top.wigon.dao.impl;

import top.wigon.dao.OrderDAO;
import top.wigon.common.DBUtils;
import top.wigon.common.Pack2Entity;
import top.wigon.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 22:07
 **/
public class OrderDAOImpl implements OrderDAO {
    private final String tableName = "tb_order";

    @Override
    public Order findByEntity(Order order) {
        List<Map<String, Object>> result = null;
        try {
            result = DBUtils.query(tableName, getPrimaryKey(order));

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null) {
            //通过唯一ID查找 返回第一个
            return Pack2Entity.pack2orders(result).get(0);
        } else {
            return new Order();
        }

    }

    @Override
    public Boolean addEntity(Order order) {
        Map<String, Object> valueMap = getValMap(order);
        boolean flag = false;
        try {
            flag = DBUtils.insert(tableName, valueMap) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("订单添加失败");
        }
        return flag;
    }

    @Override
    public boolean updateEntity(Order order) {
        boolean flag = false;
        try {
            flag = DBUtils.update(tableName, getValMap(order), getPrimaryKey(order)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteEntity(Order order) {
        boolean flag = false;
        try {
            flag = DBUtils.delete(tableName, getPrimaryKey(order)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delUserOrder(String order_id, String user_id) {
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("order_id", order_id);
        whereMap.put("user_id", user_id);
        boolean flag = false;
        try {
            flag = DBUtils.delete(tableName, whereMap) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Map<String, Object> getValMap(Order order) {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("order_id", order.getOrderId());
        valueMap.put("user_id", order.getUserId());
//        valueMap.put("payment", order.getPayment());
//        valueMap.put("payment_type", order.getPaymentType());
//        valueMap.put("post_fee", order.getPostFee());
//        valueMap.put("order_state", order.getOrderState());
        valueMap.put("create_time", order.getOrderCreateTime());
        valueMap.put("payment_time", order.getPaymentTime());
        valueMap.put("consign_time", order.getConsignTime());
        valueMap.put("receive_time", order.getReceiveTime());
        valueMap.put("end_time", order.getEndTime());
        valueMap.put("close_time", order.getCloseTime());
        if (order.getShippingName() != null) {
            valueMap.put("shipping_name", order.getShippingName());
        }
        if (order.getShipingCode() != null) {
            valueMap.put("shipping_code", order.getShipingCode());
        }
        return valueMap;
    }

    @Override
    public Map<String, Object> getPrimaryKey(Order order) {
        Map<String, Object> pk = new HashMap<>();
        pk.put("order_id", order.getOrderId());
        return pk;
    }

    public List<Order> getAllOrders() {
        List<Order> items = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.query(tableName, null);
            items = Pack2Entity.pack2orders(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public Order getByOrderNo(String no) {
        Order order = new Order();
        order.setOrderId(no);
        List<Map<String, Object>> result = null;
        try {
            //只会得到一个结果
            result = DBUtils.query(tableName, getPrimaryKey(order));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Pack2Entity.pack2orders(result).get(0);
    }

    public String getItemOrderTotalMoney(String order_no) throws Exception {
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("order_id", order_no);
        return (String) DBUtils.queryMult("SELECT SUM(item_num*item_price) payment FROM `tb_order_item` ", whereMap).get(0).get("payment");
    }

    public String getOrderTotalMoney(String order_no) throws Exception {
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("order_id", order_no);
        return (String) DBUtils.queryMult("SELECT payment FROM `tb_order` ", whereMap).get(0).get("payment");
    }

    /**
     * 更新订单状态
     *
     * @param order_id
     * @param state
     * @return
     */
    public boolean updateOrderState(String order_id, int state) throws SQLException {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("order_state", state);
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("order_id", order_id);
        return DBUtils.update(tableName, valueMap, whereMap) == 0;
    }
}
