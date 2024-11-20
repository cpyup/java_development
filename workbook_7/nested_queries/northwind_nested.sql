-- Products with highest price
select ProductName, UnitPrice
from products
where UnitPrice = (select max(UnitPrice)
					from products);
                    
-- id, shipping name, address shipped via federal shipping
select OrderID, ShipName, ShipAddress
from orders
where ShipVia = (select ShipperID
				from shippers
                where CompanyName like "%federal%");
                
-- order ids of orders shipped via sasquatch
select OrderID
from `order details`
where ProductID = (select ProductID
					from products
                    where ProductName like "%sasquatch%");
                    
-- employee that sold order 10266
select FirstName, LastName
from employees
where EmployeeID = (select EmployeeID
					from orders
                    where OrderID = 10266);
                    
-- customer that bought order 10266
select CompanyName as Customer
from customers
where CustomerID = (select CustomerID 
					from orders 
					where OrderID = 10266);