package com.amilus.dreamthesilence.base;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

public class BrowserScope extends SimpleThreadScope {
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object object = super.get(name, objectFactory);
        return object;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }
}
