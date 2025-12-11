package com.monsters.databasefx;

public class Episode {
    // season_num, episode_num, episode_name, daily_burger, episode_tag, air_date

    private String seasonNum;
    private String episodeNum;
    private String episodeName;
    private String dailyBurger;
    private String episodeTag;
    private String airDate;

    public Episode(String season, String episode, String name, String burger, String epTag, String airD) {
        this.seasonNum = season;
        this.episodeNum = episode;
        this.episodeName = name;
        this.dailyBurger = burger;
        this.episodeTag = epTag;
        this.airDate = airD;
    }

    public String getSeasonNum() {return seasonNum;}

    public String getEpisodeNum() {return episodeNum;}

    public String getEpisodeName() {return episodeName;}

    public String getDailyBurger() {return dailyBurger;}

    public String getTag() {return episodeTag;}

    public String getDate() {return airDate;}

    @Override
    public String toString() {
        return "Episode: " + episodeNum + " : " + episodeName +
                "\nAired: " + airDate +
                "\nBurger of the Day: " + dailyBurger +
                "\n-----------------------------------\n\n";
    }
}
