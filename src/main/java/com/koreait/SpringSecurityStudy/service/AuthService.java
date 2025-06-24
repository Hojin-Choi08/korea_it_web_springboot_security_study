package com.koreait.SpringSecurityStudy.service;

import com.koreait.SpringSecurityStudy.dto.ApiRespDto;
import com.koreait.SpringSecurityStudy.dto.SignUpReqDto;
import com.koreait.SpringSecurityStudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApiRespDto<?> addUser(SignUpReqDto signUpReqDto) {
        int result = userRepository.addUser(signUpReqDto.toEntity(bCryptPasswordEncoder));
        return new ApiRespDto<>("success", "회원가입 성공", result);
    }

}
