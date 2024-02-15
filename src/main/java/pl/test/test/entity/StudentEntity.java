package pl.test.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@DiscriminatorValue("student")
public class StudentEntity extends HumanEntity {

    @Column(name = "studentId")
    private String studentId;

    protected StudentEntity() {
    }

    public StudentEntity(UUID id, String name, String surname, String studentId) {
        super(id, name, surname);
        this.studentId = studentId;
    }
}
