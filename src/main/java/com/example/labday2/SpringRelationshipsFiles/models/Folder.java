package com.example.labday2.SpringRelationshipsFiles.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;


    @OneToMany(mappedBy = "folder")
    private List<File> files;

    @JsonIgnoreProperties(value = "folders")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Folder(String title, User user) {
        this.title = title;
        this.files = new ArrayList<>();
        this.user = user;
    }

    public Folder() {
    }

    public void addFile(File file) {
        this.files.add(file);
    }

//    getters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<File> getFiles() {
        return files;
    }

    public User getUser() {
        return user;
    }

//    setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
