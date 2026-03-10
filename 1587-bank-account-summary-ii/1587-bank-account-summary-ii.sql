# Write your MySQL query statement below
select u.name, sum(t.amount) as BALANCE from Users u Inner join Transactions t on u.account = t.account group by t.account having sum(t.amount) > 10000; 
-- select account, sum(amount) as BALANCE from transactions group by account having sum(amount)>10000;
-- select u.name , t.trans_id from Users u Inner join Transactions t