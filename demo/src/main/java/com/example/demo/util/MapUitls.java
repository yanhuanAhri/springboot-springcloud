package com.example.demo.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class MapUitls {
	public static Map<String,Object> objToMap(Object data) throws IllegalArgumentException, IllegalAccessException{
		if(data == null){    
            return new HashMap<>();    
        }   
        Map<String, Object> map = new HashMap<String, Object>();    
        Field[] declaredFields = data.getClass().getDeclaredFields();   
        for (Field field : declaredFields) {    
             field.setAccessible(true);  
            
				map.put(field.getName(), field.get(data));
			
         }    
		return map;
	}
	
	 public static Object mapToObj(Map<String,Object> map,Class<?> clz) throws Exception{
         Object obj = clz.newInstance();
         Field[] declaredFields = obj.getClass().getDeclaredFields();
         for(Field field:declaredFields){
             int mod = field.getModifiers(); 
             if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                 continue;
             }
             field.setAccessible(true);
             Object value=map.get(field.getName());
             field.set(obj, value);
         }
         return obj;
     }
	 
	 public static Object mapToObject(Map<String, Object> map, Class<?> beanClass)
            throws Exception {
        if (map == null)
            return null;
        Object obj = beanClass.newInstance();
        org.apache.commons.beanutils.BeanUtils.populate(obj, map);
        return obj;
    }

    public static Map<?, ?> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
      //  org.apache.commons.beanutils.BeanMap(obj);
        return new org.apache.commons.beanutils.BeanMap(obj);
    }
}
