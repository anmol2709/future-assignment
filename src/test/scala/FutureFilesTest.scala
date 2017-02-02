package edu.knoldus

import java.io.File

import org.scalatest.FunSuite

import scala.concurrent.Await
import scala.concurrent.duration._

class FutureFilesTest extends FunSuite {

  test("Checking list of files data type") {

    val listOfFiles = List(new File("/home/knoldus/Future-assignment/src/main/resources/t2.txt"),
      new File("/home/knoldus/Future-assignment/src/main/resources/t1.txt"),
      new File("/home/knoldus/Future-assignment/src/main/resources/D2/t3"),
      new File("/home/knoldus/Future-assignment/src/main/resources/D2/t4"),
      new File("/home/knoldus/Future-assignment/src/main/resources/D2/D3/t5"))
    assert(Await.result(FutureFiles.getFiles(new File("/home/knoldus/Future-assignment/src/main/resources")), 10 seconds) == listOfFiles)

  }
}
