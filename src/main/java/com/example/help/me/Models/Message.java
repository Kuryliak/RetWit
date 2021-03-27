package com.example.help.me.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String message;
    private String file;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

     public Message(){

     }

    public Message(String message,User user) {
        this.author = user;
        this.message = message;
    }
    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }



    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
