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

public class Exam extends BaseEntity {
  private int questionCount;
  private boolean open;
  private String accessCode;
  private List<Category> categories;
  private List<StudentExam> studentExams;

  public Exam(int id, int questionCount, boolean open, String accessCode) {
    super(id);
    this.questionCount = questionCount;
    this.open = open;
    this.accessCode = accessCode;
    this.categories = new ArrayList<>();
    this.studentExams = new ArrayList<>();
  }

  public int getQuestionCount() {
    return questionCount;
  }

  public boolean isOpen() {
    return open;
  }

  public String getAccessCode() {
    return accessCode;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public List<StudentExam> getStudentExams() {
    return studentExams;
  }

  public void setQuestionCount(int questionCount) {
    this.questionCount = questionCount;
  }

  public void setOpen(boolean open) {
    this.open = open;
  }

  public void setAccessCode(String accessCode) {
    this.accessCode = accessCode;
  }
  
  public boolean addCategory(Category category)
  {
    if (categories.contains(category))
      return true;
    else
      return categories.add(category);
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
    return "Exam{" + "questionCount=" + questionCount + ", open=" + open + ", accessCode=" + accessCode + ", categories=" + categories + ", studentExams=" + studentExams + '}';
  }
}
