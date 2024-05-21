package com.player;

public class Song {
    // 속성
    private int id;
    private String artist;
    private String title;
    private String lyrics;

    // 생성자
    public Song(int id, String artist, String title, String lyrics) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.lyrics = lyrics;
    }

    // setter
    public void setId(int id) {
        this.id = id;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    // getter
    public int getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getLyrics() {
        return lyrics;
    }
}