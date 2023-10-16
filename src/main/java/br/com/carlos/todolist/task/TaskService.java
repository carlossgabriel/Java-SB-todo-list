package br.com.carlos.todolist.task;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
  private final ITaskRepository taskRepository;

  @Autowired
  public TaskService(ITaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public TaskModel getTaskById(UUID id) {
    return taskRepository.findById(id).orElse(null);
  }

  public TaskModel updateTask(TaskModel task) {
    if (taskRepository.existsById(task.getId())) {
      return taskRepository.save(task);
    } else {
      return null;
    }
  }
}
