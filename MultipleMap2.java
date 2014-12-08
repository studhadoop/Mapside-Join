import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public  class MultipleMap2 extends Mapper<LongWritable,Text,Text,Text>
{
	Text keyEmit = new Text();
	Text valEmit = new Text();
	public void map(LongWritable k, Text v, Context context) throws IOException, InterruptedException
	{
		String line=v.toString();
		String[] words=line.split(" ");
		keyEmit.set(words[0]);
		valEmit.set(words[1]);
		context.write(keyEmit, valEmit);
	}
}
