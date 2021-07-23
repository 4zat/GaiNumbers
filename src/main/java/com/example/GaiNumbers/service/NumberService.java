package com.example.GaiNumbers.service;

import com.example.GaiNumbers.entity.Numbers;

import java.util.List;

public interface NumberService {

    List<String> findAllByNumbers();

    String findLast();

    void insertNumbers_value(String number);
}
