package by.it.academy.adorop.service.implementations;

import by.it.academy.adorop.dao.api.CourseDAO;
import by.it.academy.adorop.model.Course;
import by.it.academy.adorop.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends BasicService<Course, Long> implements CourseService {

    private final CourseDAO courseDAO;

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    protected CourseDAO getDAO() {
        return courseDAO;
    }
}
