CREATE DATABASE IF NOT EXISTS Azuria DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups`
(
    id   SMALLINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    tag  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO `groups`(name, tag)
VALUES ('Joueur', '[Joueur]'),
       ('VIP', '[VIP]'),
       ('VIP+', '[VIP+]'),
       ('Ami', '[Ami]'),
       ('Builder', '[Builder]'),
       ('Développeur', '[Dev]'),
       ('Modérateur', '[Modo]'),
       ('Administrateur', '[Admin]')
;

CREATE TABLE IF NOT EXISTS players
(
    uuid             INT      NOT NULL,
    coins            INT      NOT NULL,
    last_connection  DATETIME NOT NULL,
    first_connection DATETIME NOT NULL,
    group_id         SMALLINT NOT NULL,
    PRIMARY KEY (uuid)
);

DROP TABLE IF EXISTS proxy_permisions;
CREATE TABLE proxy_permissions
(
    group_id              SMALLINT AUTO_INCREMENT,
    proxy_command_party   BOOLEAN  NOT NULL,
    proxy_command_friends BOOLEAN  NOT NULL,
    PRIMARY KEY (group_id)
);

INSERT INTO proxy_permissions(proxy_command_party, proxy_command_friends)
VALUES (1, 1),
       (1, 1),
       (1, 1),
       (1, 1),
       (1, 1),
       (1, 1),
       (1, 1),
       (1, 1)
;


