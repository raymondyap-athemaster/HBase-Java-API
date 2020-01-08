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
        configuration.set("hbase.zookeeper.quorum","35.229.149.35");
        configuration.set("hbase.zookeeper.property.clientPort","2181");
        configuration.set("hbase.master", "35.229.149.35:16010");

        connection = ConnectionFactory.createConnection(configuration);

        // Instantiating HTable class
        HTable hTable = new HTable(configuration, args[0]);

        // Instantiating Put class
        // accepts a row name.
        Put p = new Put(Bytes.toBytes("row1"));

        // adding values using add() method
        // accepts column family name, qualifier/row name ,value
        p.add(Bytes.toBytes("personal"), Bytes.toBytes("name"),Bytes.toBytes("raju"));

        p.add(Bytes.toBytes("personal"), Bytes.toBytes("city"),Bytes.toBytes("hyderabad"));

        p.add(Bytes.toBytes("professional"),Bytes.toBytes("designation"), Bytes.toBytes("manager"));

        p.add(Bytes.toBytes("professional"),Bytes.toBytes("salary"), Bytes.toBytes("50000"));

        // Saving the put Instance to the HTable.
        hTable.put(p);
        System.out.println("data inserted");

        // closing HTable
        hTable.close();
    }
}
