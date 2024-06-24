drop database profiles;
create database profiles;
use profiles;

create table credentials(
UID int primary key auto_increment,
username varchar(50) not null, 
password varchar(50) not null
);

delimiter |
create trigger initiacredentialsexperiencelise after insert on credentials
for each row
begin 
insert into personaldetails(UID,email) values(new.UID,new.username);
insert into guardiandetails(UID) values(new.UID);
insert into education(UID,degree) values(new.UID,"12th");
insert into education(UID,degree) values(new.UID,"10th");
end|
delimiter ;


create table personalDetails(
UID int unique not null,
fName varchar(40),
lName varchar(40),
DOB date,
email varchar(40),
category varchar(50),
gender varchar(10),
mobile Decimal(10,0),
HNO varchar(10),
Street varchar(40),
city varchar(40),
pincode decimal(65),
country varchar(20),
constraint pd_to_cred foreign key (UID) references credentials(UID) on delete cascade
);


 create table guardianDetails(
 UID int not null unique,
 fatherName varchar(50),
 motherName varchar(50),
 fatherNumber decimal(10),
 motherNumber decimal(10),
 fatherOcc varchar(50),
 motherOcc varchar(50),
 constraint GD_to_cred foreign key (UID) references credentials(UID) on delete cascade
 );


 create table education(
UID int ,
institution varchar(100),
degree varchar(50),
board varchar(100),
percentage decimal(4,2),
passyear varchar(10),
primary key (degree,UID),
constraint edu_to_cred foreign key (UID) references credentials(UID) on delete cascade
);


create table pos_resp(
UID int,
pos_Name varchar(100),
held varchar(100),
descp varchar(2000),
constraint pos_to_cred foreign key (UID) references credentials(UID) on delete cascade
);


 create table experience(
 UID int ,
 company varchar(100),
 position varchar(30),
 period int,
 jType varchar(100),
 salary int default 0,
 details varchar(1000),
 primary key(UID,company,position),
constraint exp_to_cred foreign key (UID) references credentials(UID) on delete cascade
 );

 
 create table skills(
 UID int ,
 skill varchar(40),
 proficiency varchar(20) ,
 primary key (UID,skill),
constraint skill_to_cred foreign key (UID) references credentials(UID) on delete cascade
 );


create table projects(
UID int,
title varchar(60),
projectDomain varchar(100),
company varchar(60),
description varchar(500),
primary key (UID,title),
constraint project_to_cred foreign key (UID) references credentials(UID) on delete cascade
);


create table certification(
UID int,
Name varchar(60),
iss_Auth varchar(100),
certi_URL varchar(200),
certiDate Date,
certiNumber int,
description varchar(500),
primary key (UID,Name),
constraint cert_to_cred foreign key (UID) references credentials(UID) on delete cascade
);


create table extracurr(
UID int,
category varchar(100) ,
Description varchar(2000),
primary key (UID,category),
constraint extr_to_cred foreign key (UID) references credentials(UID) on delete cascade
);

create table companycred(
	CID int auto_increment,
    cName varchar(200),
    cField varchar(100),
    cType varchar(100),
    cEmail varchar(200),
    cpassword varchar(100),
    primary key (CID,cEmail,cName)
);

create table jobprofile(
CID int,
jbID int,
jobTitle varchar(500),
vacancy int,
salary int,
qualification varchar(500),
jobDescription varchar(2000),
primary key (CID, jbID),
constraint com_to_jobprofile foreign key(CID) references companycred(CID) on delete cascade 
);


create table applicants(
CID int,
jbID int,
UID int,
primary key(CID,jbID,UID),
constraint cred foreign key(UID) references credentials(UID) on delete cascade,
constraint jobpr foreign key(CID,jbID) references jobprofile(CID,jbID) on delete cascade
);


