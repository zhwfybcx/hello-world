package com.changcai.statistics.dal.dao;

import com.zwf.cms.Application;
import com.zwf.cms.core.service.UserCoreService;
import com.zwf.cms.model.CmsProperties;
import com.zwf.cms.model.FtpProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by user on 2017/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class userDaoTest {
    @Autowired
    private UserCoreService userCoreService;

    @Autowired
    private CmsProperties cmsProperties;

    @Autowired
    private FtpProperties ftpProperties;

    @Test
    public void testUser() {
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
         long count = userDAO.getByDateCount("2017-03-13");
         System.out.println(count);*/
        /*System.out.println(userCoreService.getByUserCount());*/
        System.out.println(cmsProperties.getAdmin());
        System.out.println(ftpProperties.getHost());
    }
}
