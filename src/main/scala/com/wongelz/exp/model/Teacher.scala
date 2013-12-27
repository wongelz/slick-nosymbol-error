package com.wongelz.exp.model

import scala.slick.lifted.MappedTo

case class TeacherId(value: Long) extends MappedTo[Long]

case class Teacher(id: Option[TeacherId], name: String)