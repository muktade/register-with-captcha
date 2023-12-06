package com.registration.captcher.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.captcher.entiry.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
