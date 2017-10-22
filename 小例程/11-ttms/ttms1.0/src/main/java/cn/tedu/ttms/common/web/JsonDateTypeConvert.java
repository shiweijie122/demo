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
	 * springmvc �ڽ����ڶ���ת��Ϊ�ַ���ʱ,һ���Ĭ��ת��Ϊ������,��������Ҫ�Լ������ʽ,��Ҫ�̳���JsonSerializer
	 * ʹ��:�ڶ�Ӧ��ʵ������get������ʹ��@JsonSerialize(using=JsonDateTypeConvert.class)
	 * @param value ��Ҫת��������
	 * @param gen Ϊһ��json����������
	 */
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = fmt.format(value);
		//�����ַ���д�뵽json������
		gen.writeString(dateStr);
	}

}
