import scala.slick.driver.H2Driver.simple._

case class StudentId(value: Long) extends MappedTo[Long] // <- remove this to avoid bug

trait StudentComponent {
  // hand-written mapper to show that simply removing MappedTo fixes compilation error
  implicit def mapper = MappedColumnType.base[StudentId, Long](
    _.value,
    StudentId.apply _
  )

  class Students(tag: Tag) extends Table[(StudentId,String)](tag, "student") {
    def id = column[StudentId]("id", O.PrimaryKey, O.AutoInc)(mapper)
    def name = column[String]("name")

    // This (id, ..) tuple causes "error: no-symbol does not have an owner"
    // Commenting out will let the compiler pass
    def idx = index("idx1", (id,name), unique = true)

    // This is also OK
    // def idx2 = index("idx2", teacherId, unique = true)

    def * = (id, name)
  }
}
