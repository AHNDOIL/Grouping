package com.AHNDOIL.Grouping.infra;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade { //현재 로그인한 사용자의 이름 가져오기

    public String getUserName(){ return SecurityContextHolder.getContext().getAuthentication().getName();}
}
