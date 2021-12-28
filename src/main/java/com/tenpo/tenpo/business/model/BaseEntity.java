package com.tenpo.tenpo.business.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(name = "create_date")
    protected LocalDateTime createDate;

    @Column(name = "update_date")
    protected LocalDateTime updateDate;

    @PrePersist
    public void prePersist() {
        createDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateDate = LocalDateTime.now();
    }

}
