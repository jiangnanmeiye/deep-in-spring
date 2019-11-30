package com.tomingdom.spring.jdbc;

import com.tomingdom.spring.jdbc.config.EmbeddedJdbcConfig;
import com.tomingdom.spring.jdbc.dao.SingerDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class JdbcCfgTest {
    @Test
    public void testH2DB() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
        testDao(ctx.getBean(SingerDao.class));
        ctx.close();
    }

    private void testDao(SingerDao singerDao) {
        assertNotNull(singerDao);
        String singerName = singerDao.findNameById((long) 1);
        assertEquals("liu hao", singerName);
    }
}
