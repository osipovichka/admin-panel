package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.CourseDTO;
import ova.example.adminpanel.models.Course;
import ova.example.adminpanel.repository.CourseRepository;
import ova.example.adminpanel.service.CourseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepo;

    @Override
    public List<CourseDTO> getAllCourse() {
        List<CourseDTO> listCourse = new ArrayList<>();
        for (Course course: courseRepo.findAll()) {
            listCourse.add(CourseDTO.fromModel(course));
        }
        return listCourse;
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Optional<Course> opCourse = courseRepo.findById(id);
        if(opCourse.isEmpty()){
            log.error("Курс с id - {} не найден", id);
        }

        return CourseDTO.fromModel(opCourse.get());
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = new Course(courseDTO);
        CourseDTO courseDto = CourseDTO.fromModel(courseRepo.saveAndFlush(course));
        return courseDto;
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDetails) {
        Optional<Course> opCourse = courseRepo.findById(courseDetails.getId());
        if(opCourse.isEmpty()){
            log.error("Курс с id - {} не найден", courseDetails.getId());
        }
        Course course = opCourse.get();
        course.setName(courseDetails.getName());
        course.setDescription(courseDetails.getDescription());
        course.setPrice(courseDetails.getPrice());
        courseRepo.saveAndFlush(course);

        return CourseDTO.fromModel(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
