package ru.trubin23.room_migration;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private AppDatabase mDatabase;
    private EmployeeDao mEmployeeDao;

    @Before
    public void createDb() throws Exception {
        mDatabase = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                AppDatabase.class)
                .build();
        mEmployeeDao = mDatabase.employeeDao();
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("ru.trubin23.room_migration", appContext.getPackageName());
    }

    @Test
    public void whenInsertEmployeeThenReadTheSameOne() {
        Employee employee = new Employee();
        employee.id = 1;
        employee.name = "";
        employee.salary = 10000;
        employee.birthday = 1980;
        employee.age = 25;

        mEmployeeDao.insert(employee);

        assertEquals(1, mEmployeeDao.getAll().size());
    }

    @Test
    public void whenInsertEmployeeListThenReadTheSameOne() {
        List<Employee> employeeList = new ArrayList<>();

        int listSize = 10;

        for (int i = 0; i < listSize; i++) {
            Employee employee = new Employee();
            employee.id = i;
            employee.name = "";
            employee.salary = 10000;
            employee.birthday = 1980;
            employee.age = 25;

            employeeList.add(employee);
        }

        mEmployeeDao.insertAll(employeeList);

        assertEquals(listSize, mEmployeeDao.getAll().size());
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }
}
