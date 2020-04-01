package com.example.labday2.SpringRelationshipsFiles.components;

import com.example.labday2.SpringRelationshipsFiles.models.File;
import com.example.labday2.SpringRelationshipsFiles.models.Folder;
import com.example.labday2.SpringRelationshipsFiles.models.User;
import com.example.labday2.SpringRelationshipsFiles.repositories.FileRepository;
import com.example.labday2.SpringRelationshipsFiles.repositories.FolderRepository;
import com.example.labday2.SpringRelationshipsFiles.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    UserRepository userRepository;


    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

//        users
        User jack = new User("Jack");
        userRepository.save(jack);
        User ana = new User("Ana");
        userRepository.save(ana);
        User joe = new User("Joe");
        userRepository.save(joe);
        User gus = new User("Gus");
        userRepository.save(gus);
        User antonio = new User("Antonio");
        userRepository.save(antonio);

//        folders
        Folder fishing = new Folder("Fishing",jack);
        folderRepository.save(fishing);
        Folder supper = new Folder("Supper",ana);
        folderRepository.save(supper);
        Folder gym = new Folder("Gym",joe);
        folderRepository.save(gym);
        Folder something = new Folder("Something", gus);
        folderRepository.save(something);
        Folder antonioStuff = new Folder("Antonio stuff", antonio);
        folderRepository.save(antonioStuff);


//        files
//        public File(String name, String extension, int size, Folder folder)
        File deepFishing = new File("Deep fishing", "doc",10,fishing);
        fileRepository.save(deepFishing);

        File fishSoup = new File("Fish soup","doc",40,supper);
        fileRepository.save(fishSoup);

        File trainingSchedule = new File("Training schedule", "doc",50,gym);
        fileRepository.save(trainingSchedule);

        File somethingExplained = new File("Something explained", "xls", 30, something);
        fileRepository.save(somethingExplained);

        File randomStuff = new File("Random stuff", "doc", 20, antonioStuff);
        fileRepository.save(randomStuff);

//        folder's addFile() method in use
//        one folder has many files
        File sushi = new File("Sushi recipe","doc",10,supper);
        fileRepository.save(sushi);
        supper.addFile(sushi);
        folderRepository.save(supper);
    }



}
