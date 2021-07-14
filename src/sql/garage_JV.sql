drop database if exists ppe2_2; 
create database garage_JV ;
use garage_JV ; 

GRANT ALL PRIVILEGES ON ppe2_2.* TO husseine@% IDENTIFIED BY 'husseine';

create table client (
	idclient int(3) not null auto_increment, 
	nom varchar(50), 
	prenom varchar(50),
	adresse varchar(50),
	email varchar(50),
	tel varchar(50),
	primary key (idclient)
); 

create table technicien (
	idtech int(3) not null auto_increment, 
	nom varchar(50), 
	prenom varchar(50),
	qualification varchar(50),
	email varchar(50),
	mdp varchar(50),
	tel varchar(50),
	primary key (idtech)
); 
create table vehicule (
	idvehicule int(3) not null auto_increment, 
	matricule varchar(50), 
	marque varchar(50),
	energie enum ("gazol", "essence", "électrique", "hybride","autre"),
	nbkm int(3),
	idclient int(3) not null,

	primary key (idvehicule), 
	foreign key(idclient) references client(idclient)
); 
create table entretien (
	identretien int(3) not null auto_increment, 
	idvehicule int(3) not null,
	idtech int(3) not null,  
	description text,
	montant float(8.2),
	dateentretien date,
	primary key (identretien), 
	foreign key(idtech) references technicien(idtech),
	foreign key(idvehicule) references vehicule(idvehicule)
); 

insert into technicien values (null, "Lahcen", "Hicham", "Moteur mécanique","a@gmail.com", "123","01010101010"); 
	