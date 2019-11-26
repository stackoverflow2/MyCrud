package com.mobiliya.springdemo.Mycrud.dao;


import com.mobiliya.springdemo.Mycrud.entity.Machine;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MachineDaoHibernateImpl implements MachineDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Machine> findAll() {

        Session currentsession = entityManager.unwrap(Session.class);

        Query<Machine> theQuery = currentsession.createQuery("from Machine",Machine.class);

        List<Machine> machines = theQuery.getResultList();

        return machines;

    }

    @Override
    public Machine getMachine(int theId) {

        Session curreSession = entityManager.unwrap(Session.class);
        Machine machine = curreSession.get(Machine.class,theId);
        return machine;
    }

    @Override
    public void deleteMachine(int theId) {

        Session currentSession  = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Machine where id=:theid");

        theQuery.setParameter("theid",theId);
        theQuery.executeUpdate();

    }

    @Override
    public void updateMachine(Machine theMachine) {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theMachine);

    }

    @Override
    public void addMachine(Machine theMachine) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(theMachine);
    }
}
