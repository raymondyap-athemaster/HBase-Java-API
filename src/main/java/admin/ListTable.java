package admin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;


public class ListTable
{
    private static Connection connection;
    private static Configuration configuration;
    private static Admin admin;

    public static void main(String[] args) throws IOException
    {
        System.out.println("Tested.\n");

        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum","34.80.213.98");
        configuration.set("hbase.zookeeper.property.clientPort","2181");
        configuration.set("hbase.master", "34.80.213.98:16010");

        connection = ConnectionFactory.createConnection(configuration);
        admin =connection.getAdmin();
        HTableDescriptor[] tableDescriptor = admin.listTables();
        // printing all the table names.
        for (HTableDescriptor hTableDescriptor : tableDescriptor) {
            System.out.println(hTableDescriptor.getNameAsString());
        }
        connection.close();
    }
}
