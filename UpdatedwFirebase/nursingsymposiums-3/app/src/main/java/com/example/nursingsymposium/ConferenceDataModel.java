package com.example.nursingsymposium;

public class ConferenceDataModel {

    String image;
    String name;
    String location;
    String date;
    String eventName;
    String time;
    String speaker;
    String studentKey;
    String speakerkey;
    String eventDescription;

    public ConferenceDataModel() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getStudentKey() {
        return studentKey;
    }

    public void setStudentKey(String studentKey) {
        this.studentKey = studentKey;
    }

    public String getSpeakerkey() {
        return speakerkey;
    }

    public void setSpeakerkey(String speakerkey) {
        this.speakerkey = speakerkey;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public ConferenceDataModel(String image, String name, String location, String date, String eventName, String time, String speaker, String studentKey, String speakerkey, String eventDescription) {
        this.image = image;
        this.name = name;
        this.location = location;
        this.date = date;
        this.eventName = eventName;
        this.time = time;
        this.speaker = speaker;
        this.studentKey = studentKey;
        this.speakerkey = speakerkey;
        this.eventDescription = eventDescription;
    }
}
