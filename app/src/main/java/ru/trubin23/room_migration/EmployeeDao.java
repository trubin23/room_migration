package ru.trubin23.room_migration;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employee")
    List<Employee> getAll();

    @Query("SELECT * FROM employee ORDER BY salary DESC")
    List<Employee> getAllOrderBySalary();

    @Insert
    void insert(Employee employee);

    @Insert
    void insertAll(List<Employee> employees);

    @Update
    int update(Employee employee);

    @Delete
    void delete(Employee employee);

    @Query("DELETE FROM employee")
    void deleteAll(Employee employee);
}
