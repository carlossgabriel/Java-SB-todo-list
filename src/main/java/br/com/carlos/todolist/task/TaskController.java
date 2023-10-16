package br.com.carlos.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlos.todolist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private ITaskRepository taskRepository;

  @PostMapping("/create/")
  public ResponseEntity create(
      @RequestBody TaskModel taskModel,
      HttpServletRequest request,
      HttpServletResponse response) {
    var idUser = request.getAttribute("idUser");
    if (idUser == null) {
      return null;
    }

    taskModel.setCreatedBy((UUID) idUser);

    var currentDate = LocalDateTime.now();
    if (taskModel.getDueDate() == null) {
      taskModel.setDueDate(currentDate.plusDays(10));
    }

    if (taskModel.getDueDate().isBefore(currentDate)) {
      return ResponseEntity.badRequest().body("Due date must be after current date");
    } else if (taskModel.getCreatedAt().isAfter(taskModel.getCompletedDate())) {
      return ResponseEntity.badRequest().body("Completion date must be after creation date");
    } else if (taskModel.getCreatedAt().isAfter(taskModel.getDueDate())) {
      return ResponseEntity.badRequest().body("Due date must be after creation date");
    }

    var task = this.taskRepository.save(taskModel);
    return ResponseEntity.status(200).body(task);
  }

  @GetMapping("/list/")
  public ResponseEntity list(HttpServletRequest request, HttpServletResponse response) {
    var idUser = request.getAttribute("idUser");
    if (idUser == null) {
      return null;
    }

    var tasks = this.taskRepository.findByCreatedBy((UUID) idUser);
    return ResponseEntity.status(200).body(tasks);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity update(
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable UUID id,
      @RequestBody TaskModel taskModel) {
    var task = this.taskRepository
        .findById(id)
        .orElse(null);
    if (task == null) {
      return ResponseEntity.status(404).body("Task not found");
    }

    if (task.getCreatedBy() != request.getAttribute("idUser")) {
      return ResponseEntity.status(401).body("Unauthorized");
    }

    Utils.copyNonNullProperties(taskModel, task);

    var updatedTask = this.taskRepository.save(taskModel);

    return ResponseEntity.status(200).body(updatedTask);
  }
}
