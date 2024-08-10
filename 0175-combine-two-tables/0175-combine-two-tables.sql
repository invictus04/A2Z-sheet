# Write your MySQL query statement below
Select Person.firstName, Person.lastName, Address.city, Address.state
FROM Person LEFT OUTER JOIN Address
ON Person.personId = Address.personId