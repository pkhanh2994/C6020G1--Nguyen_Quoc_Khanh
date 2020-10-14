package com.example.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class EmailRegexImpl implements  EmailRegex{
    @Override
    public boolean regexEmail(String email) {
        Pattern pattern=Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }
}
