package com.lex.memglobe.objects;

import java.time.Period;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Memthm {
    ZonedDateTime lastLearnDate;
    ZonedDateTime nextLearnDate;
    int difficulty; //TODO write a note here that concisely explains what this is and the science it is based on
    float nextInterval; //how long until the next scheduled review date, adjusted based on difficulty and selfRating
    int state; //this is a theoretical value introduced in SM2 to represent which learning phase a card is in. It is preserved in Memthm to collect data on it for the purpose of determining if it is relevant.
    ArrayList<LogEntry> log = new ArrayList<>();

    public Memthm (){
        ZonedDateTime zdtNow = ZonedDateTime.now();
        this.lastLearnDate = zdtNow;
        this.nextLearnDate = zdtNow;
        this.nextInterval = 1;
    }

    private class LogEntry {
        ZonedDateTime reviewDate;
        int selfRating;
        Period scheduledInterval;
        Period trueInterval;
        int difficulty;
        int state;

        public LogEntry(int selfRating) {
            ZonedDateTime zdtNow = ZonedDateTime.now();
            this.reviewDate = zdtNow;
            this.selfRating = selfRating;
            this.scheduledInterval = Period.between(nextLearnDate.toLocalDate(), lastLearnDate.toLocalDate());
            this.trueInterval = Period.between(zdtNow.toLocalDate(), lastLearnDate.toLocalDate());
            this.difficulty = Memthm.this.difficulty;  //TODO does this need to be a copy? Memthm.this.difficulty will keep changing, but this.difficulty should not change once set.
            this.state = Memthm.this.state; //TODO does this need to be a copy?
        }

    }
}