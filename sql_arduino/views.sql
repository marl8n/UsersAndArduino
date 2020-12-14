SELECT v.visit_id, u.name, v.date_visited
FROM visits as v
JOIN users as u
	on u.user_id = v.user_id
WHERE v.date_visited BETWEEN ? AND ?;

SELECT u.dpi, u.name FROM users AS u;

SELECT u.name, COUNT(*) AS vistis_quantity
FROM visits as v
JOIN users as u WHERE u.user_id = v.user_id
GROUP BY v.user_id;

SELECT u.name, v.date_visited, COUNT(*) AS visits_quantity
FROM visits AS v
JOIN users AS u
ON u.user_id = v.user_id
GROUP BY v.user_id
HAVING v.date_visited BETWEEN ? AND ?
ORDER BY visits_quantity;

SELECT u.name, COUNT(*) AS visits_quantity
FROM visits AS v
LEFT JOIN users AS u
ON u.user_id = v.user_id
UNION
SELECT name FROM users
ON RIGHT JOIN users.user_id = visit.user_id
GROUP BY v.user_id
ORDER BY visits_quantity
LIMIT TO 1;

SELECT COUNT(*)
FROM visits
WHERE visit.active = 1;

SELECT dpi,  password FROM users
WHERE dpi = ?;

UPDATE `users` SET `password` = 'this' WHERE user_id = 1;

SELECT u.name, COUNT(*) AS visits_quantity
FROM visits AS v
	JOIN users as u ON v.user_id = u.user_id
UNION
	RIGHT JOIN u ON  v.user_id = u.user_id
GROUP BY v.user_id
ORDER BY visits_quantity DESC
LIMIT TO 1;



SELECT u.name, COUNT(*) AS visits_quantity
FROM visits AS v
	JOIN users as u ON v.user_id = u.user_id
UNION
	SELECT u.name COUNT(*) AS visits_quantity
    FROM visits AS v RIGHT JOIN users AS u ON v.user_id = u.user_id
GROUP BY v.user_id
ORDER BY visits_quantity DESC;


SELECT *
FROM visits AS v
RIGHT JOIN users AS u ON v.user_id = u.user_id

SELECT u.name, COUNT(*) AS times_visited FROM visits AS v
JOIN users AS u ON v.user_id = u.user_id
GROUP BY u.user_id
ORDER BY times_visited
LIMIT 1;

-- Algunos querys fueron escritos con la intencion de probar la base de datos