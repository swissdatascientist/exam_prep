package ex7

import ch.ethz.dal.tinyir.io.DirStream

/*
  * Created by mafu on 20.01.2016.
*/

class EnronFiles (dirList : String){
  val spamfiles : DirStream = new DirStream( dirList, "spam.txt" )
  val hamfiles : DirStream = new DirStream( dirList, "ham.txt" )
}

object EnronFiles{
  def main(args : Array[String]) = {
    println("EnronFiles")

    val folder = "C:\\Users\\mafu\\Documents\\zrh_mafu_privat\\exam_prep\\data\\enron\\enron_test\\"
    val docs = new EnronFiles(folder)

    println(docs.spamfiles.length + " spam files in corpus")
    println(docs.hamfiles.length + " ham files in corpus")
  }
}