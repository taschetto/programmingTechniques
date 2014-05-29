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

public class Alternative extends BaseEntity {
  private String answerContent;
  private Question question;
  private List<Answer> answers;

  public Alternative(int id, String answerContent, Question question) {
    super(id);
    this.answerContent = answerContent;
    this.question = question;
    this.answers = new ArrayList<>();
  }

  public String getAnswerContent() {
    return answerContent;
  }

  public Question getQuestion() {
    return question;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswerContent(String answerContent) {
    this.answerContent = answerContent;
  }
  
  public boolean addAnswer(Answer answer)
  {
    if (answers.contains(answer))
      return true;
    else
      return answers.add(answer);
  }

  @Override
  public String toString() {
    return "Alternative{" + "answerContent=" + answerContent + ", question=" + question + ", answers=" + answers + '}';
  }
}
