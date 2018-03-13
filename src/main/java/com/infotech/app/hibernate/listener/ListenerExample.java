package com.infotech.app.hibernate.listener;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ListenerExample implements PersistEventListener {

    @Override
    public void onPersist(PersistEvent event) throws HibernateException {
        System.out.println("Persistiu");
    }

    @Override
    public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
        System.out.println("Persistiu2");
    }
}
