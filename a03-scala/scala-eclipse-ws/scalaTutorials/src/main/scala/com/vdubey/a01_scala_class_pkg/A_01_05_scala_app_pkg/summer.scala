package com.vdubey.a01_scala_class_pkg.A_01_05_scala_app_pkg
import com.vdubey.a01_scala_class_pkg.A_01_05_scala_app_pkg.ChecksumAccumulator.calculate

object summer {
  def main(args: Array[String]) {
   val args=Array("is","for", "vacation") // install of invoking the args at runtime defining here
for (arg <- args)
println(arg +": "+ calculate(arg))
}
}