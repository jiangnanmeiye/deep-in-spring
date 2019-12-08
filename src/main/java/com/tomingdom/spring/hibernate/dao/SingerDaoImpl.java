package com.tomingdom.spring.hibernate.dao;

import com.tomingdom.spring.hibernate.entities.Singer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("SingerDao")
@SuppressWarnings("unchecked")
public class SingerDaoImpl implements SingerDao {
    private static final Log logger = LogFactory.getLog(SingerDaoImpl.class);

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
    }

    @Override
    public List<Singer> findAllWithAlbum() {
        return sessionFactory.getCurrentSession().getNamedQuery("Singer.findAllWithAlbum").list();
    }

    @Override
    public Singer findById(Long id) {
        return (Singer) sessionFactory.getCurrentSession().getNamedQuery("Singer.findById").setParameter("id", id).uniqueResult();
    }

    @Override
    public Singer save(Singer singer) {
        sessionFactory.getCurrentSession().saveOrUpdate(singer);
        logger.info("Singer saved with id: " + singer.getId());
        return singer;
    }

    @Override
    public void delete(Singer singer) {
        sessionFactory.getCurrentSession().delete(singer);
        logger.info("Singer deleted with id: " + singer.getId());
    }
}
