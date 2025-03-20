package com.Assignment_1.InventoryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;


@MappedSuperclass
@Getter
@Setter
public class TimeStampEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp  // Automatically sets the creation time
    @Column(updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp  // Automatically updates when entity changes
    private Date updatedAt;

}
