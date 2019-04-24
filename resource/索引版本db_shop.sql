DROP DATABASE if EXISTS db_shop ;
CREATE DATABASE db_shop;
USE db_shop;
CREATE TABLE `tb_user` (
`user_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
`username` varchar(64) NULL,
`password` varchar(64) NULL,
`tel` varchar(12) NULL,
`email` varchar(64) NULL,
`avatar_path` varchar(200) NULL,
`role_type` tinyint(2) NULL COMMENT '0：普通用户;1：商家;2:超级管理员',
`gmt_create` datetime NULL DEFAULT CURRENT_TIMESTAMP,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`user_id`) ,
UNIQUE INDEX (`user_id` ASC) USING BTREE
);
CREATE TABLE `tb_order` (
`order_id` varchar(64) NOT NULL,
`user_id` bigint(20) UNSIGNED NOT NULL,
`payment` decimal(9,2) NULL,
`payment_type` tinyint(2) NULL COMMENT '支付类型1、在线支付，2、货到付款',
`post_fee` decimal(9,2) NULL,
`order_state` tinyint(2) NULL COMMENT '订单状态1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易失败',
`create_time` datetime NULL,
`update_time` datetime NULL,
`payment_time` datetime NULL,
`consign_time` datetime NULL,
`receive_time` datetime NULL,
`end_time` datetime NULL,
`close_time` datetime NULL,
`shipping_name` varchar(64) NULL,
`shipping_code` varchar(64) NULL,
`gmt_create` datetime NULL DEFAULT CURRENT_TIMESTAMP,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`order_id`) ,
UNIQUE INDEX `order_id` (`order_id` ASC) USING BTREE
);
CREATE TABLE `tb_shipping` (
`id` int(9) UNSIGNED NOT NULL,
`order_id` varchar(64) NULL,
`receiver_name` varchar(64) NULL,
`receiver_tel` varchar(64) NULL,
`receiver_state` varchar(10) NULL,
`receiver_city` varchar(10) NULL,
`receiver_district` varchar(20) NULL,
`receiver_address` varchar(200) NULL,
`receiver_zip` varchar(7) NULL,
`gmt_create` datetime NULL DEFAULT CURRENT_TIMESTAMP,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
);
CREATE TABLE `tb_item` (
`item_id` varchar(64) NOT NULL,
`item_title` varchar(100) NULL,
`item_category` varchar(64) NULL,
`item_price` decimal(9,2) NULL,
`item_stock` int(10) NULL,
`item_state` tinyint(2) NULL DEFAULT 1 COMMENT '1、正常，2、下架，3、删除',
`shop_id` int(9) UNSIGNED NULL,
`gmt_create` datetime NULL DEFAULT CURRENT_TIMESTAMP,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`item_id`) ,
UNIQUE INDEX `item_title` (`item_title` ASC) USING BTREE,
UNIQUE INDEX `item_price` (`item_price` ASC) USING BTREE,
UNIQUE INDEX `item_id` (`item_id` ASC) USING BTREE
);
CREATE TABLE `tb_shop` (
`shop_id` int(9) UNSIGNED NOT NULL,
`user_id` bigint(20) NULL,
`shop_name` varchar(64) NULL,
`gmt_create` datetime NULL DEFAULT CURRENT_TIMESTAMP,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`shop_id`) ,
UNIQUE INDEX `shop_id` (`shop_id` ASC) USING BTREE
);
CREATE TABLE `tb_order_item` (
`id` int(9) UNSIGNED NOT NULL,
`item_id` varchar(64) NULL,
`order_id` varchar(64) NULL,
`item_num` int(10) NULL,
`item_title` varchar(100) NULL,
`item_price` decimal(9,2) NULL,
`total_fee` decimal(9,2) NULL,
`gmt_create` datetime NULL DEFAULT CURRENT_TIMESTAMP,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
);
CREATE TABLE `tb_desc` (
`id` int(9) NOT NULL,
`item_id` varchar(64) NULL,
`item_image_path` varchar(200) NULL,
`item_desc` text NULL,
`gmt_create` datetime NULL DEFAULT CURRENT_TIMESTAMP,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE `tb_shop_info` (
`id` int(9) NOT NULL,
`shop_id` int(9) NULL,
`shop_desc` varchar(200) NULL,
`shop_logo_path` varchar(200) NULL,
`gmt_create` datetime NULL DEFAULT CURRENT_TIMESTAMP,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) 
);
CREATE TABLE `tb_alipay_detail` (
`id` int(9) NULL,
`order_id` varchar(64) NULL,
`buyer_id` int(9) NULL,
`seller_id` int(9) NULL,
`seller_trade_no` varchar(64) NULL,
`alipay_trade_no` varchar(64) NULL,
`payment` decimal(9,2) NULL,
`gmt_create` datetime NULL DEFAULT CURRENT_TIMESTAMP,
`gmt_modified` datetime NULL ON UPDATE CURRENT_TIMESTAMP
);
