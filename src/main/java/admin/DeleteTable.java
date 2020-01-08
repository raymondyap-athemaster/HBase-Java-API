package admin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class DeleteTable
{

    public static Configuration configuration;
    public static Connection connection;
    public static Admin admin;

    public static void main(String[] args) throws IOException
    {
        System.out.println("Tested.\n");

        configuration = HBaseConfiguration.create();
        //configuration.setConfiguration("hbase.rootdir","hdfs://idx046:9000/hbase");
        configuration.set("hbase.zookeeper.quorum","35.229.149.35");
        configuration.set("hbase.zookeeper.property.clientPort","2181");
        configuration.set("hbase.master", "35.229.149.35:16010");

        connection = ConnectionFactory.createConnection(configuration);
        admin = connection.getAdmin();

        Table table = connection.getTable(TableName.valueOf(args[0]));

        connection = ConnectionFactory.createConnection(configuration);


        TableName tableName = TableName.valueOf(args[0]);
        admin.disableTable(tableName);
        admin.deleteTable(tableName);
        System.out.println("Table deleted.\n");

        connection.close();
    }
}
