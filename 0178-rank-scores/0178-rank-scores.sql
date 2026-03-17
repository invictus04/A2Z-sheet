# Write your MySQL query statement below
select s.score ,count(s2.SCORE) as `rank` from scores s,
(select distinct score from scores)  s2
where s.score<=s2.score 
group by s.id 
order by s.score desc;