    INSERT INTO thelast.User (createDate, email, firstName, lastName, password, phone, status, userName) VALUES (STR_TO_DATE( '2019-05-05', '%Y-%m-%d'),'guest@test.com','guestFirst','guestLast','password','000-000-0000','Active','guest');
    INSERT INTO thelast.User (createDate, email, firstName, lastName, password, phone, status, userName) VALUES (STR_TO_DATE( '2019-05-06', '%Y-%m-%d'),'test@test.com','testFirst','testLast','password','111-111-1111','Active','test');
    INSERT INTO thelast.User (createDate, email, firstName, lastName, password, phone, status, userName) VALUES (STR_TO_DATE( '2019-05-07', '%Y-%m-%d'),'john@miu.edu','John','JohnLast','password','123-456-7890','Active','john');

    INSERT INTO thelast.Car (carBrand, description, isAvailable, model, pickUpLocation, price, seats, status, year, owner_id) VALUES ('BMW', 'Brand new car', true,'X7','Fairfield, IOWA','200','5','ACTIVE', STR_TO_DATE( '2020-05-07', '%Y-%m-%d'), '1');
    INSERT INTO thelast.Car (carBrand, description, isAvailable, model, pickUpLocation, price, seats, status, year, owner_id) VALUES ('BENZ', 'Used car', true,'CLX','Chicago, IL','250','7','ACTIVE', STR_TO_DATE( '2018-05-07', '%Y-%m-%d'), '2');
    INSERT INTO thelast.Car (carBrand, description, isAvailable, model, pickUpLocation, price, seats, status, year, owner_id) VALUES ('TOYOTA', 'Good condition', true,'LX570','Fairfield, IOWA','100','5','ACTIVE', STR_TO_DATE( '2019-05-07', '%Y-%m-%d'), '1');
    INSERT INTO thelast.Car (carBrand, description, isAvailable, model, pickUpLocation, price, seats, status, year, owner_id) VALUES ('BMW', 'Old', true,'X5','New York','120','7','ACTIVE', STR_TO_DATE( '2017-05-07', '%Y-%m-%d'), '3');

    INSERT INTO thelast.Rental (approvalDate, createDate, declineDesc, declinedDate, expectedDate, pickUpdate, returnDate, status, car_id, user_id) VALUES('02-06-2020', STR_TO_DATE( '2019-05-07', '%Y-%m-%d'), 'Trip cancelled', '02-07-2020', '02-07-2020', '02-07-2020', '02-08-2020', '1', '1', '2');
    INSERT INTO thelast.Rental (approvalDate, createDate, declineDesc, declinedDate, expectedDate, pickUpdate, returnDate, status, car_id, user_id) VALUES('02-05-2020', STR_TO_DATE( '2019-05-07', '%Y-%m-%d'), 'Trip cancelled', '02-06-2020', '02-06-2020', '02-06-2020', '02-10-2020', '1', '1', '2');
    INSERT INTO thelast.Rental (approvalDate, createDate, declineDesc, declinedDate, expectedDate, pickUpdate, returnDate, status, car_id, user_id) VALUES('02-04-2020', STR_TO_DATE( '2019-05-07', '%Y-%m-%d'), 'Trip cancelled', '02-05-2020', '02-05-2020', '02-05-2020', '02-06-2020', '1', '1', '2');

    INSERT INTO thelast.User_roles (USER_ID, ROLES) VALUES(1, 0);
    INSERT INTO thelast.User_roles (USER_ID, ROLES) VALUES(2, 1);
    INSERT INTO thelast.User_roles (USER_ID, ROLES) VALUES(3, 2);

    INSERT INTO thelast.Tag (tagName) VALUES ('test');
    INSERT INTO thelast.Tag (tagName) VALUES ('test1');
