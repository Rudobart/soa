INSERT INTO area (ar_id, ar_name) VALUES (1, 'S1');
INSERT INTO area (ar_id, ar_name) VALUES (2, 'S2');
INSERT INTO area (ar_id, ar_name) VALUES (3, 'S3');
INSERT INTO area (ar_id, ar_name) VALUES (4, 'S4');

INSERT INTO street (st_id, st_name, st_area_id) VALUES (1, 'Reymonta', 1);
INSERT INTO street (st_id, st_name, st_area_id) VALUES (2, 'Balladyny', 2);
INSERT INTO street (st_id, st_name, st_area_id) VALUES (3, 'Sokołowskiego', 3);
INSERT INTO street (st_id, st_name, st_area_id) VALUES (4, 'Czarnowiejska', 4);
INSERT INTO street (st_id, st_name, st_area_id) VALUES (5, 'Armii Krajowej', 2);
INSERT INTO street (st_id, st_name, st_area_id) VALUES (6, 'Mickiewicza', 3);

INSERT INTO parking_meter (pm_id, pm_street_id) VALUES (1, 1);
INSERT INTO parking_meter (pm_id, pm_street_id) VALUES (2, 2);
INSERT INTO parking_meter (pm_id, pm_street_id) VALUES (3, 3);
INSERT INTO parking_meter (pm_id, pm_street_id) VALUES (4, 4);
INSERT INTO parking_meter (pm_id, pm_street_id) VALUES (5, 5);
INSERT INTO parking_meter (pm_id, pm_street_id) VALUES (6, 6);
INSERT INTO parking_meter (pm_id, pm_street_id) VALUES (7, 6);

INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (1, FALSE, 1);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (2, FALSE, 1);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (3, FALSE, 1);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (4, FALSE, 2);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (5, FALSE, 2);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (6, FALSE, 2);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (7, FALSE, 3);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (8, FALSE, 3);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (9, FALSE, 4);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (10, FALSE, 4);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (11, FALSE, 5);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (12, FALSE, 5);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (13, FALSE, 6);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (14, FALSE, 6);


INSERT INTO app_user (us_id, us_password, us_username, us_area_id, us_role) VALUES (1, 'f6dd73f0ac53913b57d4012ed74f3e73ae6198e46d666ea35911aac3a4699a0a', 'admin1', 1, 'ADMIN');
INSERT INTO app_user (us_id, us_password, us_username, us_area_id, us_role) VALUES (2, 'f6dd73f0ac53913b57d4012ed74f3e73ae6198e46d666ea35911aac3a4699a0a', 'user1', 2, 'EMPLOYEE');
INSERT INTO app_user (us_id, us_password, us_username, us_area_id, us_role) VALUES (3, 'f6dd73f0ac53913b57d4012ed74f3e73ae6198e46d666ea35911aac3a4699a0a', 'user2', 3, 'EMPLOYEE');
INSERT INTO app_user (us_id, us_password, us_username, us_area_id, us_role) VALUES (4, 'f6dd73f0ac53913b57d4012ed74f3e73ae6198e46d666ea35911aac3a4699a0a', 'user3', 4, 'EMPLOYEE');