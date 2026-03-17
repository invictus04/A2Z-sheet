# Write your MySQL query statement below
select e.name
from Employee as e 
inner join Employee as m on e.id=m.managerId 
group by m.managerId 
having count(m.managerId) >= 5;