package com.ddl.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

public class MyAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if(collection  == null){
            return ;
        }
        System.out.println(object.toString());
        Iterator<ConfigAttribute> ite = collection.iterator();
        while(ite.hasNext()){
            ConfigAttribute ca = ite.next();
            String needRole = ((SecurityConfig)ca).getAttribute();

            for(GrantedAuthority ga : authentication.getAuthorities()){
                if(needRole.equals(ga.getAuthority())){
                    return ;
                }
            }
        }
        throw new AccessDeniedException("no right");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }
}
