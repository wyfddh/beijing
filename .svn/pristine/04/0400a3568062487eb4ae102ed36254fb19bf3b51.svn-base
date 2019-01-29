package com.tj720.mip.framework;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.tj720.mip.utils.MyString;

public class IdGenerator implements IdentifierGenerator{

	public Serializable generate(SessionImplementor arg0, Object arg1)
			throws HibernateException {
		try {
			String id = "";
			if (!MyString.isEmpty(arg1)) {
				Class<? extends Object> class1 = arg1.getClass();
				if (!MyString.isEmpty(class1)) {
					Class<?> superclass = class1.getSuperclass();
					if (!MyString.isEmpty(superclass)) {
						Object object = superclass.getDeclaredField("id").get(arg1);
						if (!MyString.isEmpty(object)) {
							id = object.toString();
						}
						if (!MyString.isEmpty(id)) {
							return id;
						}
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		return UUID.randomUUID().toString().replace("-", "");
	}
}
