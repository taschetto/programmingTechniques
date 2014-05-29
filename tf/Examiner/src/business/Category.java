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

public class Category extends BaseEntity {
  private String name;
  private String description;
  private List<Exam> exams;
  private List<Question> questions;

  public Category(int id, String name, String description) {
    super(id);
    this.name = name;
    this.description = description;
    this.exams = new ArrayList<>();
    this.questions = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public List<Exam> getExams() {
    return exams;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
  public boolean addExam(Exam exam)
  {
    if (exams.contains(exam))
      return true;
    else
      return exams.add(exam);
  }
  
  public boolean addQuestion(Question question)
  {
    if (questions.contains(question))
      return true;
    else
      return questions.add(question);
  }

  @Override
  public String toString() {
    return "Category{" + "name=" + name + ", description=" + description + ", exams=" + exams + ", questions=" + questions + '}';
  }
}
