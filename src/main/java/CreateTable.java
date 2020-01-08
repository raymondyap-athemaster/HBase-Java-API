import java.io.IOException;


import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.TableName;

import org.apache.hadoop.conf.Configuration;

public class CreateTable
{
    public static void main(String[] args) throws IOException
    {
        // Instantiating configuration class
        Configuration conf = HBaseConfiguration.create();

        // Instantiating HbaseAdmin class
        //con.set();
        //HBaseAdmin admin = new HBaseAdmin(con);
        Connection conn = ConnectionFactory.createConnection(conf);
        Admin admin = conn.getAdmin();

        // Instantiating table descriptor class
        HTableDescriptor tableDescriptor = new
                HTableDescriptor(TableName.valueOf("emp2"));

        // Adding column families to table descriptor
        tableDescriptor.addFamily(new HColumnDescriptor("personal"));
        tableDescriptor.addFamily(new HColumnDescriptor("professional"));

        // Execute the table through admin
        admin.createTable(tableDescriptor);
        System.out.println(" Table created ");
    }
}
