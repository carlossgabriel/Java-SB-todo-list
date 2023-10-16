package br.com.carlos.todolist.task;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
  ArrayList<TaskModel> findByCreatedBy(UUID idUser);
}
