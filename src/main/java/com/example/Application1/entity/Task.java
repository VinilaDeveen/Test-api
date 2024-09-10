package com.example.Application1.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskID;

    @Column(nullable = false)
    private String taskName;

    @Column(nullable = false)
    private Integer priority;

    @Column(nullable = false)
    private LocalDateTime dueDate;
}
