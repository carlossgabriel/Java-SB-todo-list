package br.com.carlos.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import br.com.carlos.todolist.user.UserModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "tb_task")
public class TaskModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  private enum priority {
    LOW,
    MEDIUM,
    HIGH
  }

  @Column(length = 50)
  private String title;
  private String description;
  private Boolean completed;

  @CreatedBy
  // @ManyToOne(targetEntity = UserModel.class, cascade = { CascadeType.PERSIST },
  // optional = false)
  private UUID createdBy;

  @LastModifiedBy
  private String lastModifiedBy;

  private LocalDateTime dueDate;

  private LocalDateTime completedDate;

  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;

}
