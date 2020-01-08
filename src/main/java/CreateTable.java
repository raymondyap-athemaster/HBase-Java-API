import java.io.IOException;


import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.TableName;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.util.Bytes;

public class CreateTable
{
    public static void main(String[] args) throws IOException
    {
        // Instantiating configuration class
        Configuration conf = HBaseConfiguration.create();

        conf.set("hbase.zookeeper.quorum","35.229.149.35");
        conf.set("hbase.zookeeper.property.clientPort","2181");
        conf.set("hbase.master", "35.229.149.35:16010");

        // Instantiating configuration class
        Configuration con = HBaseConfiguration.create();

        // Instantiating HbaseAdmin class
        HBaseAdmin admin = new HBaseAdmin(conf);

        // Instantiating table descriptor class
        HTableDescriptor tableDescriptor = new
                HTableDescriptor(TableName.valueOf("emp2"));

        // Adding column families to table descriptor
        tableDescriptor.addFamily(new HColumnDescriptor("personal2"));
        tableDescriptor.addFamily(new HColumnDescriptor("professional2"));

        // Execute the table through admin
        admin.createTable(tableDescriptor);
        System.out.println(" Table created ");
    }
}
