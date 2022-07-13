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
