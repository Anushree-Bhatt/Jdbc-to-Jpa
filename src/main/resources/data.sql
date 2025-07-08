insert into Course(id, name, created_at, updated_at) values
(1000, 'JPA in 50 steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1001, 'Spring in 50 steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1002, 'Spring Boot in 100 steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into Passport(id, number) values
(3000, 'E123765'),
(3001, 'NK25431'),
(3002, 'KA78632');

insert into Student(id, name, passport_id) values
(2000, 'Adam', 3000),
(2001, 'Sam', 3001),
(2002, 'Jane', 3002);

insert into Review(id, rating, description) values
(4000, '5', 'Great Course!'),
(4001, '4', 'Good course'),
(4002, '3', 'Good course');




