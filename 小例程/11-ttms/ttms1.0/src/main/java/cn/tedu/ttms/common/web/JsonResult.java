package cn.tedu.ttms.common.web;

/**
 * �����˶����װController��������@ResponseBodyע��ķ���ֵ,
 * Ŀ��:ͳһ����ֵ����,������ҳ���Ͻ���ͳһ����
 * @author uid
 *
 */
public class JsonResult {
	private static final int SUCCESS=1;
	private static final int ERROR=0;
	/**״̬*/
	private int state;
	/**��Ӧ״̬����Ϣ*/
	private String message;
	/**����ҵ������*/
	private Object data;
	
	/**�˹��췽������data����Ϊnull�ĳ���*/
	public JsonResult(){
		this.state=SUCCESS;
		this.message="OK";
	}
	
	/**�о���ҵ�����ݷ���ʱ,ʹ�ô˹��췽��*/
	public JsonResult(Object data){
		this();
		this.data=data;
	}
	
	/**�����쳣�Ժ�Ҫ���ô˷�����װ�쳣��Ϣ*/
	public JsonResult(Throwable t){
		this.state=ERROR;
		this.message=t.getMessage();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
