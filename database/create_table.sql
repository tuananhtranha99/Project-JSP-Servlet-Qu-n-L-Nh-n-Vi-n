CREATE SCHEMA `quan_ly_nhan_vien` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
use quan_ly_nhan_vien;

create table account
(
	id bigint not null primary key auto_increment,
    username varchar(150) not null,
    password varchar(150) not null,
    email varchar(255) ,
    deleted bit 
);

alter table account 
alter deleted set default 0;


create table employee
(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    birthday date null,
    gender bit null,
    image varchar(255) not null ,
    contact varchar(20) null,
    email varchar(255) not null default '',
    address varchar(255) not null default '',
    deleted bit
);

alter table employee add status varchar(100);
alter table employee add identity varchar(30);


delimiter #
create trigger nonEmptyImage
before insert
on employee
for each row
BEGIN
IF NEW.image = '' THEN
	IF NEW.gender = b'0' THEN
   SET NEW.image = 'default_man.jpg';
   END IF;
   
   IF NEW.gender = b'1' THEN
   SET NEW.image = 'default_woman.png';
   END IF;
END IF;

end#

delimiter ;


delimiter #
create trigger nonEmptyImageUpdate
before update
on employee
for each row
BEGIN
IF NEW.image = '' THEN
	IF NEW.gender = b'0' THEN
   SET NEW.image = 'default_man.jpg';
   END IF;
   
   IF NEW.gender = b'1' THEN
   SET NEW.image = 'default_woman.png';
   END IF;
END IF;

end#

delimiter ;

alter table employee 
alter deleted set default 0;

create table department
(
	id bigint not null primary key auto_increment,
    name varchar(150) not null,
    description varchar(500) not null default '',
    deleted bit
);

alter table department 
alter deleted set default 0;

create table employee_department
(
	id_employee bigint not null,
    id_department bigint not null,
    start_date date,
    primary key(id_employee, id_department)
);

alter table employee_department add constraint foreign key(id_employee) references employee(id);
alter table employee_department add constraint foreign key(id_department) references department(id);






