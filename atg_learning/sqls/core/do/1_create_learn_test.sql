CREATE TABLE LearnTest (
	id 			varchar2(254)	NOT NULL REFERENCES dcspp_ship_group(shipping_group_id),
	learn_test 		varchar2(254)	NULL
);