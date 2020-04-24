package com.fhit.test.micromapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


/**
 * @author wty
 * @create 2020-04-05 15:57
 */
public class WCDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration(); //自动加载yarn集群中 配置文件

//        // 开启map端输出压缩
//        conf.setBoolean("mapreduce.map.output.compress", true);
//
//        // 设置map端输出压缩方式
//        conf.setClass("mapreduce.map.output.compress.codec", BZip2Codec.class, CompressionCodec.class);

        //job
        Job job = Job.getInstance(conf);
        job.setJarByClass(WCDriver.class); //识别程序位置，套路类
        job.setMapperClass(WCMapper.class);
//        job.setCombinerClass(IntSumReducer.class); //本地合并、局部合并
//        job.setCombinerClass(WCReducer.class); //本地合并、局部合并
        job.setReducerClass(WCReducer.class);

        //map输出数据的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //reduce
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //输入文件路径，第1个参数是输入文件路径，第2个参数是输出文件路径
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        //开启输出压缩
//        FileOutputFormat.setCompressOutput(job, true);
//        FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);

        //提交yarn
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);

    }
}
