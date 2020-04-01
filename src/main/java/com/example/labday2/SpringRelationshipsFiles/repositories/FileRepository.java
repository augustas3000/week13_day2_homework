package com.example.labday2.SpringRelationshipsFiles.repositories;

import com.example.labday2.SpringRelationshipsFiles.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

}
