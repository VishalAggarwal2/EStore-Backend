package com.onlineStore.EStore.Repository;

import com.onlineStore.EStore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,String> {
}
