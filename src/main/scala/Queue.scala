case class Queue[T]() {

  case class Node(var next: Node, var value: T)

  var first: Node = _
  var last: Node = _

  def add(item: T): Unit = {
    val node = Node(null, item)
    if (first == null) {
      first = node
      last = first
    } else {
      last.next = node
      last = last.next
    }
  }

  def get(): Option[T] = {
    try {
      val result = first.value
      first = first.next
      Some(result)
    } catch {
      case _: NullPointerException => None
    }
  }

  def printAll(): Unit = {
    if (first != null) {
      println(first.value)
      var last = first.next
      while (last != null) {
        println(last.value)
        last = last.next
      }
    } else {
      println("The List is empty!")
    }
  }
}
