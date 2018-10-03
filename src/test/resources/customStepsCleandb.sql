delete from user_custom_steps;
alter table user_custom_steps auto_increment = 1;
INSERT INTO user_custom_steps (step_name, dance_name, lead_description, follower_description, level, users_id) VALUES ('Turn', 'Swing', 'some description', 'screenshot', 'basic', 2);
INSERT INTO user_custom_steps (step_name, dance_name, lead_description, follower_description, level, users_id, deleted) VALUES ('Box', 'Runba', 'some description', 'screenshot', 'advanced', 2, 1);

