create database training default character set utf8;

DROP TABLE IF EXISTS training.mst_pokemons; 

CREATE TABLE IF NOT EXISTS training.`mst_pokemons`( 
    `id` INT (11) NOT NULL
    , `national_pokedex` INT (11) DEFAULT NULL
    , `name` VARCHAR (64) DEFAULT NULL
    , `type1` VARCHAR (16) DEFAULT NULL
    , `type2` VARCHAR (16) DEFAULT NULL
    , created_user_id INT (11) DEFAULT NULL
    , updated_user_id INT (11) DEFAULT NULL
    , created_at datetime DEFAULT NULL
    , updated_at datetime DEFAULT NULL
    , deleted_at datetime DEFAULT NULL
    , PRIMARY KEY (`id`)
);

DROP TABLE users;
CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL UNIQUE,
  `email` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `roles` varchar(255) NOT NULL,
  `remember_token` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_user_id` int(11) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_user_id` int(11) DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);



