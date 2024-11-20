-- Supplier Count
select count(*)
from suppliers;

-- Sum of all salaries
select sum(Salary)
from employees;

-- Cheapest item price
select min(UnitPrice)
from products;

-- Average price of products
select avg(UnitPrice)
from products;

-- Most expensive product
select max(UnitPrice)
from products;

-- Supplier ID + amount of items
select SupplierID, count(*)
from products
group by SupplierID;

-- CategoryID and avg of each item in category
select CategoryID, avg(UnitPrice)
from products
group by CategoryID;

-- SupplierID of each supplier with at least 5 items + number of items
select SupplierID, count(*) as ItemCount
from products
group by SupplierID
having ItemCount >= 5;

-- ProductID, name, and inventory values
select ProductID, ProductName, UnitPrice * UnitsInStock as InventoryValue
from products
order by InventoryValue, ProductName;