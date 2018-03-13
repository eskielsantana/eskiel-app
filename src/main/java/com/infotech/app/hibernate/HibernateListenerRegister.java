package com.infotech.app.hibernate;

import com.infotech.app.hibernate.listener.ListenerExample;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Component
public class HibernateListenerRegister {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private ListenerExample listenerExample;

    @PostConstruct
    public void registerListeners() {
        if(entityManagerFactory instanceof HibernateEntityManagerFactory) {
            final HibernateEntityManagerFactory  hibernateEntityManagerFactory = (HibernateEntityManagerFactory) entityManagerFactory;
            final SessionFactoryImpl sessionFactory =  (SessionFactoryImpl) hibernateEntityManagerFactory.getSessionFactory();
            final EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);

            registry.getEventListenerGroup(EventType.PERSIST).appendListener(listenerExample);
            //registry.getEventListenerGroup(EventType.MERGE).appendListener(auditEventListener);
           // registry.getEventListenerGroup(EventType.DELETE).appendListener(auditEventListener);
            //registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(auditEventListener);
            // register other events here
        }
    }

}
