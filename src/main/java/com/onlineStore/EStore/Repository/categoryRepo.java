package com.onlineStore.EStore.Repository;

import com.onlineStore.EStore.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepo extends JpaRepository<Category,Integer>
{
}
