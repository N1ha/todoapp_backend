package com.todo.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.demo.todoEntity.todoEntity;

@Repository

public interface todoRepository extends JpaRepository<todoEntity, Integer> {

}
