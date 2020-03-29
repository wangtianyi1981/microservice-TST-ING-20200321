package com.fhit.test.micromapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author wty
 * @create 2020-03-05 15:22
 */
//函数参数列表：输入key，输入value，输出key，输出value
//第1个参数是文本的偏移量
public class WCMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //作用：把某一行的单词（value）拆分成a,1 b,1
        String[] words = value.toString().split(" ");
        for (String word : words) {
            context.write(new Text(word), new IntWritable(1));
        }
    }
}
