# people-manage

## Introduction
  This is a people management system. It implements the login/logout, CRUD of people, personal information modification, and log recording and viewing.
  Dao layer uses Mybatis and mysql database. Service layer is implemented by spring ioc and aop. UI is consisted of a servlet Dispatcher Contrller and jsp pages.
  Two filters implemented, encoding filter and login filter.

## Environment
  * Tomcat 8.5.41
  * Java JDK 10
  * Spring framework
  * Mybatis
  * mysql 8.0.19
  
## Structure
Spring容器管理Dao层，service层，controllers。Web容器包含所有jsp页面以及一个DispacherServlet。DispacherServlet分析URL，利用反射机制调用spring容器中的各个控制器。

## what it looks like

default password of users is 123456. There is an admin account with username:admin password:123456
  
![login](https://github.com/KaimingCui/people-manage/blob/master/1.png)  

![personal info](https://github.com/KaimingCui/people-manage/blob/master/2.png)  

![people manage](https://github.com/KaimingCui/people-manage/blob/master/3.png)  

![add people](https://github.com/KaimingCui/people-manage/blob/master/4.png) 

![log](https://github.com/KaimingCui/people-manage/blob/master/5.png)
