CREATE TABLE "category" (
  "id" SERIAL PRIMARY KEY,
  "name" VARCHAR(200) NOT NULL,
  "description" VARCHAR(200) NOT NULL
);

CREATE TABLE "exam" (
  "id" SERIAL PRIMARY KEY,
  "questioncount" INTEGER NOT NULL,
  "open" BOOLEAN NOT NULL,
  "accesscode" VARCHAR(10)
);

CREATE TABLE "category_exam" (
  "category" INTEGER NOT NULL,
  "exam" INTEGER NOT NULL,
  PRIMARY KEY ("category", "exam")
);

CREATE INDEX "idx_category_exam" ON "category_exam" ("exam");

ALTER TABLE "category_exam" ADD CONSTRAINT "fk_category_exam__category" FOREIGN KEY ("category") REFERENCES "category" ("id");

ALTER TABLE "category_exam" ADD CONSTRAINT "fk_category_exam__exam" FOREIGN KEY ("exam") REFERENCES "exam" ("id");

CREATE TABLE "question" (
  "id" SERIAL PRIMARY KEY,
  "questioncontent" VARCHAR(200) NOT NULL,
  "feedbackcontent" VARCHAR(200) NOT NULL,
  "rightalternative" INTEGER NOT NULL
);

CREATE TABLE "alternative" (
  "id" SERIAL PRIMARY KEY,
  "question" INTEGER NOT NULL,
  "answercontent" VARCHAR(200) NOT NULL
);

CREATE INDEX "idx_alternative__question" ON "alternative" ("question");

ALTER TABLE "alternative" ADD CONSTRAINT "fk_alternative__question" FOREIGN KEY ("question") REFERENCES "question" ("id");

CREATE TABLE "category_question" (
  "category" INTEGER NOT NULL,
  "question" INTEGER NOT NULL,
  PRIMARY KEY ("category", "question")
);

CREATE INDEX "idx_category_question" ON "category_question" ("question");

ALTER TABLE "category_question" ADD CONSTRAINT "fk_category_question__category" FOREIGN KEY ("category") REFERENCES "category" ("id");

ALTER TABLE "category_question" ADD CONSTRAINT "fk_category_question__question" FOREIGN KEY ("question") REFERENCES "question" ("id");

CREATE TABLE "student" (
  "id" SERIAL PRIMARY KEY,
  "registration" INTEGER NOT NULL,
  "password" VARCHAR(200) NOT NULL,
  "name" VARCHAR(200) NOT NULL,
  "email" VARCHAR(200) NOT NULL
);

CREATE TABLE "studentexam" (
  "student" INTEGER NOT NULL,
  "exam" INTEGER NOT NULL,
  PRIMARY KEY ("student", "exam")
);

CREATE INDEX "idx_studentexam__exam" ON "studentexam" ("exam");

ALTER TABLE "studentexam" ADD CONSTRAINT "fk_studentexam__exam" FOREIGN KEY ("exam") REFERENCES "exam" ("id");

ALTER TABLE "studentexam" ADD CONSTRAINT "fk_studentexam__student" FOREIGN KEY ("student") REFERENCES "student" ("id");

CREATE TABLE "answer" (
  "studentexam_student" INTEGER NOT NULL,
  "studentexam_exam" INTEGER NOT NULL,
  "question" INTEGER NOT NULL,
  "alternative" INTEGER,
  PRIMARY KEY ("studentexam_student", "studentexam_exam", "question")
);

CREATE INDEX "idx_answer__alternative" ON "answer" ("alternative");

CREATE INDEX "idx_answer__question" ON "answer" ("question");

ALTER TABLE "answer" ADD CONSTRAINT "fk_answer__studentexam_student__studentexam_exam" FOREIGN KEY ("studentexam_student", "studentexam_exam") REFERENCES "studentexam" ("student", "exam");

ALTER TABLE "answer" ADD CONSTRAINT "fk_answer__question" FOREIGN KEY ("question") REFERENCES "question" ("id");

ALTER TABLE "answer" ADD CONSTRAINT "fk_answer__alternative" FOREIGN KEY ("alternative") REFERENCES "alternative" ("id");