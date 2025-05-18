CREATE TABLE monolith_reservation_app_v1.user_details (
	user_id varchar(255) NOT NULL,
	city varchar(255) NULL,
	email varchar(255) NULL,
	"name" varchar(255) NULL,
	"password" varchar(255) NULL,
	phone varchar(255) NULL,
	CONSTRAINT user_details_pkey PRIMARY KEY (user_id)
);

INSERT INTO monolith_reservation_app_v1.user_details  (user_id, city, email, "name", "password", phone) 
VALUES ('Greg', 'LA', 'greg@dmail.com', 'Greg K', 'Greg^InfyGo', '8765421906');


CREATE TABLE monolith_reservation_app_v1.flight_details (
	flight_id varchar(255) NOT NULL,
	airlines varchar(255) NULL,
	arrival_time varchar(255) NULL,
	departure_time varchar(255) NULL,
	destination varchar(255) NULL,
	fare float8 NOT NULL,
	flight_available_date date NULL,
	seat_count int4 NULL,
	"source" varchar(255) NULL,
	CONSTRAINT flight_details_pkey PRIMARY KEY (flight_id)
);
INSERT INTO "monolith_reservation_app_v1".flight_details 
VALUES 
('F101', 'WingMeIn', '19:00', '20:00', 'California', 40000, '2019-03-05', 22, 'Mumbai'),
('F102', 'MagAirLines', '20:00', '21:00', 'LA', 50000, '2019-03-06', 30, 'Delhi');


CREATE TABLE monolith_reservation_app_v1.ticket_details (
	pnr int4 NOT NULL,
	booking_date date NULL,
	departure_date date NULL,
	departure_time varchar(255) NULL,
	flight_id varchar(255) NULL,
	no_of_seats int4 NOT NULL,
	total_fare float8 NOT NULL,
	user_id varchar(255) NULL,
	CONSTRAINT ticket_details_pkey PRIMARY KEY (pnr)
);

INSERT INTO monolith_reservation_app_v1.ticket_details 
values
(1608294,'2019-03-05','2019-03-05','20:00','F101',1,40000,'Greg');



CREATE TABLE monolith_reservation_app_v1.passenger_details (
	passenger_id int4 NOT NULL,
	passenger_age varchar(255) NULL,
	passenger_gender varchar(255) NULL,
	passenger_name varchar(255) NULL,
	ticket_pnr int4 NULL,
	CONSTRAINT passenger_details_pkey PRIMARY KEY (passenger_id)
);


-- monolith_reservation_app_v1.passenger_details foreign keys

ALTER TABLE monolith_reservation_app_v1.passenger_details ADD CONSTRAINT fklcjup2fi5sgce4lvo0mwoou1e FOREIGN KEY (ticket_pnr) REFERENCES monolith_reservation_app_v1.ticket_details(pnr);

INSERT INTO monolith_reservation_app_v1.passenger_details VALUES(105,'30','Male','Bob',1608294);


CREATE TABLE monolith_reservation_app_v1.creditcard_details (
	card_number varchar(255) NOT NULL,
	apin varchar(255) NULL,
	card_holder_name varchar(255) NULL,
	cvv varchar(255) NULL,
	expiry_month varchar(255) NULL,
	expiry_year varchar(255) NULL,
	total_bill varchar(255) NULL,
	CONSTRAINT creditcard_details_pkey PRIMARY KEY (card_number)
);

INSERT INTO monolith_reservation_app_v1.creditcard_details VALUES ('1234567891234567','123456','Bob','235','Jan','2020',40000);
