#!/usr/bin/env bash

#connector j mesma versão da imagem.

docker pull mysql:8.0.19

docker run --name eventoapp -e MYSQL_ROOT_PASSWORD=root -p 3307:3306 -d mysql

docker exec -it eventoapp mysql -p

create database evento app;

exit;