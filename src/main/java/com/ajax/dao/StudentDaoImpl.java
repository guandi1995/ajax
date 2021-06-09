package com.ajax.dao;

import com.ajax.pojo.Student;
import com.ajax.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Di Guan on 6/5/2021 11:25 PM
 */

public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Map> fetchStudent() {
        String SQL = "SELECT * FROM studentinfo";
        return JDBCUtils.executeQuery(SQL);
    }

    @Override
    public List<Map> fetchStudentById(String id) {
        String SQL = "SELECT * FROM studentinfo WHERE stuid = ?";
        return JDBCUtils.executeQuery(SQL, id);
    }

    @Override
    public int insertStudent(Student student) throws SQLException {
        String SQL = "INSERT INTO studentinfo (stuid, stuname, age, gender, major_id) VALUES (?,?,?,?,?)";
        return JDBCUtils.executeUpdate(SQL, student.getStuid(), student.getStuname(), student.getAge(),
                student.getGender(), student.getMajor_id());
    }

    @Override
    public int deleteStudent(String id) throws SQLException {
        String SQL = "DELETE FROM studentinfo WHERE stuid = ?";
        return JDBCUtils.executeUpdate(SQL, id);
    }

    @Override
    public int updateStudent(Student student) throws SQLException {
        String SQL = "UPDATE studentinfo SET stuname = ?, age = ?, gender = ?, major_id = ? where stuid = ?";
        return JDBCUtils.executeUpdate(SQL, student.getStuname(), student.getAge(), student.getGender(),
                student.getMajor_id(), student.getStuid());
    }
}
