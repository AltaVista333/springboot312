CREATE TABLE roles
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    `role` VARCHAR(255) NULL,
    CONSTRAINT PK_ROLES PRIMARY KEY (id),
    UNIQUE (`role`)
);

CREATE TABLE users
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    age      INT         NOT NULL,
    login    VARCHAR(255) NULL,
    name     VARCHAR(15) NOT NULL,
    password VARCHAR(255) NULL,
    email VARCHAR(255) NOT NULL UNIQUE ,
    surname  VARCHAR(15) NOT NULL,
    CONSTRAINT PK_USERS PRIMARY KEY (id)
);

CREATE TABLE users_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    CONSTRAINT PK_USERS_ROLES PRIMARY KEY (user_id, role_id)
);

CREATE INDEX FKj6m8fwv7oqv74fcehir1a9ffy ON users_roles (role_id);

ALTER TABLE users_roles
    ADD CONSTRAINT FK2o0jvgh89lemvvo17cbqvdxaa FOREIGN KEY (user_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE users_roles
    ADD CONSTRAINT FKj6m8fwv7oqv74fcehir1a9ffy FOREIGN KEY (role_id) REFERENCES roles (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

