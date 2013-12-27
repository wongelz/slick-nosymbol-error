package com.wongelz.exp.data

import com.wongelz.exp.model.{TeacherId, Teacher}

trait TeacherComponent { this: Profile =>
  import profile.simple._

  class Teachers(tag: Tag) extends Table[Teacher](tag, "teacher") {
    def id = column[TeacherId]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name", O.NotNull)

    def * = (id.?, name) <> (Teacher.tupled, Teacher.unapply)
  }

  val teachers = TableQuery[Teachers]
}
