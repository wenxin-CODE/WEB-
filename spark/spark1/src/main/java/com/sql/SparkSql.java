package com.sql;

public class SparkSql {
    public static void main(String[] args) {
        final SparkSession sparkSession = SparkSession
                .builder()
                .master("local[*]")
                .appName("SparkSQL")
                .getOrCreat();

        final DataSet<Row> ds = sparkSession.read().json("data/user.json");
//        创建sql表
        ds.creatrOrReplaceTempViews("user");

        String sql = "select * from user";
        final DataSet<Row> sqlDDS = sparkSession.sql(sql);

        sqlDDS,show();
        sparkSession.close();
    }
}
