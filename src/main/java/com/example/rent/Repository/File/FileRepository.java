package com.example.rent.Repository.File;

import com.example.rent.Entity.File.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Integer> {
}
