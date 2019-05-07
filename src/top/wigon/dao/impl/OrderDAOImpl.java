package top.wigon.dao.impl;

import top.wigon.common.DBUtils;
import top.wigon.common.Pack2Entity;
import top.wigon.dao.OrderDAO;
import top.wigon.entity.Order;

import java.sql.SQLException;
import java.util.*;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 22:07
 **/
public class OrderDAOImpl implements OrderDAO {
    private final String tableName = "tb_order";
    private final String GET_ALL_ORDERS = "SELECT tb_order.order_id,tb_order.user_id,tb_order.payment,tb_order.order_state,tb_order.shipping_name,tb_order.shipping_code FROM tb_order";
    private final String GET_MY_ORDERS = "SELECT\ttb_order.order_id,\ttb_order.user_id,tb_order.order_state,tb_order.payment,\ttb_order.shipping_name,\ttb_order.shipping_code,\ttb_item.item_category,\ttb_order_item.item_title,\ttb_order_item.item_price,\ttb_order_item.total_fee,\ttb_order_item.item_id,\ttb_item.shop_id,\ttb_desc.item_image_path FROM\ttb_order\tLEFT JOIN tb_order_item ON tb_order.order_id = tb_order_item.order_id\tJOIN tb_desc ON tb_order_item.item_id = tb_desc.item_id\tJOIN tb_item ON tb_order_item.item_id = tb_item.item_id WHERE\ttb_order.order_id IN ( SELECT tb_order.order_id FROM tb_order LEFT JOIN tb_order_item ON tb_order.order_id = tb_order_item.order_id\tJOIN tb_desc ON tb_order_item.item_id = tb_desc.item_id\tJOIN tb_item ON tb_order_item.item_id = tb_item.item_id  WHERE shop_id=(SELECT shop_id from tb_shop where user_id=?) )";

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
            flag = DBUtils.insert(tableName, valueMap) == 1;
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
        if (order.getshippingCode() != null) {
            valueMap.put("shipping_code", order.getshippingCode());
        }
        return valueMap;
    }

    @Override
    public Map<String, Object> getPrimaryKey(Order order) {
        Map<String, Object> pk = new HashMap<>();
        pk.put("order_id", order.getOrderId());
        return pk;
    }

    /**
     * 获取订单List
     *
     * @return
     */
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

    /**
     * 通过订单编号获取订单
     *
     * @param no
     * @return
     */
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

    /**
     * 通过订单号获取该订单应付款（适用于订单有多个商品的情况）
     *
     * @param order_no
     * @return
     * @throws Exception
     */
    public String getItemOrderTotalMoney(String order_no) throws Exception {
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("order_id", order_no);
        return (String) DBUtils.queryMult("SELECT SUM(item_num*item_price) payment FROM `tb_order_item` ", whereMap).get(0).get("payment");
    }

    /**
     * 订单付款金额
     *
     * @param order_no
     * @return
     * @throws Exception
     */
    public String getOrderTotalMoney(String order_no) throws Exception {
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("order_id", order_no);
        return (String) DBUtils.queryMult("SELECT payment FROM `tb_order` ", whereMap).get(0).get("payment");
    }

    /**
     * 更新订单状态为已支付
     *
     * @param order_id
     * @param state
     * @return
     */
    public boolean updateOrderState(String order_id, int state) throws SQLException {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("order_state", state);
        valueMap.put("payment_time", DBUtils.getCurrDateTime());
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("order_id", order_id);
        return DBUtils.update(tableName, valueMap, whereMap) == 0;
    }

    /**
     * 通过用户ID 模糊查询该id店铺的订单  分页 限制行数
     *
     * @param userId
     * @param whereMap
     * @param page
     * @param limit
     * @return
     */
    public List<Order> getMyOrders(String userId, Map<String, Object> whereMap, int page, int limit) {
        List<Order> orderList = new ArrayList<>();
        try {
            StringBuilder SQL = new StringBuilder();
            SQL.append(GET_MY_ORDERS.replace("?", userId));
            if (whereMap != null && whereMap.size() > 0) {
                Iterator<String> iterator = whereMap.keySet().iterator();
                //i=1就 会从第一个WherMap 开始 添加条件
                int i = 0;
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    SQL.append(i == 0 ? " where " : " ");
                    SQL.append(i == 0 ? " " : " OR ");
                    SQL.append(key + " like '%" + whereMap.get(key) + "%'");
                    i++;
                }
                SQL.append("LIMIT " + (page == -1 ? 100 : (page - 1) * limit + " , " + limit));
                List<Map<String, Object>> result = DBUtils.executeQuery(SQL.toString(), null);
                orderList = Pack2Entity.pack2orders(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public List<Order> getMyOrders(String userId, int page, int limit) {
        List<Order> users = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.executeQuery(GET_MY_ORDERS.replace("?", userId) + " Limit " + (page == -1 ? 100 : (page - 1) * limit + " , " + limit), null);
            users = Pack2Entity.pack2orders(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Order> getAllOrders(Map<String, Object> whereMap, int page, int limit) {
        List<Order> orderList = new ArrayList<>();
        try {
            StringBuilder SQL = new StringBuilder();
            SQL.append(GET_ALL_ORDERS);
            if (whereMap != null && whereMap.size() > 0) {
                Iterator<String> iterator = whereMap.keySet().iterator();
                //i=1就 会从第一个WherMap 开始 添加条件
                int i = 0;
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    SQL.append(i == 0 ? " where " : " ");
                    SQL.append(i == 0 ? " " : " OR ");
                    SQL.append(key + " like '%" + whereMap.get(key) + "%'");
                    i++;
                }
                SQL.append("LIMIT " + (page == -1 ? 100 : (page - 1) * limit + " , " + limit));
                List<Map<String, Object>> result = DBUtils.executeQuery(SQL.toString(), null);
                orderList = Pack2Entity.pack2orders(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public List<Order> getAllOrders(int page, int limit) {
        List<Order> users = new ArrayList<>();
        try {
            List<Map<String, Object>> result = DBUtils.executeQuery(GET_ALL_ORDERS + " Limit " + (page == -1 ? 100 : (page - 1) * limit + " , " + limit), null);
            users = Pack2Entity.pack2orders(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
