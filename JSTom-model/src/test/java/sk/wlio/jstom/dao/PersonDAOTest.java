package sk.wlio.jstom.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import sk.wlio.jstom.entity.Person;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "classpath:META-INF/applicationContext.xml"
        })

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
public class PersonDAOTest {

    @Autowired
    private PersonDAO personDAO;

    @Test
    public void persistTest() {
        Person p = new Person();
        p.setName("Karol");
        p.setAge(12);

        personDAO.persist( p);
        Long id = p.getId();
        assertNotNull( id);

        Person pA = personDAO.find(id);

        assertNotNull( pA);
        assertEquals("Karol", p.getName());
        assertEquals(12, p.getAge().longValue());
        assertNull(  p.getAddresses());
    }
}
