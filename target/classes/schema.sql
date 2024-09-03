CREATE TABLE IF NOT EXISTS Content (
    id SERIAL PRIMARY KEY ,
    title varchar(255) NOT NULL,
    description text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255)
    );

/*INSERT INTO Content (title, description, status, content_type, date_created, date_updated, url)
VALUES
    ('Spring Data Tutorial', 'A guide to using Spring Data', 'PUBLISHED', 'ARTICLE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'https://example.com/spring-data'),
    ('Java Basics', 'An introduction to Java programming', 'DRAFT', 'ARTICLE', CURRENT_TIMESTAMP, NULL, 'https://example.com/java-basics'),
    ('Spring Boot Example', 'A simple Spring Boot application', 'IN_REVIEW', 'CODE_SAMPLE', CURRENT_TIMESTAMP, NULL, 'https://example.com/spring-boot-example');*/