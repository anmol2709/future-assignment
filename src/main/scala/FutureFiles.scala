package edu.knoldus

import java.io.File
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object FutureFiles extends App {

  def getFiles(dir: File): Future[List[File]] = Future {

    def getRecursiveListOfFiles(dir: File): List[File] = {
      val these = dir.listFiles
      val list = these ++ (these.filter(_.isDirectory).map(x => getRecursiveListOfFiles(x)))
      (these ++ these.filter(_.isDirectory).flatMap(getRecursiveListOfFiles)).filter(!_.isDirectory).toList
    }

    getRecursiveListOfFiles(dir)
  }

}
