package com.player;

// 개별 노래 정보를 관리하는 클래스
public class Song {
    // 속성
    private int id;
    private String artist;
    private String title;

    // 생성자
    public Song(int id, String artist, String title) {
        this.id = id;
        this.artist = artist;
        this.title = title;
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
}