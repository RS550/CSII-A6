package com.monsters.databasefx;

import java.sql.*;
import java.util.ArrayList;

public class SQLConnection {

    public static ArrayList<Episode> episodeAL = new ArrayList<>();

    public static ArrayList<String> seasonsAL = new ArrayList<>();

    public static ArrayList<Episode> episodeSeasonSearchAL = new ArrayList<>();

    public static ArrayList<Episode> tagSearchAL = new ArrayList<>();

    public static ArrayList<String> tagsAL = new ArrayList<>();

    public static String seasonNum = "";
    public static String episodeNum = "";
    public static String episodeName = "";
    public static String dailyBurger = "";
    public static String episodeTag = "";
    public static String airDate = "";

    public static void update(String query) {

        episodeSeasonSearchAL.clear();

        Connection connection = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection URL = location of DB, User = SQLname "root", pswd = SQLpassword "Classwork"
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bobsburgers", "root", "Classwork"
            );

            //SQL QUERY INFO
            // Create statement connected to the db.
            Statement statement = connection.createStatement();
            // Execute query, using statement connection
            //                      SELECT --Want this-- FROM --TableName--
            statement.executeQuery(query);

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void seasonSearch(String query) {

        episodeSeasonSearchAL.clear();

        Connection connection = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection URL = location of DB, User = SQLname "root", pswd = SQLpassword "Classwork"
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bobsburgers", "root", "Classwork"
            );

    //SQL QUERY INFO
             // Create statement connected to the db.
            Statement statement = connection.createStatement();
            // Execute query, using statement connection
            //                      SELECT --Want this-- FROM --TableName--
            ResultSet resultSet = statement.executeQuery(query);


            // Process results
            while (resultSet.next()) {
                // resultSet.getInt(COLUMN LABEL HERE)
                // season_num, episode_num, episode_name, daily_burger, episode_tag, air_date
                seasonNum = String.valueOf(resultSet.getInt("season_num"));
                episodeNum = String.valueOf(resultSet.getInt("episode_num"));
                episodeName = resultSet.getString("episode_name");
                dailyBurger = resultSet.getString("daily_burger");
                episodeTag = resultSet.getString("episode_tag");
                airDate = resultSet.getString("air_date");

                Episode episode = new Episode(seasonNum, episodeNum, episodeName, dailyBurger, episodeTag, airDate);
                episodeSeasonSearchAL.add(episode);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void tagSearch(String query) {

        tagSearchAL.clear();

        Connection connection = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection URL = location of DB, User = SQLname "root", pswd = SQLpassword "Classwork"
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bobsburgers", "root", "Classwork"
            );

            //SQL QUERY INFO
            // Create statement connected to the db.
            Statement statement = connection.createStatement();
            // Execute query, using statement connection
            //                      SELECT --Want this-- FROM --TableName--
            ResultSet resultSet = statement.executeQuery(query);


            // Process results
            while (resultSet.next()) {
                // resultSet.getInt(COLUMN LABEL HERE)
                // season_num, episode_num, episode_name, daily_burger, episode_tag, air_date
                seasonNum = String.valueOf(resultSet.getInt("season_num"));
                episodeNum = String.valueOf(resultSet.getInt("episode_num"));
                episodeName = resultSet.getString("episode_name");
                dailyBurger = resultSet.getString("daily_burger");
                episodeTag = resultSet.getString("episode_tag");
                airDate = resultSet.getString("air_date");

                Episode episode = new Episode(seasonNum, episodeNum, episodeName, dailyBurger, episodeTag, airDate);
                tagSearchAL.add(episode);
            }


            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void getEpisodes() {

        Connection connection = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection URL = location of DB, User = SQLname "root", pswd = SQLpassword "Classwork"
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bobsburgers", "root", "Classwork"
            );

            //SQL QUERY INFO
            // Create statement connected to the db.
            Statement statement = connection.createStatement();
            // Execute query, using statement connection
            //                      SELECT --Want this-- FROM --TableName--
            ResultSet resultSet = statement.executeQuery("SELECT * FROM episodes;");


            // Process results
            while (resultSet.next()) {
                // resultSet.getInt(COLUMN LABEL HERE)
                // season_num, episode_num, episode_name, daily_burger, episode_tag, air_date
                seasonNum = String.valueOf(resultSet.getInt("season_num"));
                episodeNum = String.valueOf(resultSet.getInt("episode_num"));
                episodeName = resultSet.getString("episode_name");
                dailyBurger = resultSet.getString("daily_burger");
                episodeTag = resultSet.getString("episode_tag");
                airDate = resultSet.getString("air_date");

                Episode episode = new Episode(seasonNum, episodeNum, episodeName, dailyBurger, episodeTag, airDate);
                episodeAL.add(episode);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e+"Episode Connection broke");
        }
    }

    public static void getSeasons() {

        String seasonName = "";

        Connection connection = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection URL = location of DB, User = SQLname "root", pswd = SQLpassword "Classwork"
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bobsburgers", "root", "Classwork"
            );

            //SQL QUERY INFO
            // Create statement connected to the db.
            Statement statement = connection.createStatement();
            // Execute query, using statement connection
            //                      SELECT --Want this-- FROM --TableName--
            ResultSet resultSet = statement.executeQuery("SELECT season_name FROM seasons;");


            // Process results
            while (resultSet.next()) {
                seasonName = resultSet.getString("season_name");
                seasonsAL.add(seasonName);
            }
            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e+"\nGET SEASONS BROKE");
        }
    }

    public static void getTags() {

        String tags = "";

        Connection connection = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection URL = location of DB, User = SQLname "root", pswd = SQLpassword "Classwork"
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bobsburgers", "root", "Classwork"
            );

            //SQL QUERY INFO
            // Create statement connected to the db.
            Statement statement = connection.createStatement();
            // Execute query, using statement connection
            //                      SELECT --Want this-- FROM --TableName--
            ResultSet resultSet = statement.executeQuery("SELECT episode_tag FROM episodes;");


            // Process results
            while (resultSet.next()) {
                tags = resultSet.getString("episode_tag");
                if(!tagsAL.contains(tags)){tagsAL.add(tags);}
            }
            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e+"\nGRAB TAGS BROKE");
        }
    }

}

