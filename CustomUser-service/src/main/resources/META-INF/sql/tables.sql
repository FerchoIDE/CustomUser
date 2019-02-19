create table product_details (
	uuid_ VARCHAR(75) null,
	productId LONG not null primary key,
	companyId LONG,
	productName VARCHAR(75) null,
	productPrice LONG
);