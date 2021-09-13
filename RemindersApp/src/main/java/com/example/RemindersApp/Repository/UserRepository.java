package com.example.RemindersApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RemindersApp.model.UserPage;

public interface UserRepository extends JpaRepository<UserPage,Long> {

}
