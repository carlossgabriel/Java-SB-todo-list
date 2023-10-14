package br.com.carlos.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_user")
public class UserModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Column(unique = true)
  private String username;
  private String name;

  private String password;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @CreatedBy
  private String createdBy = "defaultUser";

  @LastModifiedBy
  private String lastModifiedBy;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}