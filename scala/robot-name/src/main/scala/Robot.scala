object Robot {
	val random = scala.util.Random
	val names = (1 to 676000).toStream map (x => nextRandom(random, x))
	var globalCount = 0

	def randomChr() = ('A' + random.nextInt('Z' - 'A')).toChar

	val start = randomChr() + randomChr() 

	def nextRandom(random : scala.util.Random, i : Int) = {
		"" +
			start
			"%03d".format(i)
	}
}


class Robot {
	import Robot._

	var count = 0

	reset()

	def name : String = {
		names(count)
	}

	def reset() = { 
		count = globalCount
		globalCount = globalCount + 1
	}

}