package edu.knoldus

import java.io.File

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object FutureFiles {

  def getFiles(dir: File): Future[List[File]] = Future {

    def getRecursiveListOfFiles(dir: File): List[File] = {
      val tempListFiles = dir.listFiles()
      (tempListFiles.toList ++ tempListFiles.filter(_.isDirectory).flatMap(getRecursiveListOfFiles)).filter(!_.isDirectory)
    }

    getRecursiveListOfFiles(dir)
  }
}
