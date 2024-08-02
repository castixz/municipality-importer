package org.castixz.municipalityimporter.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;


@Entity(name = "municipality_part")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MunicipalityPartDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipality_part_id_seq")
    @SequenceGenerator(name = "municipality_part_id_seq", sequenceName = "municipality_part_id_seq")
    private Integer id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "main_municipality", referencedColumnName = "id")
    private MunicipalityDAO mainMunicipality;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}
