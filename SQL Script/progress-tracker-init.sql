drop database if exists progress_tracker;

-- create progress_tracker database
create schema progress_tracker;
use progress_tracker;
-- drop table user;
-- select * from user;
-- select * from tv_show;
-- select * from user_tv_show;
-- drop table user_tv_show;

create table user(user_id int auto_increment not null primary key, username varchar(255), password varchar(255));
create table tv_show(
	tv_show_id int auto_increment not null primary key, 
	tv_show_name varchar(255),
	tv_show_leading_actor varchar(255),
	tv_show_director varchar(255),
	tv_show_number_of_seasons int,
	tv_show_number_of_episodes int,
	tv_show_genre varchar(255),
	tv_show_audience_score int,
	tv_show_rating varchar(10),
	tv_show_first_episode_name varchar(255),
	tv_show_status varchar(255)
);
create table user_tv_show(
	user_id int,
    show_id int,
    progress int,
    foreign key (user_id) references user(user_id),
    foreign key (show_id) references tv_show(tv_show_id)
);

-- init user
insert into user values (1, "administrator", "000");
insert into user values (2, "mlovse1", "123");
insert into user values (3, "jlaw52", "345");
insert into user values (4, "tojumikie", "567");
insert into user values (5, "gortiz2021", "789");

-- init tv_show
insert into tv_show values 
(1, "The Office", "Steve Carell", "Greg Daniels", 9, 201, "Comedy",
91, "TV-14", "An American Workingspace", "Ended");

insert into tv_show values
(2, "Stranger Things", "Winona Ryder", "Matt & Ross Duffer", 4, 34,
"Horror", 90, "TV-14", "Chapter One: The Vanishing of Will Byers", "Ongoing");

insert into tv_show values
(3, "Seinfeld", "Jerry Seinfeld", "Larry David", 9, 180, "Comedy",
92, "TV-PG", "The Seinfeld Chronicles", "Ended");

insert into tv_show values
(4, "Firefly", "Nathan Fillion", "Joss Whedon", 1, 14, "Sci-fi",
97, "TV-14", "Serenity", "Cancelled");

insert into tv_show values
(5, "The Simpsons", "Dan Castellaneta", "Matt Groening", 33, 728,
"Comedy", 75, "TV-14", "Simpsons Roasting on an Open Fire", "Ongoing");

insert into tv_show values
(6, "The Mandalorian", "Pedro Pascal", "John Favreau", 2, 16,
"Western", 91, "TV-14", "Chapter 1: The Mandalorian", "Ongoing");

insert into tv_show values
(7, "SpongeBob SquarePants", "Tom Kenney", "Stephen Hillenburg", 13, 276,
"Comedy", 73, "TV-Y7", "Help Wanted", "Ongoing");

insert into tv_show values
(8, "Castle", "Nathan Fillion", "Andrew W. Marlowe", 8, 173,
"Mystery", 87, "TV-14", "Flowers for Your Grave", "Cancelled");

insert into tv_show values
(9, "Kitchen Nightmares", "Gordon Ramsay", "Brad Kreisberg", 7, 92,
"Reality", 67, "TV-14", "Peter's", "Ended");

insert into tv_show values
(10, "Pokémon", "Rika Matsumoto", "Kunihiko Yuyama", 1, 1203, "Adventure",
75, "TV-Y7", "Pokémon, I Choose You!", "Ongoing");

insert into tv_show values
(11, "Avatar: The Last Airbender", "Zach Tyler Eisen",
"Michael Dante DiMartino", 3, 61, "Adventure", 93, "TV-Y7",
"The Boy in the Iceberg", "Ended");

-- init user_tv_show
-- Administrators by default have completed ALL tv shows
insert into user_tv_show values (1, 1, 2);
insert into user_tv_show values (1, 2, 2);
insert into user_tv_show values (1, 3, 2);
insert into user_tv_show values (1, 4, 2);
insert into user_tv_show values (1, 5, 2);
insert into user_tv_show values (1, 6, 2);
insert into user_tv_show values (1, 7, 2);
insert into user_tv_show values (1, 8, 2);
insert into user_tv_show values (1, 9, 2);
insert into user_tv_show values (1, 10, 2);
insert into user_tv_show values (1, 11, 2);

insert into user_tv_show values (2, 1, 0);
insert into user_tv_show values (2, 2, 0);
insert into user_tv_show values (2, 3, 0);
insert into user_tv_show values (2, 4, 0);
insert into user_tv_show values (2, 5, 0);
insert into user_tv_show values (2, 6, 0);
insert into user_tv_show values (2, 7, 0);
insert into user_tv_show values (2, 8, 0);
insert into user_tv_show values (2, 9, 0);
insert into user_tv_show values (2, 10, 0);
insert into user_tv_show values (2, 11, 0);

insert into user_tv_show values (3, 1, 0);
insert into user_tv_show values (3, 2, 0);
insert into user_tv_show values (3, 3, 0);
insert into user_tv_show values (3, 4, 0);
insert into user_tv_show values (3, 5, 0);
insert into user_tv_show values (3, 6, 0);
insert into user_tv_show values (3, 7, 0);
insert into user_tv_show values (3, 8, 0);
insert into user_tv_show values (3, 9, 0);
insert into user_tv_show values (3, 10, 0);
insert into user_tv_show values (3, 11, 0);

insert into user_tv_show values (4, 1, 0);
insert into user_tv_show values (4, 2, 0);
insert into user_tv_show values (4, 3, 0);
insert into user_tv_show values (4, 4, 0);
insert into user_tv_show values (4, 5, 0);
insert into user_tv_show values (4, 6, 0);
insert into user_tv_show values (4, 7, 0);
insert into user_tv_show values (4, 8, 0);
insert into user_tv_show values (4, 9, 0);
insert into user_tv_show values (4, 10, 0);
insert into user_tv_show values (4, 11, 0);

insert into user_tv_show values (5, 1, 0);
insert into user_tv_show values (5, 2, 0);
insert into user_tv_show values (5, 3, 0);
insert into user_tv_show values (5, 4, 0);
insert into user_tv_show values (5, 5, 0);
insert into user_tv_show values (5, 6, 0);
insert into user_tv_show values (5, 7, 0);
insert into user_tv_show values (5, 8, 0);
insert into user_tv_show values (5, 9, 0);
insert into user_tv_show values (5, 10, 0);
insert into user_tv_show values (5, 11, 0);