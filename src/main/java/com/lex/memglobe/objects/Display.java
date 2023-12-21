package com.lex.memglobe.objects;

public class Display {
    String text;
    boolean textOn;
    String picture;
    boolean pictureOn;
    String audio;
    boolean audioOn;

    public Display() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.textOn = true;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
        this.pictureOn = true;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
        this.audioOn = true;
    }

    public void display(){
        if (textOn){
            System.out.println(text);
        }
        if (pictureOn){
            System.out.println(picture);
        }
        if (audioOn){
            System.out.println(audio);
        }
    }
}