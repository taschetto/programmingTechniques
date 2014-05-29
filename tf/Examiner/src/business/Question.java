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

public class Question extends BaseEntity {
  private String questionContent;
  private String feedbackContent;
  private Alternative rightAlternative;
  private List<Category> categories;
  private List<Alternative> alternatives;
  private List<Answer> answers;

  public Question(int id, String questionContent, String feedbackContent, Alternative rightAlternative) {
    super(id);
    this.questionContent = questionContent;
    this.feedbackContent = feedbackContent;
    this.rightAlternative = rightAlternative;
    this.categories = new ArrayList<>();
    this.alternatives = new ArrayList<>();
    this.answers = new ArrayList<>();
  }

  public String getQuestionContent() {
    return questionContent;
  }

  public String getFeedbackContent() {
    return feedbackContent;
  }

  public Alternative getRightAlternative() {
    return rightAlternative;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public List<Alternative> getAlternatives() {
    return alternatives;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setQuestionContent(String questionContent) {
    this.questionContent = questionContent;
  }

  public void setFeedbackContent(String feedbackContent) {
    this.feedbackContent = feedbackContent;
  }

  public void setRightAlternative(Alternative rightAlternative) {
    this.rightAlternative = rightAlternative;
  }
  
  public boolean addCategory(Category category)
  {
    if (categories.contains(category))
      return true;
    else
      return categories.add(category);
  }
  
  public boolean addAlternative(Alternative alternative)
  {
    if (alternatives.contains(alternative))
      return true;
    else
      return alternatives.add(alternative);
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
    return "Question{" + "questionContent=" + questionContent + ", feedbackContent=" + feedbackContent + ", rightAlternative=" + rightAlternative + ", categories=" + categories + ", alternatives=" + alternatives + ", answers=" + answers + '}';
  }
}
