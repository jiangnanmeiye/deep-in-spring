package com.tomingdom.spring.hibernate;

import com.tomingdom.spring.hibernate.dao.SingerDao;
import com.tomingdom.spring.hibernate.entities.Album;
import com.tomingdom.spring.hibernate.entities.Instrument;
import com.tomingdom.spring.hibernate.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class SpringHibernateDemo {
    private static Logger logger = LoggerFactory.getLogger(SpringHibernateDemo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        SingerDao singerDao = ctx.getBean(SingerDao.class);
        listSingers(singerDao.findAll());
        listSingersWithAlbum(singerDao.findAllWithAlbum());
    }

    private static void listSingers(List<Singer> singers) {
        logger.info("----- Listing singers:");
        for (Singer singer: singers) {
            logger.info(singer.toString());
        }
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
        logger.info("---------- Listing singers with instruments:");
        for (Singer singer: singers) {
            logger.info(singer.toString());
            if (singer.getAlbums() != null) {
                for (Album album: singer.getAlbums()) {
                    logger.info("\t" + album.toString());
                }
            }
            if (singer.getInstruments() != null) {
                for (Instrument instrument: singer.getInstruments()) {
                    logger.info("\t" + instrument.toString());
                }
            }
        }
    }
}
