--insert 
insert into address values(address_no_seq.nextval,'김경호','123-45657','서울시여러분');


--pk update
update address set name='김변경', phone= '888-8888', address='부산시여러분' where no=1;

--pk delete
delete from address where no=1;

--select (pk select)
select no,name,phone,address from address where no=3;

--select (all select)
select no, name, phone, address from address;

rollback;