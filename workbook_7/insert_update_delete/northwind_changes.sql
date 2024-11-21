-- Add new supplier
INSERT INTO `northwind`.`suppliers`
(`SupplierID`,
`CompanyName`,
`ContactName`,
`ContactTitle`,
`Address`,
`City`,
`Region`,
`PostalCode`,
`Country`,
`Phone`,
`Fax`,
`HomePage`)
VALUES
(8675309,
'Raymonds Store',
'Raymond',
'Potato Lord',
'123 Fake Street',
'Somewhere',
'DunnoFam',
15044,
'DunnoFam',
'555-5555',
'555-5555',
'google.com');

-- Add new product
INSERT INTO `northwind`.`products`
(`ProductID`,
`ProductName`,
`SupplierID`,
`CategoryID`,
`QuantityPerUnit`,
`UnitPrice`,
`UnitsInStock`,
`UnitsOnOrder`,
`ReorderLevel`,
`Discontinued`)
VALUES
(8675309,
'Potato',
8675309,
7,
50,
3.50,
100,
0,
0,
0);

-- List all products and their suppliers
select p.ProductName, s.CompanyName as Supplier
from products as p
inner join suppliers as s
		on s.SupplierID = p.SupplierID;
        
-- Raise potato price by 15%
UPDATE `northwind`.`products`
SET `UnitPrice` = `UnitPrice` * 1.15
WHERE `ProductID` = 8675309;


-- List product and prices of all products from new supplier
select p.ProductName, p.UnitPrice
from products as p
where p.SupplierID = 8675309;

-- Delete new product
delete from products
where ProductID = 8675309;

-- Delete supplier
delete from suppliers
where SupplierID = 8675309;

-- Display products and suppliers
select * from products;

select * from suppliers;
