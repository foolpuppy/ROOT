/*
 Navicat Premium Data Transfer

 Source Server         : 开发环境数据库
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : db_shop

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 03/06/2019 19:09:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_alipay_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_alipay_detail`;
CREATE TABLE `tb_alipay_detail`  (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buyer_id` int(9) NULL DEFAULT NULL,
  `seller_id` int(9) NULL DEFAULT NULL,
  `seller_trade_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `alipay_trade_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payment` decimal(9, 2) NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_desc
-- ----------------------------
DROP TABLE IF EXISTS `tb_desc`;
CREATE TABLE `tb_desc`  (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_image_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 456466 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_desc
-- ----------------------------
INSERT INTO `tb_desc` VALUES (2, '1000000255', 'img/c9650f003a4c5654.jpg', '惠普（HP）战66 二代 13.3英寸轻薄笔记本电脑（i5-8265U 8G 256G PCIe SSD Win10 一年上门）银色', '2019-05-01 12:46:48', '2019-05-07 13:10:25');
INSERT INTO `tb_desc` VALUES (3, '1000000256', 'img/31df3c468a9490e5.jpg', '【新品上市】APPLE苹果2019新款iPad mini5/mini4平板电脑7.9英寸 金色 【新品】mini5-64G-WLAN版', '2019-05-01 12:53:46', '2019-05-07 13:47:24');
INSERT INTO `tb_desc` VALUES (4, '1000000257', 'img/56fcc54fN70430aa6.jpg', '索尼（SONY）HDR-AS50 酷拍运动相机/摄像机（电子防抖 60米水下防水壳 3倍变焦）', '2019-05-01 12:57:15', NULL);
INSERT INTO `tb_desc` VALUES (5, '1000000258', 'img/dfd0c13359e341ae.jpg', 'GoPro HERO7 Black黑色 运动相机摄像机vlog 4K户外水下潜水视频直播 摄像机 HyperSmooth坚固耐用+防水', '2019-05-01 13:00:42', NULL);
INSERT INTO `tb_desc` VALUES (6, '1000000259', 'img/097a4682fa14f5bc.jpg', 'Insta360 Pro 2专业级8K 3D全景相机运动防抖（含图传系统）5G VR直播推荐解决方案', '2019-05-01 13:01:07', NULL);
INSERT INTO `tb_desc` VALUES (7, '1000000260', 'img/8de85dfb81c2618e.jpg', 'GoPro HERO7 Black 限定红色礼盒（含内存卡，红色硅胶套）运动相机摄像机vlog', '2019-05-01 13:02:49', NULL);
INSERT INTO `tb_desc` VALUES (8, '1000000261', 'img/5b4f0e3aN262237fc.jpg', 'Apple Macbook Pro 15.4【带触控栏】Core i7 16G 512G RP560X深空灰 苹果笔记本电脑轻薄本工作站MR942CH/A', '2019-05-01 13:04:47', NULL);
INSERT INTO `tb_desc` VALUES (9, '1000000262', 'img/70e84d1d269937ed.jpg', 'Apple AirPods 配充电盒 苹果蓝牙耳机', '2019-05-01 13:07:10', '2019-05-07 13:36:10');
INSERT INTO `tb_desc` VALUES (10, '1000000263', 'img/5bc0914fN9c0e3876.jpg', '索尼（SONY）WH-1000XM3 高解析度无线蓝牙降噪耳机（触控面板 智能降噪 长久续航）黑色', '2019-05-01 13:09:14', NULL);
INSERT INTO `tb_desc` VALUES (11, '1000000264', 'img/c9bc15728688520c.jpg', 'Bose QuietControl 30 无线耳机 QC30耳塞式蓝牙降噪耳麦', '2019-05-01 13:09:15', '2019-05-01 13:10:51');
INSERT INTO `tb_desc` VALUES (13, '1000000266', 'img/579c50c0N9017e5a3.jpg', '海南红心木瓜 2个装 单果约450g-500g 新鲜水果', '2019-05-01 13:17:12', NULL);
INSERT INTO `tb_desc` VALUES (14, '1000000267', 'img/57c1734e44fe2dc4.jpg', '【现采现发】优选新鲜水蜜桃桃子 非阳山水蜜桃肥桃黄桃油桃毛桃 孕妇时令应季水果 5斤精品果', '2019-05-01 13:18:30', '2019-05-01 14:50:37');
INSERT INTO `tb_desc` VALUES (15, '1000000268', 'img/58396dfdN8e10c77e.jpg', '绿鲜知 荷兰黄瓜 约600g 新鲜蔬菜', '2019-05-01 13:19:54', NULL);
INSERT INTO `tb_desc` VALUES (16, '1000000269', 'img/ce3fc6374fa932f7.jpg', 'SK-II唯白晶焕润透修护面膜6p（SK2日本面膜女 护肤品 补水保湿 美白祛斑 高渗透 化妆品）', '2019-05-01 13:26:51', NULL);
INSERT INTO `tb_desc` VALUES (17, '1000000270', 'img/b4632b9c3fb69e5f.jpg', 'SK-II日间护肤精华喷雾50ml（神仙水补水保湿护肤品 面部护肤 精华液 补妆定妆）', '2019-05-01 13:28:10', NULL);
INSERT INTO `tb_desc` VALUES (18, '1000000271', 'img/5ab47b47N56a9ce8a.jpg', '迪奥（Dior）烈艳蓝金唇膏口红3.5g 080(滋润保湿 妆感舒悦 微笑红色', '2019-05-01 13:29:45', NULL);
INSERT INTO `tb_desc` VALUES (19, '1000000272', 'img/5be956ddN251f279e.jpg', '迪奥（Dior）魅惑润唇蜜001# 3.5g(又名：克里斯汀迪奥魅惑润唇膏001)变色 持久保湿', '2019-05-01 13:30:55', NULL);
INSERT INTO `tb_desc` VALUES (20, '1000000273', 'img/5b226dd4N211675fa.jpg', '魅可（MAC)经典唇膏 子弹头口红3g Chili 秀智色/小辣椒色', '2019-05-01 13:32:38', NULL);
INSERT INTO `tb_desc` VALUES (21, '1000000274', 'img/55ded74cNdf9979db.jpg', '茅台 赖茅 传承蓝 53度 500ml*6瓶 整箱装 酱香型白酒（新老包装随机发货）', '2019-05-01 13:32:39', '2019-05-01 13:34:25');
INSERT INTO `tb_desc` VALUES (22, '1000000275', 'img/5b166771N82deb328.jpg', '茅台 王子酒 53度 白酒 500ml*6瓶 整箱装 口感酱香型（新老包装随机发货）', '2019-05-01 13:35:35', NULL);
INSERT INTO `tb_desc` VALUES (23, '1000000276', 'img/04d1be08d2d7ebe1.jpg', '贵州茅台酒 43度飞天茅台 酱香型白酒 500ml单瓶装', '2019-05-01 13:36:37', '2019-05-01 13:37:31');
INSERT INTO `tb_desc` VALUES (24, '1000000277', 'img/e6dc1cbb45b7cd0a.jpg', '贵州茅台 飞天 43度 酱香型白酒 500ml*6瓶整箱装', '2019-05-01 13:37:30', '2019-05-01 13:37:55');
INSERT INTO `tb_desc` VALUES (25, '1000000278', 'img/cacc9985eb090ac5.jpg', '戴尔DELL游匣G315.6英寸英特尔酷睿i7游戏笔记本电脑(i7-8750H 8G 128G 1T GTX1060MQ 6G独显 背光键盘 IPS)', '2019-05-01 14:28:42', NULL);
INSERT INTO `tb_desc` VALUES (26, '1000000279', 'img/2b7a42c393cad4f2.jpg', '微软（Microsoft）Surface Pro 6 二合一平板电脑笔记本 12.3英寸（第八代Core i5 8G 128G SSD）亮铂金', '2019-05-01 14:36:00', NULL);
INSERT INTO `tb_desc` VALUES (27, '1000000280', 'img/4699ebb5778f2600.jpg', '美丽蟹后 小龙虾熟食 鲜活加热即食 海鲜水产 麻辣小龙虾35-50只中号1.8kg 4-6钱', '2019-05-01 14:39:34', NULL);

-- ----------------------------
-- Table structure for tb_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_item`;
CREATE TABLE `tb_item`  (
  `item_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `item_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_category` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_price` decimal(9, 2) NULL DEFAULT 0.00,
  `item_stock` int(10) NULL DEFAULT 0,
  `item_state` tinyint(2) NULL DEFAULT 1 COMMENT '1、正常，2、下架，3、删除',
  `shop_id` int(9) UNSIGNED NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`item_id`) USING BTREE,
  UNIQUE INDEX `item_id`(`item_id`) USING BTREE,
  INDEX `item_price`(`item_price`) USING BTREE,
  INDEX `item_title`(`item_title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_item
-- ----------------------------
INSERT INTO `tb_item` VALUES ('1000000255', '惠普（HP）战66 二代 13.3英寸轻薄笔记本电脑（i5-8265U 8G 256G PCIe SSD Win10 一年上门）银色', '笔记本电脑', 4299.00, 9997, 1, 20005, '2019-05-01 12:52:36', '2019-05-07 13:53:28');
INSERT INTO `tb_item` VALUES ('1000000256', '【新品上市】APPLE苹果2019新款iPad mini5/mini4平板电脑7.9英寸 金色 【新品】mini5-64G-WLAN版', '笔记本电脑', 2748.00, 10000, 1, 20001, '2019-05-01 12:53:19', '2019-05-07 13:46:07');
INSERT INTO `tb_item` VALUES ('1000000257', '索尼（SONY）HDR-AS50 酷拍运动相机/摄像机（电子防抖 60米水下防水壳 3倍变焦）', '运动相机', 1499.00, 9999, 1, 20001, '2019-05-01 12:56:32', '2019-05-27 15:59:59');
INSERT INTO `tb_item` VALUES ('1000000258', 'GoPro HERO7 Black黑色 运动相机摄像机vlog 4K户外水下潜水视频直播 摄像机 HyperSmooth坚固耐用+防水', '运动相机', 3298.00, 10000, 1, 20001, '2019-05-01 12:58:17', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000259', 'Insta360 Pro 2专业级8K 3D全景相机运动防抖（含图传系统）5G VR直播推荐解决方案', '运动相机', 34999.00, 10000, 1, 20001, '2019-05-01 12:59:13', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000260', 'GoPro HERO7 Black 限定红色礼盒（含内存卡，红色硅胶套）运动相机摄像机vlog', '运动相机', 3899.00, 10000, 1, 20001, '2019-05-01 13:02:12', '2019-05-07 10:52:25');
INSERT INTO `tb_item` VALUES ('1000000261', 'Apple Macbook Pro 15.4【带触控栏】Core i7 16G 512G RP560X深空灰 苹果笔记本电脑轻薄本工作站MR942CH/A', '笔记本电脑', 19999.00, 9998, 1, 20001, '2019-05-01 13:04:20', '2019-05-27 15:27:44');
INSERT INTO `tb_item` VALUES ('1000000262', 'Apple AirPods 配充电盒 苹果蓝牙耳机', '耳机耳麦', 1469.00, 10000, 1, 20001, '2019-05-01 13:06:05', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000263', '索尼（SONY）WH-1000XM3 高解析度无线蓝牙降噪耳机（触控面板 智能降噪 长久续航）黑色', '运动相机', 2955.00, 10000, 1, 20001, '2019-05-01 14:41:51', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000264', 'Bose QuietControl 30 无线耳机 QC30耳塞式蓝牙降噪耳麦', '耳机耳麦', 2498.00, 10000, 1, 20001, '2019-05-01 13:10:11', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000266', '海南红心木瓜 2个装 单果约450g-500g 新鲜水果', '水果生鲜', 25.00, 9998, 1, 20001, '2019-05-01 13:16:50', '2019-05-27 15:36:14');
INSERT INTO `tb_item` VALUES ('1000000267', '【现采现发】优选新鲜水蜜桃桃子 非阳山水蜜桃肥桃黄桃油桃毛桃 孕妇时令应季水果 5斤精品果', '水果生鲜', 79.00, 9999, 1, 20001, '2019-05-01 13:17:35', '2019-05-27 15:14:01');
INSERT INTO `tb_item` VALUES ('1000000268', '绿鲜知 荷兰黄瓜 约600g 新鲜蔬菜', '水果生鲜', 12.00, 9999, 1, 20001, '2019-05-01 13:19:20', '2019-05-07 13:23:13');
INSERT INTO `tb_item` VALUES ('1000000269', 'SK-II唯白晶焕润透修护面膜6p（SK2日本面膜女 护肤品 补水保湿 美白祛斑 高渗透 化妆品）', '美妆馆', 780.00, 10000, 1, 20001, '2019-05-01 13:21:52', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000270', 'SK-II日间护肤精华喷雾50ml（神仙水补水保湿护肤品 面部护肤 精华液 补妆定妆）', '美妆馆', 490.00, 9999, 1, 20001, '2019-05-01 13:27:43', '2019-05-27 15:39:49');
INSERT INTO `tb_item` VALUES ('1000000271', '迪奥（Dior）烈艳蓝金唇膏口红3.5g 080(滋润保湿 妆感舒悦 微笑红色', '美妆馆', 315.00, 10000, 1, 20001, '2019-05-01 13:29:24', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000272', '迪奥（Dior）魅惑润唇蜜001# 3.5g(又名：克里斯汀迪奥魅惑润唇膏001)变色 持久保湿', '美妆馆', 295.00, 10000, 1, 20001, '2019-05-01 13:30:29', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000273', '魅可（MAC)经典唇膏 子弹头口红3g Chili 秀智色/小辣椒色', '美妆馆', 195.00, 9999, 1, 20001, '2019-05-01 13:31:50', '2019-05-27 16:08:54');
INSERT INTO `tb_item` VALUES ('1000000274', '茅台 赖茅 传承蓝 53度 500ml*6瓶 整箱装 酱香型白酒（新老包装随机发货）', '白酒', 2055.00, 10000, 1, 20001, '2019-05-01 13:33:52', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000275', '茅台 王子酒 53度 白酒 500ml*6瓶 整箱装 口感酱香型（新老包装随机发货）', '白酒', 949.00, 10000, 1, 20001, '2019-05-01 13:35:10', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000276', '贵州茅台酒 43度飞天茅台 酱香型白酒 500ml单瓶装', '白酒', 929.00, 9999, 1, 20001, '2019-05-01 13:36:02', '2019-05-27 15:29:57');
INSERT INTO `tb_item` VALUES ('1000000277', '贵州茅台 飞天 43度 酱香型白酒 500ml*6瓶整箱装', '白酒', 5376.00, 10000, 1, 20001, '2019-05-01 13:37:00', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000278', '戴尔DELL游匣G315.6英寸英特尔酷睿i7游戏笔记本电脑(i7-8750H 8G 128G 1T GTX1060MQ 6G独显 背光键盘 IPS)', '笔记本电脑', 6799.00, 10000, 1, 20001, '2019-05-01 14:27:11', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000279', '微软（Microsoft）Surface Pro 6 二合一平板电脑笔记本 12.3英寸（第八代Core i5 8G 128G SSD）亮铂金', '笔记本电脑', 6988.00, 10000, 1, 20001, '2019-05-01 14:35:06', '2019-05-06 21:21:22');
INSERT INTO `tb_item` VALUES ('1000000280', '美丽蟹后 小龙虾熟食 鲜活加热即食 海鲜水产 麻辣小龙虾35-50只中号1.8kg 4-6钱', '水果生鲜', 120.00, 9999, 1, 20001, '2019-05-01 14:38:43', '2019-05-27 15:59:59');
INSERT INTO `tb_item` VALUES ('2', '火龙果牌IPAD', '水果生鲜', 69.69, 2, 1, 20001, '2019-05-06 22:50:04', '2019-05-27 16:29:50');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `payment` decimal(9, 2) UNSIGNED NULL DEFAULT 0.00,
  `payment_type` tinyint(2) UNSIGNED NULL DEFAULT 1 COMMENT '支付类型1、在线支付，2、货到付款',
  `post_fee` decimal(9, 2) UNSIGNED NULL DEFAULT 8.00,
  `order_state` tinyint(2) NULL DEFAULT 1 COMMENT '订单状态1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易失败',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '订单更新时间 可以触发器实现物流更新的时候',
  `payment_time` datetime(0) NULL DEFAULT NULL,
  `consign_time` datetime(0) NULL DEFAULT NULL,
  `receive_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `close_time` datetime(0) NULL DEFAULT NULL,
  `shipping_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '菜鸟联盟',
  `shipping_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE,
  UNIQUE INDEX `order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('1558942196001', 1002, 929.00, 1, 8.00, 2, '2019-05-27 15:29:56', NULL, NULL, NULL, NULL, NULL, NULL, '菜鸟联盟', NULL, '2019-05-27 15:29:56', '2019-05-27 15:33:58');
INSERT INTO `tb_order` VALUES ('1558942788238', 1000, 490.00, 1, 8.00, 2, '2019-05-27 15:39:48', NULL, NULL, NULL, NULL, NULL, NULL, '菜鸟联盟', NULL, '2019-05-27 15:39:49', '2019-05-27 15:42:06');
INSERT INTO `tb_order` VALUES ('1558943997657', 1002, 1619.00, 1, 8.00, 2, '2019-05-27 15:59:58', NULL, '2019-05-27 16:01:18', NULL, NULL, NULL, NULL, '菜鸟联盟', NULL, '2019-05-27 15:59:58', '2019-05-27 16:01:19');

-- ----------------------------
-- Table structure for tb_order_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_item`;
CREATE TABLE `tb_order_item`  (
  `id` int(9) UNSIGNED NOT NULL AUTO_INCREMENT,
  `item_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_num` int(10) NULL DEFAULT NULL,
  `item_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_price` decimal(9, 2) NULL DEFAULT NULL,
  `total_fee` decimal(9, 2) NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_order_item
-- ----------------------------
INSERT INTO `tb_order_item` VALUES (82, '1000000276', '1558942196001', 1, '贵州茅台酒 43度飞天茅台 酱香型白酒 500ml单瓶装 ', 929.00, 929.00, '2019-05-27 15:29:57', NULL);
INSERT INTO `tb_order_item` VALUES (84, '1000000270', '1558942788238', 1, 'SK-II日间护肤精华喷雾50ml（神仙水补水保湿护肤品 面部护肤 精华液 补妆定妆） ', 490.00, 490.00, '2019-05-27 15:39:49', NULL);
INSERT INTO `tb_order_item` VALUES (85, '1000000280', '1558943997657', 1, '美丽蟹后 小龙虾熟食 鲜活加热即食 海鲜水产 麻辣小龙虾35-50只中号1.8kg 4-6钱 ', 120.00, 120.00, '2019-05-27 15:59:59', NULL);
INSERT INTO `tb_order_item` VALUES (86, '1000000257', '1558943997657', 1, '索尼（SONY）HDR-AS50 酷拍运动相机/摄像机（电子防抖 60米水下防水壳 3倍变焦） ', 1499.00, 1499.00, '2019-05-27 15:59:59', NULL);

-- ----------------------------
-- Table structure for tb_shipping
-- ----------------------------
DROP TABLE IF EXISTS `tb_shipping`;
CREATE TABLE `tb_shipping`  (
  `id` int(9) UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver_tel` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver_state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver_city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver_district` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver_zip` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `current_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未更新',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 74 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shipping
-- ----------------------------
INSERT INTO `tb_shipping` VALUES (69, '1558942196001', '1', '1', '1', '1', '1', '1', '1', '2019-05-27 15:29:56', '2019-05-27 15:30:01', '未更新');
INSERT INTO `tb_shipping` VALUES (71, '1558942788238', '1', '1', '1', '1', '1', '1', '1', '2019-05-27 15:39:49', '2019-05-27 15:39:53', '未更新');
INSERT INTO `tb_shipping` VALUES (72, '1558943997657', '1', '1', '1', '1', '1', '1', '1', '2019-05-27 15:59:58', '2019-05-27 16:00:10', '未更新');

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop`  (
  `shop_id` int(9) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `shop_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`shop_id`) USING BTREE,
  UNIQUE INDEX `shop_id`(`shop_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20006 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shop
-- ----------------------------
INSERT INTO `tb_shop` VALUES (20001, 1000, '官方店铺', '2019-04-25 05:02:30', '2019-05-06 20:05:37');
INSERT INTO `tb_shop` VALUES (20005, 1002, '嗷嗷嗷', '2019-05-06 21:39:07', NULL);

-- ----------------------------
-- Table structure for tb_shop_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_info`;
CREATE TABLE `tb_shop_info`  (
  `id` int(9) NOT NULL,
  `shop_id` int(9) NULL DEFAULT NULL,
  `shop_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_logo_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shop_info
-- ----------------------------
INSERT INTO `tb_shop_info` VALUES (1, 20001, '测试店铺描述', NULL, '2019-04-25 05:01:29', NULL);
INSERT INTO `tb_shop_info` VALUES (2, 20002, '测试店铺描述2', NULL, '2019-04-25 05:01:49', '2019-04-25 05:02:11');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'res/avatar/default.png',
  `role_type` tinyint(2) NULL DEFAULT 0 COMMENT '0：普通用户;1：商家;2:超级管理员',
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE,
  UNIQUE INDEX `tel`(`tel`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7897898 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1000, 'admin', '21232F297A57A5A743894A0E4A801FC3', '15871653387', '1000@qq.com', 'res/avatar/default.png', 2, '2019-04-25 04:59:56', '2019-05-07 10:59:27');
INSERT INTO `tb_user` VALUES (1002, 'cwg', '0BC1704860B446235080A1944F72534C', '17762952036', '1000@qq.com', 'img\\f67c87e6user2.png', 2, '2019-04-29 10:34:10', '2019-05-27 15:01:06');
INSERT INTO `tb_user` VALUES (1003, 'shop3213', 'B8020E8E15C5362A7AC49800E3E86E99', '15874124452', '1531864@cnm.cc', 'res/avatar/default.png', 0, '2019-05-05 16:34:57', '2019-05-06 16:43:28');
INSERT INTO `tb_user` VALUES (1004, 'buyer', '5', '110', '1', 'res/avatar/default.png', 1, '2019-05-05 16:35:04', '2019-05-20 15:32:38');
INSERT INTO `tb_user` VALUES (1005, 'test', '1', '1', '1', 'res/avatar/default.png', 1, '2019-05-06 14:22:31', NULL);
INSERT INTO `tb_user` VALUES (1006, 'shoper', '1', '13', '2', 'res/avatar/default.png', 1, '2019-05-06 14:22:33', '2019-05-06 14:23:03');
INSERT INTO `tb_user` VALUES (1007, 'shoper', '1', '4', '3', 'res/avatar/default.png', 1, '2019-05-06 14:22:37', '2019-05-06 14:23:01');
INSERT INTO `tb_user` VALUES (7679, 'buyer', '1', '787787878989', '1', 'res/avatar/default.png', 0, '2019-05-05 16:35:04', '2019-05-05 16:36:19');
INSERT INTO `tb_user` VALUES (12313, 'buyer', '1', '112000', '1', 'res/avatar/default.png', 1, '2019-05-05 16:35:04', '2019-05-06 14:15:41');
INSERT INTO `tb_user` VALUES (27779, 'buyer', '1', '78780', '1', 'res/avatar/default.png', 0, '2019-05-05 16:35:04', '2019-05-05 16:36:19');
INSERT INTO `tb_user` VALUES (78979, 'buyer', '1', '787787797978', '1', 'res/avatar/default.png', 1, '2019-05-05 16:35:04', '2019-05-06 14:24:48');
INSERT INTO `tb_user` VALUES (97827, 'buyer', '1', '5600', '1', 'res/avatar/default.png', 1, '2019-05-05 16:35:04', '2019-05-06 14:24:49');
INSERT INTO `tb_user` VALUES (445482, 'buyer', '1', '10400', '1', 'res/avatar/default.png', 1, '2019-05-05 16:35:04', '2019-05-06 14:24:51');
INSERT INTO `tb_user` VALUES (789797, 'buyer', '1', '780', '1', 'res/avatar/default.png', 0, '2019-05-05 16:35:04', '2019-05-05 16:36:19');
INSERT INTO `tb_user` VALUES (1210032, '15871653030', 'C2330E6D41905A3D829CB52276E74898', '15871653030', '15871653030@qq.cnm', 'res/avatar/default.png', 0, '2019-05-08 13:22:50', NULL);
INSERT INTO `tb_user` VALUES (1210097, 'ljxljx', '25F9E794323B453885F5181F1B624D0B', '15871651101', '123456789@qq.cn', 'res/avatar/default.png', 0, '2019-05-27 15:07:25', NULL);
INSERT INTO `tb_user` VALUES (7897897, '789797', '789797', NULL, NULL, 'res/avatar/default.png', 0, '2019-05-31 09:55:13', NULL);

-- ----------------------------
-- Triggers structure for table tb_item
-- ----------------------------
DROP TRIGGER IF EXISTS `delete_from_desc`;
delimiter ;;
CREATE TRIGGER `delete_from_desc` AFTER DELETE ON `tb_item` FOR EACH ROW BEGIN
DELETE FROM tb_desc where item_id=old.item_id;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table tb_order
-- ----------------------------
DROP TRIGGER IF EXISTS `新订单插入默认物流信息`;
delimiter ;;
CREATE TRIGGER `新订单插入默认物流信息` BEFORE INSERT ON `tb_order` FOR EACH ROW BEGIN
INSERT INTO `db_shop`.`tb_shipping`(`order_id`) VALUES (NEW.order_id);
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table tb_order
-- ----------------------------
DROP TRIGGER IF EXISTS `删除物流表记录`;
delimiter ;;
CREATE TRIGGER `删除物流表记录` AFTER DELETE ON `tb_order` FOR EACH ROW BEGIN
DELETE  FROM tb_shipping WHERE order_id=OLD.order_id;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table tb_order
-- ----------------------------
DROP TRIGGER IF EXISTS `删除订单商品表记录`;
delimiter ;;
CREATE TRIGGER `删除订单商品表记录` AFTER DELETE ON `tb_order` FOR EACH ROW BEGIN
DELETE FROM tb_order_item where order_id=OLD.order_id;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table tb_order_item
-- ----------------------------
DROP TRIGGER IF EXISTS `更新ORDER表对应订单号的payment-insert`;
delimiter ;;
CREATE TRIGGER `更新ORDER表对应订单号的payment-insert` AFTER INSERT ON `tb_order_item` FOR EACH ROW BEGIN
declare money DECIMAL(9,2);
SET money=(SELECT SUM(item_num*item_price) from tb_order_item where order_id=new.order_id);
UPDATE tb_order set payment = money where order_id=new.order_id;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table tb_order_item
-- ----------------------------
DROP TRIGGER IF EXISTS `创建订单则减库存`;
delimiter ;;
CREATE TRIGGER `创建订单则减库存` AFTER INSERT ON `tb_order_item` FOR EACH ROW BEGIN 
UPDATE tb_item SET item_stock=(item_stock-(SELECT item_num FROM tb_order_item WHERE order_id = new.order_id AND item_id = new.item_id)) WHERE item_id =new.item_id;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table tb_order_item
-- ----------------------------
DROP TRIGGER IF EXISTS `更新ORDER表对应订单号的payment-update`;
delimiter ;;
CREATE TRIGGER `更新ORDER表对应订单号的payment-update` AFTER UPDATE ON `tb_order_item` FOR EACH ROW BEGIN
declare money DECIMAL(9,2);
SET money=(SELECT SUM(item_num*item_price) from tb_order_item where order_id=new.order_id);
UPDATE tb_order set payment = money where order_id=new.order_id;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table tb_shipping
-- ----------------------------
DROP TRIGGER IF EXISTS `重新付款则删除以前的物流数据`;
delimiter ;;
CREATE TRIGGER `重新付款则删除以前的物流数据` BEFORE INSERT ON `tb_shipping` FOR EACH ROW BEGIN
IF (SELECT COUNT(DISTINCT order_id) from tb_shipping where order_id=new.order_id)>0 THEN
DELETE from tb_shipping where order_id=new.order_id;
END if;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
