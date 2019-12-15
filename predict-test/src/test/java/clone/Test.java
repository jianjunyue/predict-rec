package clone;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.SerializationUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;

public class Test {

	public static void main(String[] args)
			throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, CloneNotSupportedException {
		Msg bean1 = new Msg(1, "1",new Address("info1"));
		Msg bean2 = new Msg(2, "2",new Address("info2"));
		bean2 = bean1;
		bean2= (Msg)BeanUtils.cloneBean(bean1);//属性复制

		Msg bean3=(Msg)SerializationUtils.clone(bean1);
//		Msg bean4=(Msg) bean1.clone();
		bean1.setName("YYYY");;
		bean1.setAddress(new Address("wwwwwwww"));
		
		System.out.println(String.format("bean1:%s", JSONObject.toJSONString(bean1)));
		System.out.println(String.format("bean2:%s", JSONObject.toJSONString(bean2)));
		System.out.println(String.format("bean3:%s", JSONObject.toJSONString(bean3)));
//		System.out.println(String.format("bean4:%s", JSONObject.toJSONString(bean4)));
		
		
		
		MsgClone beanClone1 = new MsgClone(1, "1");
		MsgClone beanClone2 = new MsgClone(2, "2");
		beanClone2 = (MsgClone) beanClone1.clone(); //克隆
		beanClone1.setName("YYYY");;
		System.out.println(String.format("beanClone1:%s", JSONObject.toJSONString(beanClone1)));
		System.out.println(String.format("beanClone2:%s", JSONObject.toJSONString(beanClone2)));
	
//		SerializationUtils.clone(object)
		
	}

}
