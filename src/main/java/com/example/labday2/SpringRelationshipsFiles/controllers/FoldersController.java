package com.example.labday2.SpringRelationshipsFiles.controllers;

import com.example.labday2.SpringRelationshipsFiles.models.Folder;
import com.example.labday2.SpringRelationshipsFiles.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/folders")
public class FoldersController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping
    public ResponseEntity<List<Folder>> getAllFolders() {
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Folder>> getFolder(@PathVariable Long id) {
        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity postFolder(@RequestBody Folder folder) {
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);

    }
}
