package com.wongelz.exp.model

import scala.slick.lifted.MappedTo

case class StudentId(value: Long) extends MappedTo[Long]

case class Student(id: Option[StudentId], name: String, teacherId: TeacherId)