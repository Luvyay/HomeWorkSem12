CREATE TABLE IF NOT EXISTS bookTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nameBook varchar(255) NOT NULL,
    price INT NOT NULL
);

CREATE TABLE IF NOT EXISTS booksDescription (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description TEXT
);