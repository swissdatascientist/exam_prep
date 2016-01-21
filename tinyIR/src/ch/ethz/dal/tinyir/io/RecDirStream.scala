package ch.ethz.dal.tinyir.io

import java.io.File
import java.io.InputStream

// create a document stream out of all files in a given folder and its subfolders
//
class RecDirStream (dirpath: String, extension: String = "")
  extends DirStream (dirpath,extension) {

  def dirlist : List[String] = recursiveListFiles(new File(dirpath)).map(t => t.getAbsolutePath).toList.filter(valid)
  override def length : Int = dirlist.length
  override def stream : Stream[InputStream] = dirlist.map(fn => DocStream.getStream(fn)).toStream

  def recursiveListFiles(f: File): Array[File] = {
    val these = f.listFiles
    these ++ these.filter(_.isDirectory).flatMap(recursiveListFiles)
  }
}

object RecDirStream {
  def main(args: Array[String]) {
    val path = "C:\\Users\\mafu\\Documents\\zrh_mafu_privat\\exam_prep\\data\\enron\\enron_full\\"
    val ham = new RecDirStream (path, ".ham.txt")
    val spam = new RecDirStream (path, ".spam.txt")
    println("Reading from path = " + path)
    println("Number of ham documents = " + ham.length)
    println("Number of spam documents = " + spam.length)

  }
}