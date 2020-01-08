import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

public class CreateTable
{
    public static Configuration configuration;
    public static Connection connection;
    public static Admin admin;

    public static void main(String[] args) throws IOException
    {
        configuration = HBaseConfiguration.create();
        //configuration.setConfiguration("hbase.rootdir","hdfs://idx046:9000/hbase");
        configuration.set("hbase.zookeeper.quorum","35.229.149.35");
        configuration.set("hbase.zookeeper.property.clientPort","2181");
        configuration.set("hbase.master", "35.229.149.35:16010");
        connection = ConnectionFactory.createConnection();
        admin = connection.getAdmin();
        TableName tableName = TableName.valueOf("emp2");
        HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
        HColumnDescriptor hColumnDescriptor = new HColumnDescriptor("personal data");
        hTableDescriptor.addFamily(hColumnDescriptor);
        admin.createTable(hTableDescriptor);
    }
}
