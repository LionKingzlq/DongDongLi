package com.ddl.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.*;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static final Logger logger = LoggerFactory.getLogger(MySecurityMetadataSource.class);

    private static Map<String,Collection<ConfigAttribute>> resourceMap = null;

    public MySecurityMetadataSource(){
        logger.info("constructor mySecurity");
        loadResourceDefine();
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();

        while(ite.hasNext()){
            String resURL = ite.next();

            if(url.equalsIgnoreCase(resURL)){
                return resourceMap.get(resURL);
            }

        }

        return null;
    }

    private void loadResourceDefine(){
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();

        ConfigAttribute ca = new SecurityConfig("ROLE_ADMIN");

        atts.add(ca);
        resourceMap.put("/user.jsp", atts);
        resourceMap.put("/admin.jsp", atts);
        resourceMap.put("/index.jsp",atts);
        resourceMap.put("/admin",atts);

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
