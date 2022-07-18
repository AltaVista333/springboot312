insert into roles (`id`,`role`) values (1,'ROLE_ADMIN');
insert into roles (`id`,`role`) values (2,'ROLE_USER');


insert into users (`id`, `name`, `surname`, `age`, `login`, `password`, `email`)
values (1, "Ivan", "Ivanov", 25,"ivan","ivan", "123@123.com"),
       (2, "Fedorov", "Fedor", 25,"fedor", "fedor","123@124.com"),
       (3, "Pavlov", "Evgraf", 25,"evgraf", "evgraf","123@125.com"),
       (4, "Semenov", "Sergey", 25, "serg", "serg","123@126.com");

insert into users_roles (user_id, role_id) VALUES (1,2), (2,2),(3,2),(4,2),
                                                  (1,1);