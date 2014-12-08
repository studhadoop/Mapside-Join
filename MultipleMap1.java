import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class MultipleMap1 extends Mapper<LongWritable,Text,Text,Text>
	{
	Text keyEmit = new Text();
	Text valEmit = new Text();
		public void map(LongWritable k, Text value, Context context) throws IOException, InterruptedException
		{
			String line=value.toString();
			String[] words=line.split("\t");
			keyEmit.set(words[0]);
			valEmit.set(words[1]);
			context.write(keyEmit, valEmit);
		}
	}
