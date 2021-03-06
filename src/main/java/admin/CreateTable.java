package admin;

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
        configuration.set("hbase.zookeeper.quorum","34.80.213.98");
        configuration.set("hbase.zookeeper.property.clientPort","2181");
        configuration.set("hbase.master", "34.80.213.98:16010");

        connection = ConnectionFactory.createConnection(configuration);
        admin = connection.getAdmin();
        TableName tableName = TableName.valueOf(args[0]);
        HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
        HColumnDescriptor hColumnDescriptor = new HColumnDescriptor("personal data");
        hTableDescriptor.addFamily(hColumnDescriptor);
        hTableDescriptor.addFamily(new HColumnDescriptor("professional data"));
        admin.createTable(hTableDescriptor);
        System.out.println(" Table created ");
        connection.close();

        // Instantiating configuration class
        /*
        Configuration con = HBaseConfiguration.create();

        // Instantiating HbaseAdmin class
        HBaseAdmin admin = new HBaseAdmin(con);

        // Instantiating table descriptor class
        HTableDescriptor tableDescriptor = new
                HTableDescriptor(TableName.valueOf("emp"));

        // Adding column families to table descriptor
        tableDescriptor.addFamily(new HColumnDescriptor("personal"));
        tableDescriptor.addFamily(new HColumnDescriptor("professional"));

        // Execute the table through admin
        admin.createTable(tableDescriptor);
        System.out.println(" Table created ");
         */
    }
}
