package nl.getthere.services;

import nl.getthere.model.respositories.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by jasper.dejong on 14-10-2016.
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private UniversityRepository universityRepo;
    @Autowired
    private EducationRepository educationRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private EventThemeRepository eventThemeRepo;

}
