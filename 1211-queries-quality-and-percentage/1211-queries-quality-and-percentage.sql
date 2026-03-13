# Write your MySQL query statement below
-- select count(query_name) from queries where rating < 3 group by query_name;
-- select count(query_name) from queries group by query_name;
select query_name, round(avg(rating/position),2) as quality, round(sum(rating < 3) * 100.0/count(query_name),2) as poor_query_percentage from queries group by query_name;