import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class testHadoop {
    public static void main(String[] args) throws Exception {
        FileSystem fs = FileSystem.get(new URI("hdfs://127.0.0.1:9000"), new Configuration());

        FileStatus[] files = fs.listStatus(new Path("/"));
        for (FileStatus f : files) {
            System.out.println(f);
        }
        System.out.println("Compile Over");
    }
}