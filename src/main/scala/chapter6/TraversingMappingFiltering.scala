package chapter6

object TraversingMappingFiltering extends App {
  val intIncreasingList = List(1,2,3,4,5,6,7,8,9,10)

  println(s"Drop 3 from ${intIncreasingList} results in ${intIncreasingList.drop(3)}")
  println(s"Dropping while < 5 from List ${intIncreasingList} results in ${intIncreasingList.dropWhile(x => x < 5)}")
  println(s"Checking if 4 exists in ${intIncreasingList} : ${intIncreasingList.exists(x => x%4 == 0)}")
  println(s"All Even numbers = ${intIncreasingList.filter(x=>x%2==0)}")
  println(s"All Odd numbers = ${intIncreasingList.filterNot(x=>x%2==0)}")
  println(s"Finding 7 = ${intIncreasingList.find(x => x == 7)}")
  println(s"Checks if all elements match a clause = ${intIncreasingList.forall(x => x < 11)}")
  println(s"Partitions a collections ${intIncreasingList.partition(x => x < 5)}")
  println(s"Take 3 first elements ${intIncreasingList.take(3)}")
  println(s"Take while a condition ${intIncreasingList.takeWhile(x => x < 9)}")



  // Fold and Reduce
  val simList = List(1,2,3)

  println(s"Folding list with seed 2 ${simList.fold(3)(_ + _)}")
  println(s"Scan is something maybe hard to apply? On list $simList with 10 and _+_ results in ${simList.scan(10)(_+_)}")

  val listToReduceAndFold = List(10, 3, 1)
  println(s"Reduce on $listToReduceAndFold with expr _+_ ${listToReduceAndFold.reduce(_ + _)}")
  println(s"Reduce left on $listToReduceAndFold with expr _+_ ${listToReduceAndFold.reduceLeft(_ + _)}")
  println(s"Reduce right on $listToReduceAndFold with expr _+_ ${listToReduceAndFold.reduceRight(_ + _)}")

  println(s"Reduce on $listToReduceAndFold with expr _-_ ${listToReduceAndFold.reduce(_ - _)}")
  println(s"Reduce left on $listToReduceAndFold with expr _-_ ${listToReduceAndFold.reduceLeft(_ - _)}")
  println(s"Reduce right on $listToReduceAndFold with expr _-_ ${listToReduceAndFold.reduceRight(_ - _)}")


}
