package cn.tedu.ttms.common.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonDateTypeConvert extends JsonSerializer<Date>{

	/**
	 * springmvc 在将日期对象转换为字符串时,一般会默认转换为长整型,假如我们要自己定义格式,需要继承类JsonSerializer
	 * 使用:在对应的实体对象的get方法中使用@JsonSerialize(using=JsonDateTypeConvert.class)
	 * @param value 是要转换的日期
	 * @param gen 为一个json对象生成器
	 */
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = fmt.format(value);
		//将此字符串写入到json对象中
		gen.writeString(dateStr);
	}

}
