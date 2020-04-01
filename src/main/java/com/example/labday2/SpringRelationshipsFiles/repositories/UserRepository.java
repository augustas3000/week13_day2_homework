package com.example.labday2.SpringRelationshipsFiles.repositories;

import com.example.labday2.SpringRelationshipsFiles.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
