package com.theironyard;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    int id;

    @Column(nullable = false)
    String text;

    public Message(String text) {
        this.text = text;
    }

    public Message() {
    }

    public Message(int id, String text){
        this.id = id;
        this.text = text;
    }
}
