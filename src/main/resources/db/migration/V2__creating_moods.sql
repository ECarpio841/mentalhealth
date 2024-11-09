CREATE TABLE mood_entries (
     id SERIAL PRIMARY KEY,
     user_id INT NOT NULL,
     mood VARCHAR(255) NOT NULL,
     FOREIGN KEY (user_id) REFERENCES users(id)
);