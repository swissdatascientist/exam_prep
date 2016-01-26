package ex7

import ch.ethz.dal.tinyir.io.{RecDirStream, DirStream}

/*
  * Created by mafu on 20.01.2016.
*/

class EnronFiles (dirList : String, percentageTrain : Double){
  val spamfiles : RecDirStream = new RecDirStream( dirList, "spam.txt" )
  val hamfiles : RecDirStream = new RecDirStream( dirList, "ham.txt" )
  val sizeOfHam : Int = spamfiles.length
  val sizeOfSpam : Int = hamfiles.length
  val sizeOfCorpus : Int = sizeOfHam + sizeOfSpam

  val sizeOfTrainSet : Int = math.round( sizeOfCorpus * percentageTrain ).toInt
  val trainStream = spamfiles.stream.take(sizeOfTrainSet)++hamfiles.stream.take(sizeOfTrainSet)
  val testStream = spamfiles.stream.slice(sizeOfTrainSet+1, sizeOfCorpus)++
    hamfiles.stream.slice(sizeOfTrainSet+1, sizeOfCorpus)
}

object EnronFiles{
  def main(args : Array[String]) = {
    //Enron corpus
    println("EnronFiles")
    val folder = "C:\\Users\\mafu\\Documents\\zrh_mafu_privat\\exam_prep\\data\\enron\\enron_test\\"

    println(docs.spamfiles.length + " spam files in corpus")
    println(docs.hamfiles.length + " ham files in corpus")

    //Naive Bayes without smoothing
    val percentageTrain : Double = 0.8
    val docs = new EnronFiles(folder, percentageTrain)


    //Generalized error

  }
}