package pl.test.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import pl.test.test.HumanConverter;
import pl.test.test.HumanType;

import java.util.UUID;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "human")
public abstract class HumanEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "type", nullable = false, insertable = false, updatable = false)
    @Convert(converter = HumanConverter.class)
    protected HumanType type;

    protected HumanEntity() {
    }

    public HumanEntity(UUID id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
