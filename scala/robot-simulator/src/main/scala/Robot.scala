sealed trait Bearing
object Bearing {

	case object North extends Bearing
	case object South extends Bearing
	case object East extends Bearing
	case object West extends Bearing
}

case class Robot(val bearing : Bearing, coordinates : Tuple2[Int, Int]) {
	def advance = this match {
		case Robot(Bearing.North, coordinates) =>  Robot(bearing, (coordinates._1, coordinates._2 + 1))
		case Robot(Bearing.South, coordinates) => Robot(bearing, (coordinates._1, coordinates._2 - 1))
		case Robot(Bearing.East, coordinates) => Robot(bearing, (coordinates._1 + 1, coordinates._2))
		case Robot(Bearing.West, coordinates) => Robot(bearing, (coordinates._1 - 1, coordinates._2))
	}

	def turnLeft() : Robot = this match {
		case Robot(Bearing.North, c) =>  Robot(Bearing.West, c)
		case Robot(Bearing.South, c) => Robot(Bearing.East, c)
		case Robot(Bearing.East, c) => Robot(Bearing.North, c)
		case Robot(Bearing.West, c) => Robot(Bearing.South, c)
	}

	def turnRight() : Robot = this match {
		case Robot(Bearing.North, c) =>  Robot(Bearing.East, c)
		case Robot(Bearing.South, c) => Robot(Bearing.West, c)
		case Robot(Bearing.East, c) => Robot(Bearing.South, c)
		case Robot(Bearing.West, c) => Robot(Bearing.North, c)
	}


	def simulate(s : String) : Robot = s toList match {
		case 'R' :: t => this.turnRight.simulate(t.mkString) 
		case 'A' :: t => this.advance.simulate(t.mkString)
		case 'L' :: t => this.turnLeft.simulate(t.mkString)
		case _ => println("not match"); this
	}
}