package com.example.thecoffeehouse.domain.common.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

public abstract class ValueObject {
    // Value object only public method getter because Value Object is Immutable

    public static <ValueObjectExtend extends ValueObject> Iterator<Object> getComponentsField (ValueObjectExtend valueObjectExtend){
        Class<?> classValueObject;
        classValueObject = valueObjectExtend.getClass();
        Method[] methods = classValueObject.getDeclaredMethods();
        ArrayList<Object> fieldsValueOfObject = new ArrayList<>();
        for (Method method : methods) {
            if(method.getName().contains("get")) {
                try {
                    fieldsValueOfObject.add(method.invoke(valueObjectExtend));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return fieldsValueOfObject.iterator();
    }
    public static  <ValueObjectFirst extends  ValueObject , ValueObjectSecond extends  ValueObject> boolean equal (ValueObjectFirst valueObject1 , ValueObjectSecond valueObject2)  {
        if((valueObject1 == null || valueObject2 == null) || !valueObject1.getClass().getName().equals(valueObject2.getClass().getName() )){
            return false;
        }
        Iterator<Object> fieldsValueObject1 = valueObject1.getComponentsField(valueObject1);
        Iterator<Object> fieldsValueObject2 = valueObject2.getComponentsField(valueObject2);
        while (fieldsValueObject1.hasNext()){
            if(!fieldsValueObject1.next().equals(fieldsValueObject2.next())){
                return false;
            }
        }
        return true;
    }

    //public abstract String  getNameClass();

}
