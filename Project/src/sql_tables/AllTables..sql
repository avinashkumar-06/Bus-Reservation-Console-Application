/* Creating and choosing database */

mysql> create database BUS_TICKET_RESERVATION_SYSTEM;
Query OK, 1 row affected (0.00 sec)

mysql> USE BUS_TICKET_RESERVATION_SYSTEM;
Database changed


/* Creating Admin table */

mysql> create table Admin(
    -> aid int PRIMARY KEY,
    -> name varchar(25) not null,
    -> email varchar(25) UNIQUE,
    -> password varchar(25));
Query OK, 0 rows affected (0.04 sec)

mysql> desc Admin;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| aid      | int         | NO   | PRI | NULL    |       |
| name     | varchar(25) | NO   |     | NULL    |       |
| email    | varchar(25) | YES  | UNI | NULL    |       |
| password | varchar(25) | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
4 rows in set (0.01 sec)


/* Adding data to Admin table */

mysql> insert into Admin values(111,"avinash","avinash@gmail.com","avinash");
Query OK, 1 row affected (0.00 sec)

mysql> insert into Admin values(222,"devesh","devesh@gmail.com","devesh");
Query OK, 1 row affected (0.00 sec)

mysql> insert into Admin values(333,"deepanshu","deepanshu@gmail.com","deepanshu");
Query OK, 1 row affected (0.00 sec)

mysql> select * from Admin;
+-----+-----------+---------------------+-----------+
| aid | name      | email               | password  |
+-----+-----------+---------------------+-----------+
| 111 | avinash   | avinash@gmail.com   | avinash   |
| 222 | devesh    | devesh@gmail.com    | devesh    |
| 333 | deepanshu | deepanshu@gmail.com | deepanshu |
+-----+-----------+---------------------+-----------+
3 rows in set (0.00 sec)


/*  Creating Customer table */


mysql> create table Customer(cid int AUTO_INCREMENT PRIMARY KEY,
    -> name varchar(25) NOT NULL,
    -> age int NOT NULL,
    -> gender varchar(8),
    -> email varchar(35) UNIQUE NOT NULL,
    -> password varchar(30) NOT NULL);
Query OK, 0 rows affected (0.05 sec)

mysql> desc Customer;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| cid      | int         | NO   | PRI | NULL    | auto_increment |
| name     | varchar(25) | NO   |     | NULL    |                |
| age      | int         | NO   |     | NULL    |                |
| gender   | varchar(8)  | YES  |     | NULL    |                |
| email    | varchar(35) | NO   | UNI | NULL    |                |
| password | varchar(30) | NO   |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
6 rows in set (0.00 sec)



/* Creating Bus Table */


mysql> create table Bus(
    -> bid int PRIMARY KEY NOT  NULL,
    -> bname varchar(25)  NOT NULL,
    -> source varchar(25) NOT NULL,
    -> destination varchar(25) NOT NULL,
    -> type varchar(15) NOT NULL,
    -> seats int NOT NULL,
    -> departure varchar(10) NOT NULL,
    -> arrival varchar(10) NOT NULL,
    -> fare int NOT NULL,
    -> contact varchar(12) NOT NULL);

Query OK, 0 rows affected (0.04 sec)
mysql> DESC Bus;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| bid         | int         | NO   | PRI | NULL    |       |
| bname       | varchar(25) | NO   |     | NULL    |       |
| source      | varchar(25) | NO   |     | NULL    |       |
| destination | varchar(25) | NO   |     | NULL    |       |
| type        | varchar(15) | NO   |     | NULL    |       |
| seats       | int         | NO   |     | NULL    |       |
| departure   | varchar(10) | NO   |     | NULL    |       |
| arrival     | varchar(10) | NO   |     | NULL    |       |
| fare        | int         | NO   |     | NULL    |       |
| contact     | varchar(12) | NO   |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
10 rows in set (0.00 sec)


/* All tickets table */

mysql> create table Customer_Tickets(
    -> tid int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -> cid int NOT NULL,
    -> bid int NOT NULL,
    -> bname varchar(25),
    -> source varchar(25),
    -> destination varchar(25),
    -> btype varchar(15),
    -> fare int,
    -> seatNum int,
    -> contact varchar(12));
Query OK, 0 rows affected (0.05 sec)

mysql> desc Customer_Tickets;
+-------------+-------------+------+-----+---------+----------------+
| Field       | Type        | Null | Key | Default | Extra          |
+-------------+-------------+------+-----+---------+----------------+
| tid         | int         | NO   | PRI | NULL    | auto_increment |
| cid         | int         | NO   |     | NULL    |                |
| bid         | int         | NO   |     | NULL    |                |
| bname       | varchar(25) | YES  |     | NULL    |                |
| source      | varchar(25) | YES  |     | NULL    |                |
| destination | varchar(25) | YES  |     | NULL    |                |
| btype       | varchar(15) | YES  |     | NULL    |                |
| fare        | int         | YES  |     | NULL    |                |
| seatNum     | int         | YES  |     | NULL    |                |
| contact     | varchar(12) | YES  |     | NULL    |                |
+-------------+-------------+------+-----+---------+----------------+
10 rows in set (0.01 sec)














