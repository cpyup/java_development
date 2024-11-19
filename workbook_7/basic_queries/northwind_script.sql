-- Northwind Items Located In products

-- Selecting By Id, Name, Price
 select ProductID, ProductName, UnitPrice
 from products;
 
 -- Selecting id, name, price ascending by price 
 select ProductID, ProductName, UnitPrice
 from products
 order by UnitPrice;
 
 -- Products less than 7.5
 select ProductName, UnitPrice
 from products
 where UnitPrice < 7.5;
 
 -- 100 Units on hand, descending by price 
 select ProductName, UnitsInStock, UnitPrice
 from products
 where UnitsInStock >= 100
 order by UnitPrice desc;
 
 -- 100 min in stock, descending by price
 select ProductName, UnitsInStock, UnitPrice
 from products
 where UnitsInStock >= 100
 order by UnitPrice desc, ProductName;
 
 -- Category table is categories
 
 -- List all categories
 select *
 from categories;
 
 -- seafood id is 8
 
 -- Listing all seafood
 select *
 from products
 where CategoryID = 8;
 
 -- First and last of employee names
 select FirstName, LastName
 from employees;
 
 -- Managers
 select FirstName, LastName, Title
 from employees
 where Title like "%manager%";
 
 -- All job titles
 select distinct Title
 from employees;
 
 -- Employees with salary between 2000 - 2500
 select FirstName, LastName, Salary
 from employees
 where Salary between 2000 and 2500
 order by Salary;
 
 -- all supplier info
 select *
 from suppliers;

-- Tokyo Traders supplies to Northwind (id 4)
select *
from products
where SupplierID = 4;