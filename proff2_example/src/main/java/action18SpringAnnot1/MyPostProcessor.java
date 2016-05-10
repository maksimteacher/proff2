package action18SpringAnnot1;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1) throws BeansException {
		Field[] fields = bean.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				if (field.getType().equals(java.lang.String.class)) {
					field.setAccessible(true);

					String original = (String) field.get(bean);
					field.set(bean, initString(original));					
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return bean;
	}

	private String initString(String str) {
		if(str==null) return "empty";
		return str;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}
}
