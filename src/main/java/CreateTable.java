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

        // Instantiating HbaseAdmin class
        //con.set();
        //HBaseAdmin admin = new HBaseAdmin(con);
        Connection conn = ConnectionFactory.createConnection(conf);
        Admin admin = conn.getAdmin();

        TableName tableName = TableName.valueOf("emp2");
        //表描述器构造器
        TableDescriptorBuilder  tdb  =TableDescriptorBuilder.newBuilder(tableName)  ;
        //列族描述起构造器
        ColumnFamilyDescriptorBuilder cdb =  ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes("personal data"));
        //获得列描述起
        ColumnFamilyDescriptor  cfd = cdb.build();
        //添加列族
        tdb.setColumnFamily(cfd);
        //获得表描述器
        TableDescriptor td = tdb.build();
        //创建表
        //admin.addColumnFamily(tableName, cfd); //给标添加列族
        admin.createTable(td);
    }
}
