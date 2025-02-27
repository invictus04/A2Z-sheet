# Write your MySQL query statement below
Select m.name as Employee from Employee e INNER JOIN Employee m ON e.id = m.managerId where e.salary<m.salary;