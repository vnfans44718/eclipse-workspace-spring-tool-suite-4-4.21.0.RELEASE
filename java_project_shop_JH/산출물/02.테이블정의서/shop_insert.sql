/*******************member insert****************/
INSERT INTO userinfo (userid, password, name, email) VALUES ('guard1', '1111', '김경호1', 'guard1@gmail.com');
INSERT INTO userinfo (userid, password, name, email) VALUES ('guard2', '2222', '김경호2', 'guard2@gmail.com');
INSERT INTO userinfo (userid, password, name, email) VALUES ('guard3', '3333', '김경호3', 'guard3@gmail.com');
INSERT INTO userinfo (userid, password, name, email) VALUES ('guard4', '4444', '김경호4', 'guard4@gmail.com');
/*******************product insert****************/
insert into product values(1, '비글', 550000, 'bigle.png','기타 상세 정보 등...', 0);
insert into product values(2, '달마시안', 500000, 'dalma.jpg','기타 상세 정보 등...', 0);
insert into product values(3, '퍼그', 400000, 'pug.jpg','기타 상세 정보 등...', 0);
insert into product values(4, '페키니즈', 450000, 'pekiniz.png','기타 상세 정보 등...', 0);
insert into product values(5, '포메라니안', 800000, 'pomeranian.jpg','기타 상세 정보 등...', 0);
insert into product values(6, '샤페이', 700000, 'shaipei.jpg','기타 상세 정보 등...', 0);
insert into product values(7, '닥스훈트', 800000, 'dachshund.jpg','기타 상세 정보 등...', 0);
insert into product values(8, '사모예드', 800000, 'samoyed.jpg','기타 상세 정보 등...', 0);
/*******************cart insert****************/
--guard1님이 1번2개,3번 1개,7번 3개
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard1',1,2);
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard1',3,1);
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard1',7,3);
--guard2님이 1번2개,3번 1개
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard2',1,2);
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard2',3,1);

/************order insert********************/
--cart 안에있는 아이템들주문
/******guard1님 주문1*********/
--orders
insert into orders(o_no,o_desc,o_date,o_price,userid) values(orders_o_no_seq.nextval,'비글외2종',sysdate,1750000,'guard1');
--order_item
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_seq.nextval,2,orders_o_no_seq.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_seq.nextval,1,orders_o_no_seq.currval,3);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_seq.nextval,3,orders_o_no_seq.currval,7);

/******guard2님 주문1*********/
--orders
insert into orders(o_no,o_desc,o_date,o_price,userid) values(orders_o_no_seq.nextval,'비글외1종',sysdate,950000,'guard2');
--order_item
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_seq.nextval,2,orders_o_no_seq.currval,1);
insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_seq.nextval,1,orders_o_no_seq.currval,3);















