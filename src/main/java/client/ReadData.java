package client;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class ReadData
{
    private static Configuration configuration;
    private static Connection connection;

    public static void main (String[] args) throws IOException
    {
        System.out.println("Tested.");

        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum","34.80.213.98");
        configuration.set("hbase.zookeeper.property.clientPort","2181");
        configuration.set("hbase.master", "34.80.213.98:16010");

        connection = ConnectionFactory.createConnection(configuration);
        TableName tableName = TableName.valueOf(args[0]);
        Table table = connection.getTable(tableName);
        Get get = new Get(Bytes.toBytes("row1"));
        Result set = table.get(get);
        Cell[] cells  = set.rawCells();

        String result = null;
        for(Cell cell:cells)
        {
            //System.out.println(Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength())+"::"+Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
            result+=Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength())+"::"+Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength())+"\n";
        }
        System.out.println(result);
        table.close();
        connection.close();
    }
}
