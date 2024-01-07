package org.gisela.dacd.businessunit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Weather")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String IslandName;
    private double precipitation;
    private double clouds;
    private double temperature;
    private double windSpeed;
}
