package com.fhit.test.micromapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author wty
 * @create 2020-03-05 15:24
 */
//函数参数列表：输入key，输入value，输出key，输出value
//第2个参数是整数数组：如Hello[1,1,1]
public class WCReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }

        context.write(key, new IntWritable(sum));
        context.write(new Text(key.toString() + "1"), new IntWritable(sum));
    }
}

