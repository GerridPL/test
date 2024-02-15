package pl.test.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorValue("lecturer")
public class LecturerEntity extends HumanEntity {

    @Column(name = "lecturerId")
    private String lecturerId;

}
