create database application;
use application;
CREATE TABLE UserLogin (
    userid INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(20) NOT NULL,
    PRIMARY KEY (userid)
);
alter table UserLogin auto_increment=10000;
insert into UserLogin(userid, email, password) values('100000','deepankar@gmail.com','deepankar');
describe UserLogin;
select * from UserLogin;

                        