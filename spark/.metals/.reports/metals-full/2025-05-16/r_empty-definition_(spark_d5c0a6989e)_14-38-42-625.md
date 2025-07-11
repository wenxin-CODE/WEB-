error id: file:///D:/spark/Print.scala:`<none>`.
file:///D:/spark/Print.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 577
uri: file:///D:/spark/Print.scala
text:
```scala
// import org.apache.spark.SparkContext
// import org.apache.spark.SparkContext._
// import org.apache.spark.SparkConf

object Print {
  def main(args: Array[String]) {
    val logFile = "YOUR_SPARK_HOME/README.md"
    val conf = new SparkConf().setIfMissing("spark.master", "local[*]").setIfMissing("spark.app.name", "Print")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines@@ with a: %s, Lines with b: %s".format(numAs, numBs))
    println("Hello World!")
  }

}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.