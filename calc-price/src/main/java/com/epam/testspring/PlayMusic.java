package com.epam.testspring;

public class PlayMusic {

    Music music;
    String namePlayer;
    int vol;

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }

    public  void musicPlay(){
        System.out.println("Play: " + music.playMusic());
    }
    public PlayMusic(){}

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
