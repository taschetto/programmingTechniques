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

package business;

import java.util.ArrayList;
import java.util.List;

public class Student extends BaseEntity {
  private String registration;
  private String password;
  private String name;
  private String email;
  private List<StudentExam> studentExams;

  public Student(int id, String registration, String password, String name, String email) {
    super(id);
    this.registration = registration;
    this.password = password;
    this.name = name;
    this.email = email;
    this.studentExams = new ArrayList<>();
  }

  public String getRegistration() {
    return registration;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public List<StudentExam> getStudentExams() {
    return studentExams;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public boolean addStudentExam(StudentExam studentExam)
  {
    if (studentExams.contains(studentExam))
      return true;
    else
      return studentExams.add(studentExam);
  }

  @Override
  public String toString() {
    return "Student{" + "registration=" + registration + ", password=" + password + ", name=" + name + ", email=" + email + ", studentExams=" + studentExams + '}';
  }
}
