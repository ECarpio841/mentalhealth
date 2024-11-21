CREATE VIEW mood_entries_view AS
SELECT
    m.id AS mood_entry_id,
    m.mood,
    u.id AS user_id,
    u.full_name AS full_name,
    u.email AS email,
    u.phone AS phone
FROM
    mood_entries m
        JOIN
    users u
    ON
        m.user_id = u.id;
