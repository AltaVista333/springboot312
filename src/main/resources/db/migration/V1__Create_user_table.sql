CREATE TABLE `users`
(
    `id`      BIGINT      NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(15) NOT NULL,
    `surname` VARCHAR(15) NOT NULL,
    `age`     INT     NOT NULL,
    PRIMARY KEY (`id`)
);