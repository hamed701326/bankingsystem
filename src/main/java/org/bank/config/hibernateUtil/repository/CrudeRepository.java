package org.bank.config.hibernateUtil.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class CrudeRepository<Entity,ID extends Serializable> {
    private Field[] fields = getEntityClass().getFields();
    private Session session;

    protected abstract Class<Entity> getEntityClass();

    protected abstract SessionFactory getSessionFactory();

    public Entity save(Entity entity) {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public void update(Entity entity) {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void remove(Entity entity) {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        session.close();
    }

    public Entity findById(ID id) {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        Entity entity = session.get(getEntityClass(), id);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public <Atribute> Entity findByAtribute(Atribute valueAtribute, String nameAtribute) {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "from " + getEntityClass().getName() + " where " + nameAtribute + "= ?1 ";
        Query<Entity> query = session.createQuery(sql);
        query.setParameter(1, valueAtribute);
        Entity entity = (Entity) query.list().get(0);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public List<Entity> findAll() {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        Query<Entity> query = session.
                createQuery("from " + getEntityClass().getName());
        List<Entity> entities = query.list();
        session.getTransaction().commit();
        session.close();
        return entities;
    }

    public List<Entity> findAll(ID start, ID row) {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        Query<Entity> query = session.createQuery("from " + getEntityClass().getName());
        query.setFirstResult((Integer) start);
        query.setMaxResults((Integer) row);
        List<Entity> entities = query.list();
        session.getTransaction().commit();
        session.close();
        return entities;
    }

    // find all with predicate:
    public List<Entity> findAll(Predicate<Entity> predicate) {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        Query<Entity> query = session.
                createQuery("from " + getEntityClass().getName());
        List<Entity> entities = query.list().stream().filter(predicate).collect(Collectors.toList());
        session.getTransaction().commit();
        session.close();
        return entities;
    }

    public <AnotherEntity> List<AnotherEntity> findAll(Function<Entity, AnotherEntity> function) {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        Query<Entity> query = session.
                createQuery("from " + getEntityClass().getName());
        List<AnotherEntity> entities = query.list().stream().map(function).collect(Collectors.toList());
        session.getTransaction().commit();
        session.close();
        return entities;
    }


    public void removeById(ID id) {
        session = getSessionFactory().openSession();
        session.beginTransaction();
        Entity entity = session.get(getEntityClass(), id);
        if (entity != null) session.remove(entity);

        session.getTransaction().commit();
        session.close();
    }
}