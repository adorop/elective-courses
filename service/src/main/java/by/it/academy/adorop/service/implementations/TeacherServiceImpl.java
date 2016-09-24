package by.it.academy.adorop.service.implementations;

import by.it.academy.adorop.dao.api.DAO;
import by.it.academy.adorop.dao.api.MarkDAO;
import by.it.academy.adorop.dao.api.UserDAO;
import by.it.academy.adorop.dao.utils.CatchAndRethrow;
import by.it.academy.adorop.model.Course;
import by.it.academy.adorop.model.Mark;
import by.it.academy.adorop.model.users.Teacher;
import by.it.academy.adorop.service.api.TeacherService;
import by.it.academy.adorop.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Order(9)
@Transactional(rollbackFor = Exception.class)
@CatchAndRethrow(exceptionToCatch = RuntimeException.class, rethrow = ServiceException.class)
public class TeacherServiceImpl extends BasicUserService<Teacher> implements TeacherService {

    private final MarkDAO markDAO;
    @Autowired
    public TeacherServiceImpl(UserDAO<Teacher> userDAO, MarkDAO markDAO) {
        super(userDAO);
        this.markDAO = markDAO;
    }

    @Override
    public void addCourse(Teacher teacher, Course course) {
        teacher.addCourse(course);
        userDAO.update(teacher);
    }

    @Override
    protected DAO<Teacher, Long> getDAO() {
        return userDAO;
    }
}
