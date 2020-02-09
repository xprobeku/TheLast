INSERT INTO USER (id, createDate, email, firstName, lastName, password, phone, status, userName) VALUES (1,'02-06-2020','guest@test.com','guestFirst','guestLast','password','000-000-0000','Active','guest');
INSERT INTO USER (id, createDate, email, firstName, lastName, password, phone, status, userName) VALUES (2,'02-01-2020','test@test.com','testFirst','testLast','password','111-111-1111','Active','test');
INSERT INTO USER (id, createDate, email, firstName, lastName, password, phone, status, userName) VALUES (3,'02-07-2020','john@miu.edu','John','JohnLast','password','123-456-7890','Active','john');

INSERT INTO CAR (carBrand, description, isAvailable, model, pickUpLocation, price, seats, status, year, owner_id) VALUES ('BMW', 'Brand new car', true,'X7','Fairfield, IOWA','200','5','ACTIVE', '2020', '1');
INSERT INTO CAR (carBrand, description, isAvailable, model, pickUpLocation, price, seats, status, year, owner_id) VALUES ('BENZ', 'Used car', true,'CLX','Chicago, IL','250','7','ACTIVE', '2018', '2');
INSERT INTO CAR (carBrand, description, isAvailable, model, pickUpLocation, price, seats, status, year, owner_id) VALUES ('TOYOTA', 'Good condition', true,'LX570','Fairfield, IOWA','100','5','ACTIVE', '2019', '1');
INSERT INTO CAR (carBrand, description, isAvailable, model, pickUpLocation, price, seats, status, year, owner_id) VALUES ('BMW', 'Old', true,'X5','New York','120','7','ACTIVE', '2017', '3');

INSERT INTO RENTAL (approvalDate, createDate, declineDesc, declinedDate, expectedDate, pickUpdate, returnDate, status, car_id, user_id) VALUES('02-06-2020', '02-07-2020', 'Trip cancelled', '02-07-2020', '02-07-2020', '02-07-2020', '02-08-2020', '1', '1', '2');
INSERT INTO RENTAL (approvalDate, createDate, declineDesc, declinedDate, expectedDate, pickUpdate, returnDate, status, car_id, user_id) VALUES('02-05-2020', '02-06-2020', 'Trip cancelled', '02-06-2020', '02-06-2020', '02-06-2020', '02-10-2020', '1', '1', '2');
INSERT INTO RENTAL (approvalDate, createDate, declineDesc, declinedDate, expectedDate, pickUpdate, returnDate, status, car_id, user_id) VALUES('02-04-2020', '02-05-2020', 'Trip cancelled', '02-05-2020', '02-05-2020', '02-05-2020', '02-06-2020', '1', '1', '2');

INSERT INTO USER_ROLES (USER_ID, ROLES) VALUES('1', '1');
INSERT INTO USER_ROLES (USER_ID, ROLES) VALUES('2', '2');
INSERT INTO USER_ROLES (USER_ID, ROLES) VALUES('3', '3');

INSERT INTO TAG (tagName) VALUES ('test');
INSERT INTO TAG (tagName) VALUES ('test1');