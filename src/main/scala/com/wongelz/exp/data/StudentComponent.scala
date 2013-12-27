package com.wongelz.exp.data

import com.wongelz.exp.model.{TeacherId, StudentId, Student}

trait StudentComponent { this: Profile with  TeacherComponent =>
  import profile.simple._

  class Students(tag: Tag) extends Table[Student](tag, "student") {
    def id = column[StudentId]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name", O.NotNull)
    def teacherId = column[TeacherId]("teacher_id", O.NotNull)

    def teacherFk = foreignKey("student_teacher_fk", teacherId, teachers)(_.id)

    // This (teacherId, ..) tuple causes "error: no-symbol does not have an owner"
    // Commenting out will let the compiler pass
    def idx = index("idx1", (teacherId, name), unique = true)

    // This is also OK
    // def idx2 = index("idx2", teacherId, unique = true)

    def * = (id.?, name, teacherId) <> (Student.tupled, Student.unapply)
  }

  val students = TableQuery[Students]
}
