-- Product id, name, unit price and category of all products, order by cat, product name
select ProductID, ProductName, UnitPrice, CategoryName
from products
inner join categories
	on products.CategoryID = categories.CategoryID
order by CategoryName, ProductName;

-- Product id, name, price and supplier of all products over 75, order by product name
select ProductID, ProductName, UnitPrice, suppliers.CompanyName
from products
inner join suppliers
		on products.SupplierID = suppliers.SupplierID
where UnitPrice > 75
order by ProductName;

-- Product id, name, price, category, and supplier, order by product name
select ProductID, ProductName, UnitPrice, CategoryName, CompanyName
from products
inner join categories
		on products.CategoryID = categories.CategoryID
inner join suppliers
		on products.SupplierID = suppliers.SupplierID
order by products.ProductName;

-- Product names & categories of most expensive products
select ProductName, CategoryName
from products
inner join categories
		on products.CategoryID = categories.CategoryID
where UnitPrice = (select max(UnitPrice)
					from products);
                    
-- Order id, ship name, ship address, shipping company from every order to Germany
select OrderID, ShipName, ShipAddress, shippers.CompanyName
from orders
inner join shippers
		on orders.ShipVia = shippers.ShipperID
where ShipCountry = 'Germany';

-- Order id, date, ship name, address of all orders including Sasquatch Ale
select orders.OrderID, orders.OrderDate, orders.ShipName, orders.ShipAddress
from orders
inner join `order details`
		on orders.OrderID = `order details`.OrderID
inner join products
		on products.ProductID = `order details`.ProductID
where ProductName = 'Sasquatch Ale';