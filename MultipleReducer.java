import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MultipleReducer extends Reducer<Text,Text,Text,Text>
{
	Text valEmit = new Text();
	String merge = "";
	public void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException , InterruptedException
			{
		int i =0;
		for(Text value:values)
		{
			if(i == 0){
				merge = value.toString()+",";
			}
			else{
				merge += value.toString();
			}

			i++;
		}
		valEmit.set(merge);
		context.write(key, valEmit);
			}
}
