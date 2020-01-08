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

        Connection conn = ConnectionFactory.createConnection(conf);
        Admin admin = conn.getAdmin();
        TableName tableName = TableName.valueOf("emp2");
        TableDescriptorBuilder  tdb  =TableDescriptorBuilder.newBuilder(tableName);
        ColumnFamilyDescriptorBuilder cdb =  ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes("personal data"));
        ColumnFamilyDescriptor  cfd = cdb.build();
        tdb.setColumnFamily(cfd);
        TableDescriptor td = tdb.build();
        admin.createTable(td);

        System.out.println(" Table created ");
    }
}
