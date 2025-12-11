-- TEST DATABASE CREATION

-- create database 
DROP DATABASE IF EXISTS bobsBurgers;
CREATE DATABASE bobsBurgers;

-- select database
USE bobsBurgers;

-- table creation 

CREATE TABLE seasons
(
	season_num	 	INT	 PRIMARY KEY	AUTO_INCREMENT,
    season_name		VARCHAR(50),
    episode_count	INT  NOT NULL,
    release_year	INT
);

CREATE TABLE episodes
(
    episode_id		INT	 PRIMARY KEY	AUTO_INCREMENT,
    season_num		INT,
     CONSTRAINT fk_season
		FOREIGN KEY (season_num)
        REFERENCES seasons (season_num),
    episode_num		INT,
    episode_name	VARCHAR(100),
    daily_burger	VARCHAR(100),
    episode_tag		VARCHAR(100),
    air_date	DATE
);
-- season_num, episode_num, episode_name, daily_burger, episode_tag, air_date

-- Season 1 Information
INSERT INTO seasons (season_name, episode_count, release_year)
VALUES	("Season 1",	13,	2011),
		("Season 2",	9,	2012),
        ("Season 3",	23,	2012),
        ("Season 4",	22,	2013),
        ("Season 5",	21,	2014),
        ("Season 6",	18,	2015),
		("Season 7",	22,	2016),
        ("Season 8",	21,	2017),
        ("Season 9",	22,	2018),
        ("Season 10",	22,	2019),
        ("Season 11",	22,	2020),
		("Season 12",	22,	2021),
        ("Season 13",	22,	2022),
        ("Season 14",	16,	2023),
        ("Season 15",	22,	2024),
        ("Season 16",	15,	2025);
        

INSERT INTO episodes (season_num, episode_num, episode_name, daily_burger, episode_tag, air_date)
VALUES
-- ================= -- Seaon 1 -- ================= -- 
	(1, 1, "Human Flesh",
		NULL,
        "Pilot",
        "2011-01-09"),

	(1, 2, "Crawl Space",
		"Grandpa Muenster Burger",
        "Musical", 
        "2011-01-16"),

	(1, 3, "Sacred Cow",
		"Pepper Don’t Preach Burger", 
        NULL,
        "2011-01-23"),

	(1, 4, "Sexy Dance Fighting",
		NULL,
        NULL,
        "2011-02-13"),
	
    (1, 5, "Hamburger Dinner Theater",
		"If Looks Could Kale Burger", 
        "Musical", 
        "2011-02-20"),
	
    (1, 6, "Sheesh! Cab, Bob?",
		"Children of the Corn Beef Burger", 
        NULL, 
        "2011-03-06"),

	(1, 7, "Bed & Breakfast", 
		NULL,
        NULL, 
        "2011-03-13"),
	
    (1, 8, "Art Crawl",
		NULL,
        NULL,
        "2011-03-20"),
	
    (1, 9, "Spaghetti Western and Meatballs",
		"The Sound and the Curry Burger",
        NULL, 
        "2011-03-27"),
	
    (1, 10, "Burger War", 
		NULL,
		NULL,
		"2011-04-10"),
	
    (1, 11, "Weekend at Mort's",
		NULL,
		NULL,
        "2011-05-08"),
	
    (1, 12, "Lobsterfest", 	
		"New Bacon-ings Burger",
		"Holiday", 
		"2011-05-15"),
	
    (1, 13, "Torah! Torah! Torah!", 
		"Poblano Picasso Burger", 
		"Musical", 
		"2011-05-22");


-- ================= -- Seaon 2 -- ================= -- 
INSERT INTO episodes (season_num, episode_num, episode_name, daily_burger, episode_tag, air_date)
VALUES	
    (2, 1, "The Belchies", 	
		"The Roquefort Files Burger", 
		"Parody", 
		"2012-03-11"),
	
    (2, 2, "Bob Day Afternoon", 
		"Shoot Out with Grilled Cheese",
		"Musical", 
		"2012-03-18"),
	
    (2, 3, "Synchronized Swimming", 
		"The Swimming in Circles Burger",
		"Musical",
		"2012-03-25"),
	
    (2, 4, "Burgerboss", 
		"Papaya Was a Rolling Stone Burger", 
        "Parody",
        "2012-04-01"),
	
    (2, 5, "Food Truckin'",
		"The Roamin’ Holiday Burger", 
        "Outdoor", 
        "2012-04-15"),
	
    (2, 6, "Dr. Yap", 
		"She's a Super Leek Burger", 
		"Guest-Star", 
		"2012-04-29"),
	
    (2, 7, "Moody Foodie", 	
		"Do the Brussel Burger",
		null,
		"2012-05-06"),
	
    (2, 8, "Bad Tina", 
		"The Babe Ruthless Burger", 
		"Fanfiction",
		"2012-05-13"),
	
    (2, 9, "Beefsquatch", 	
		"The Final Kraut Down Burger",
		"Parody", 
		"2012-05-20");
    
-- ================= -- Seaon 3 -- ================= -- 
INSERT INTO episodes (season_num, episode_num, episode_name, daily_burger, episode_tag, air_date)
VALUES
    (3, 1, "Ear-sy Rider", 
		NULL,
		NULL,
        "2012-09-30"),
	
    (3, 2, "Full Bars", 
		"The Cauliflower’s Cumin from Inside the House Burger", 
        "Holiday",
        "2012-10-07"),
	
    (3, 3, "Bob Fires the Kids", 
		"Foot Feta-ish Burger",
        NULL,
        "2012-10-14"),
	
    (3, 4, "Mutiny on the Windbreaker",
		"The Wipeout Burger", 
        NULL,
        "2012-11-04"),
	
    (3, 5, "An Indecent Thanksgiving Proposal",
		NULL,
        "Holiday", 
        "2012-11-18"),
	
    (3, 6, "The Deepening",
		NULL,
        "Parody", 
        "2012-11-25"),
	
    (3, 7, "Tina-rannosaurus Wrecks",
		NULL,
        NULL,
        "2012-12-02"),
	
    (3, 8, "The Unbearable Like-Likeness of Gene",
		NULL, 
        NULL, 
        "2013-01-06"),
	
    (3, 9, "Bob Rest Ye Merry Gentle-Mannequins",
		NULL,
        "Holiday", 
        "2012-12-09"),
	
    (3, 10, "Mother Daughter Laser Razor",
		"Let’s Give ’Em Something Shiitake About Burger",
        NULL,
        "2013-01-06"),
	
    (3, 11, "Nude Beach", 
		NULL, 
        NULL,
        "2013-01-13"),
	
    (3, 12, "Broadcast Wagstaff School News",
		NULL,
        NULL,
        "2013-01-27"),
	
    (3, 13, "My Fuzzy Valentine",
		"Cupid Shuffle Burger",
        "Holiday",
        "2013-02-10"),
	
    (3, 14, "Lindapendant Woman",
		NULL,
        "Musical",
        "2013-03-03"),
	
    (3, 15, "O.T. The Outside Toilet",
		"Toilet Are You Kidding Me Burger",
        "Parody", 
        "2013-03-03"),
	
    (3, 16, "Topsy", 
		NULL, 
        "Musical",
        "2013-03-10"),
	
    (3, 17, "Two for Tina", 
		NULL, 
        NULL,
        "2013-03-17"),
	
    (3, 18, "It Snakes a Village",
		NULL, 
        NULL, 
        "2013-03-24"),
	
    (3, 19, "Family Fracas", 
		NULL, 
        "Parody", 
        "2013-04-14"),
	
    (3, 20, "The Kids Run the Restaurant", 
		"Jackie O-Nassis Burger", 
        NULL,
        "2013-04-21"),
	
    (3, 21, "Boyz 4 Now", 	
		NULL,
        "Musical", 
        "2013-04-28"),
	
    (3, 22, "Carpe Museum", 
		NULL,
        NULL,
        "2013-05-05"),
	
    (3, 23, "The Unnatural",
		NULL,
        "Musical", 
		"2013-05-12");
        
-- ================= -- Seaon 4 -- ================= -- 
INSERT INTO episodes (season_num, episode_num, episode_name, daily_burger, episode_tag, air_date)
VALUES
	(4, 1, "A River Runs Through Bob",
		NULL, 
        "Outdoor",
        "2013-09-29"),
	
    (4, 2, "Fort Night", 
		"The Cauliflower's Cumin From Inside The House Burger", 
        "Holiday",
        "2013-10-06"),
	
    (4, 3, "Seaplane!",
		"The Sound & The Curry Burger",
        "Outdoor",
        "2013-11-03"),
	
    (4, 4, "My Big Fat Greek Bob",
		"It's Fun To Eat At The RyEmCA Burger",
        NULL, 
        "2013-11-10"),
	
    (4, 5, "Turkey in a Can",
		"Gourdon-Hamsey Burger",
        "Holiday", 
        "2013-11-24"),
	
    (4, 6, "Purple Rain-Union", 
		"Kales From The Crypt Burger", 
        "musical",
        "2013-12-01"),
	
    (4, 7, "Bob and Deliver", 
		"Pepper Don't Preach Burger",
        "Parody", 
        "2013-12-08"),
	
    (4, 8, "Christmas in the Car", 
		"Baby You Can't Drive My Car Burger",
        "Holiday",
        "2013-12-15"),
	
    (4, 9, "Slumber Party", 
		"Burger On A Sesame Seed Bun Burger", 
        NULL,
        "2014-01-05"),
	
    (4, 10, "Presto Tina-O",
		"Fry Hard With A Vengeance Burger",
        NULL, 
        "2014-01-12"),
	
    (4, 11, "Easy Com-mercial, Easy Go-mercial", 
		"Blondes Have More Fun-Gus Burger", 
        NULL, 
        "2014-01-26"),
	
    (4, 12, "The Frond Files",
		"We're Here, We're Gruyère, Get Used To It Burger",
        "parody",
        "2014-03-09"),
	
    (4, 13, "Mazel-Tina", 
		"The Cauliflower's Cumin From Inside The House Burger",
        NULL,
        "2014-03-16"),
	
    (4, 14, "Uncle Teddy",
		"Don't You Four Cheddar 'Bout Me Burger",
        NULL,
        "2014-03-23"),
	
    (4, 15, "The Kids Rob a Train",
		"Pepper Don't Preach Burger",
        NULL,
        "2014-03-30"),
	
    (4, 16, "I Get Psy-chic Out of You",
		"I'm Gonna Git You Suck-ion Burger",
        NULL,
        "2014-04-06"),
	
    (4, 17, "The Equestranauts", 
		"The Roquefort Files Burger",
        NULL, 
        "2014-04-13"),
	
    (4, 18, "Ambergris",
		NULL, 
        NULL, 
        "2014-04-20"),
	
    (4, 19, "The Kids Run Away", 
		NULL,
        NULL,
        "2014-04-27"),
	
    (4, 20, "Gene It On", 
		"Parma Parma Parma Chameleon Burger", 
        NULL, 
        "2014-05-04"),
	
    (4, 21, "Wharf Horse (Part I)",
		NULL, 
		"twopart",
		"2014-05-11"),

    (4, 22, "World Wharf II (Part II)", 
		NULL, 
		"twopart", 
		"2014-05-18");
    
/*
-- Select all episodes for season 1
SELECT *
FROM episodes e
	JOIN seasons s ON e.season_num = s.season_num
WHERE s.season_num = 2
ORDER BY e.episode_num;

Select * 
From episodes e JOIN seasons s ON e.season_num = s.season_num
WHERE s.season_name = "season 2";
*/
update episodes
set daily_burger = "Test"
where episode_num = 22;

SELECT *
FROM episodes
where daily_burger = "Test";