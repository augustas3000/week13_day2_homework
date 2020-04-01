package com.example.labday2.SpringRelationshipsFiles.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Folder> folders;

    public User(String name) {
        this.name = name;
        this.folders = new ArrayList<>();
    }

    public User() {

    }

    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }

    public void addFileToFolder(Folder folder, File file) {

        if (this.folders.indexOf(folder) != -1) {
            folder.addFile(file);
        }

    }


//    getters


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Folder> getFolders() {
        return folders;
    }

//    setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
}
