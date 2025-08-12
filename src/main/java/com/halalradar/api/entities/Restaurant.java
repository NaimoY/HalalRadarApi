package com.halalradar.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter // This annotation automatically generates getter methods for all fields in the class.
@Setter // This annotation automatically generates setter methods for all fields in the class.
@AllArgsConstructor // This is the annotation that Generates a constructor with one parameter for each field in this class.
@NoArgsConstructor // This annotation Generates a no-argument constructor.
@Entity // This annotation marks the class as a JPA entity, meaning it maps to a database table.
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relationship: Every restaurant has one location
    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Location location;

    @Column(nullable = false, length = 75)
    private String name;

    @Column(name="main_image", nullable = false, length = 1000)
    private String mainImage;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
