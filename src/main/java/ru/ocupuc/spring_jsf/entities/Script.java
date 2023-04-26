package ru.ocupuc.spring_jsf.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "script")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "lamps")
@ToString(exclude = "lamps")
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "script_lamp",
            joinColumns = {@JoinColumn(name = "script_id")},
            inverseJoinColumns = {@JoinColumn(name = "lamp_id")}
    )
    private Set<Lamp> lamps;
}