

create table account
(
	id bigint not null primary key auto_increment,
    username varchar(150) not null,
    password varchar(150) not null,
    email varchar(255) not null,
    deleted bit 
);

alter table account 
alter deleted set default 0;

create table identity_card
(
	numb bigint not null primary key auto_increment,
    accepted_place varchar(150) not null,
    accepted_date date not null
);

create table employee
(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    birthday date null,
    gender bit null,
    image varchar(255) null,
    contact bigint null,
    email varchar(255),
    deleted bit
);

alter table employee add status varchar(100);
alter table employee add identity bigint;
alter table employee add constraint foreign key(identity) references identity_card(numb);
alter table employee modify column contact varchar(20);


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
    description text null,
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

create table project
(
	id bigint not null primary key auto_increment,
    name varchar(150) not null,
    description text null,
    start_date date null,
    finish_date date null
);

create table employee_project 
(
	id_employee bigint not null,
    id_project bigint not null,
    join_date date,
    quit_date date,
    primary key(id_employee, id_project)
);

alter table employee_project add constraint foreign key(id_employee) references employee(id);
alter table employee_project add constraint foreign key(id_project) references project(id);





