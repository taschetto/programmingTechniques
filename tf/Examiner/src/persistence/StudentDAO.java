/*
 * The MIT License
 * 
 * Copyright 2014 Guilherme Taschetto.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package persistence;

import business.Student;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements BaseDAO<Student> {

  @Override
  public List<Student> getAll() throws DAOException {
    List<Student> students = new ArrayList<>();
    String sql = "select * from students";
    try {
      try (Connection connection = DatabaseManager.getConnection()) {
        try (Statement statement = connection.createStatement()) {
          ResultSet resultSet = statement.executeQuery(sql);
          while (resultSet.next()) {
            Student student = new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("registration"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getString("email"));
            students.add(student);
          }
        }
      }
      return students;
    } catch (SQLException e) {
        throw new DAOException(e);
    }
  }

  @Override
  public Student getById(int id) throws DAOException {
    Student student = null;
    String sql = "select * from students where students.id = ?";
    try {
      try (Connection connection = DatabaseManager.getConnection()) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
          statement.setInt(1, id);
          ResultSet resultSet = statement.executeQuery();
          if (resultSet.next()) {
            student = new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("registration"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getString("email"));
          }
        }
      }
      return student;
    } catch (SQLException e) {
        throw new DAOException(e);
    }
  }

  @Override
  public void Add(Student student) throws DAOException {
    String sql = "insert into student (id, registration, password, name, email) values (?, ?, ?, ?, ?)";
    int result = 0;
    try {
      try (Connection connection = DatabaseManager.getConnection()) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
          statement.setInt(1, student.getId());
          statement.setString(2, student.getRegistration());
          statement.setString(3, student.getPassword());
          statement.setString(4, student.getName());
          statement.setString(5, student.getEmail());
          result = statement.executeUpdate();
        }
      }
    } catch (SQLException e) {
        throw new DAOException(e);
    }    

    if (result == 0) {
      throw new DAOException("Insert failed!");
    }
  }

  @Override
  public void Update(Student student) throws DAOException {
    String sql = "update student set (password, email) values (?, ?) where id = ?";
    int result = 0;
    try {
      try (Connection connection = DatabaseManager.getConnection()) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
          statement.setString(1, student.getPassword());
          statement.setString(2, student.getEmail());
          statement.setInt(1, student.getId());
          result = statement.executeUpdate();
        }
      }
    } catch (SQLException e) {
        throw new DAOException(e);
    }    

    if (result == 0) {
      throw new DAOException("Update failed!");
    }
  }
}
