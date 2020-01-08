package client;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;

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


    }
}
