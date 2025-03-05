# Write your MySQL query statement below
SELECT MAX(e1.salary) as SecondHighestSalary
FROM Employee e1
JOIN Employee e2
ON e1.salary < e2.salary;