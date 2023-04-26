package ru.ocupuc.spring_jsf.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "lamp")
@Getter
@Setter
@NoArgsConstructor

public class Lamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @ManyToMany(mappedBy = "lamps", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Script> scripts;
}