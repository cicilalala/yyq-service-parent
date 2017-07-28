CREATE TABLE `product_info` (
  `product_id` VARCHAR(32) NOT NULL,
  `product_name` VARCHAR(64) NOT NULL,
  `product_price` DECIMAL(8, 2) NOT NULL,
  `product_stock` INT NOT NULL,
  `product_description` VARCHAR(64),
  `product_icon` VARCHAR(512),
  `product_status` INT NOT NULL,
  `category_type` INT NOT NULL,
  `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
);

CREATE TABLE `product_category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(64) NOT NULL,
  `category_type` INT NOT NULL,
  `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `uqe_category_type` (`category_type`)
);

CREATE TABLE `order_master` (
  `order_id` VARCHAR(32) NOT NULL,
  `buyer_name` VARCHAR(32) NOT NULL,
  `buyer_phone` VARCHAR(32) NOT NULL,
  `buyer_address` VARCHAR(128) NOT NULL,
  `buyer_openid` VARCHAR(64) NOT NULL,
  `order_amount` DECIMAL(8, 2) NOT NULL,
  `order_status` TINYINT(3) NOT NULL DEFAULT 0,
  `pay_status` TINYINT(3) NOT NULL DEFAULT 0,
  `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
);

CREATE TABLE `order_detail` (
  `detail_id` VARCHAR(32) NOT NULL ,
  `order_id` VARCHAR(32) NOT NULL ,
  `product_id` VARCHAR(32) NOT NULL,
  `product_name` VARCHAR(64) NOT NULL,
  `product_price` DECIMAL(8, 2) NOT NULL,
  `product_quantity` INT NOT NULL,
  `product_icon` VARCHAR(512),
  `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`detail_id`),
  KEY `idx_order_id` (`order_id`)
);