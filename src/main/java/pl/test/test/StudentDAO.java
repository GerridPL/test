package pl.test.test;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.test.test.entity.StudentEntity;

import java.util.UUID;

public interface StudentDAO extends JpaRepository<StudentEntity, UUID> {
}
