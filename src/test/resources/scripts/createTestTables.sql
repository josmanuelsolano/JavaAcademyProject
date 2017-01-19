CREATE TABLE cart (
  cart_id int(11)   ,
  lines_amount decimal(10,2)  ,
  shipping_amount decimal(10,2)  ,
  cart_amount decimal(10,2)  ,
  ship_to_id int(11)  ,
  status_id int(11)  ,
  create_user varchar(20)  ,
  create_date datetime  ,
  update_user varchar(20)  ,
  update_date datetime  
);

CREATE TABLE cart_line (
  cart_line_id int(11)   ,
  cart_id int(11)  ,
  item_id int(11)  ,
  quantity int(11)  
);

CREATE TABLE category (
  category_id int(11)   ,
  description varchar(100)  
);

CREATE TABLE category_item (
  category_id int(11)  ,
  item_id int(11)  
);

CREATE TABLE city (
  city_id int(11)   ,
  description varchar(100)  ,
  state_id int(11)  
);

CREATE TABLE item (
  item_id int(11)   ,
  description varchar(100)  ,
  features varchar(250)  ,
  uom_id varchar(5)  ,
  unit_price decimal(10,2)  ,
  image_path varchar(250)  ,
  stock int(11)  ,
  active varchar(1)  
);

CREATE TABLE orders (
  order_id int(11)   ,
  cart_id int(11)  ,
  order_date datetime  ,
  schedule_date datetime  ,
  delivery_date datetime  ,
  cancellation_date datetime  ,
  lines_amount decimal(10,2)  ,
  shipping_amount decimal(10,2)  ,
  order_amount decimal(10,2)  ,
  payment_method_id varchar(5)  ,
  payment_reference varchar(100)  ,
  es varchar(250)  ,
  status_id int(11)  ,
  create_user varchar(20)  ,
  create_date datetime  ,
  update_user varchar(20)  ,
  update_date datetime  
);

CREATE TABLE payment_method (
  payment_method_id varchar(5)  ,
  description varchar(100)  
);

CREATE TABLE ship_to (
  ship_to_id int(11)   ,
  user varchar(20)  ,
  name varchar(100)  ,
  address varchar(250)  ,
  city_id int(11)  ,
  zip_code int(11)  ,
  phone varchar(20)  ,
  email varchar(100)  
);

CREATE TABLE shipping_zone (
  shipping_zone_id varchar(5)  ,
  description varchar(20)  ,
  delivery_time int(11)  ,
  shipping_cost decimal(10,2)  
);

CREATE TABLE state (
  state_id int(11)   ,
  description varchar(100)  ,
  shipping_zone_id varchar(5)  
);

CREATE TABLE status (
  status_id int(11)  ,
  description varchar(100)  ,
  status_type varchar(20)  
);

CREATE TABLE uom (
  uom_id varchar(5)  ,
  description varchar(20)  
);

CREATE TABLE user (
  username varchar(20)  ,
  password varchar(20)  ,
  name varchar(100)  ,
  user_role_id varchar(5)  ,
  active varchar(1)  
);

CREATE TABLE user_role (
  user_role_id varchar(5)  ,
  description varchar(20)  
);

