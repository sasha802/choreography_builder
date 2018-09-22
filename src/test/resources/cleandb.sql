delete from users;
alter table users auto_increment = 1;
INSERT INTO users (last_name, first_name, email, password, role_id) VALUES ('Joe','Coyne','jcoyne', '114', 2);
INSERT INTO users (last_name, first_name, email, password, role_id) VALUES ('Mike','Thomson','thomson', '115', 2);