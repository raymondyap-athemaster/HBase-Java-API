package client;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class InsertData
{

    private static Configuration configuration;
    private static Connection connection;

    public static void main(String[] args) throws IOException
    {
        System.out.println("Tested.\n");

        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum","34.80.213.98");
        configuration.set("hbase.zookeeper.property.clientPort","2181");
        configuration.set("hbase.master", "34.80.213.98:16010");

        connection = ConnectionFactory.createConnection(configuration);


        // Instantiating Put class
        // accepts a row name.
        Put put = new Put(Bytes.toBytes("row1"));

        // adding values using add() method
        // accepts column family name, qualifier/row name ,value
        put.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("name"),Bytes.toBytes("raju"));

        put.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("city"),Bytes.toBytes("hyderabad"));

        put.addColumn(Bytes.toBytes("professional data"),Bytes.toBytes("designation"), Bytes.toBytes("manager"));

        put.addColumn(Bytes.toBytes("professional data"),Bytes.toBytes("salary"), Bytes.toBytes("50000"));

        TableName tableName = TableName.valueOf(args[0]);
        //得到 table
        Table table = connection.getTable(tableName);
        //执行插入
        table.put(put);
        System.out.println("data inserted");
        connection.close();

    }
}
