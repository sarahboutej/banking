package com.boutej.banking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * @author Sara Boutej
 * @since 14.09.2023
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

  @Id
  @GeneratedValue
  private Integer       id;

  @CreatedDate
  @Column(
      name = "createdDate",
      nullable = false,
      updatable = false
  )
  private LocalDateTime createdDate;

  @LastModifiedDate
  @Column(name = "lastModifiedDate")
  private LocalDateTime lastModifiedDate;

}
