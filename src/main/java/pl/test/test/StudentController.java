package pl.test.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.test.test.entity.StudentEntity;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
public class StudentController {

    private final StudentDAO studentDAO;

    @PostMapping("/create")
    public void create(@RequestBody StudentEntity studentEntity) {
        this.studentDAO.saveAndFlush(studentEntity);
    }

    @GetMapping("/all")
    public List<StudentEntity> getAll() {
        return this.studentDAO.findAll();
    }
}
