package org.castixz.municipalityimporter.dao;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity(name = "municipality")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MunicipalityDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipality_id_seq")
    @SequenceGenerator(name = "municipality_id_seq", sequenceName = "municipality_id_seq")
    private Integer id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}
