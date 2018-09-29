delete from user_custom_steps;
delete from users;
alter table users auto_increment = 1;
INSERT INTO users (last_name, first_name, email, password, role_id) VALUES ('Coyne','Joe','jcoyne', '114', 2);
INSERT INTO users (last_name, first_name, email, password, role_id) VALUES ('Thomson','Mike','thomson', '115', 2);


