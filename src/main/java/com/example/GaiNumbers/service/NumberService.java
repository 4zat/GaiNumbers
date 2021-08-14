package com.example.GaiNumbers.service;

import java.util.List;

public interface NumberService {

    List<String> findAllByNumbers();

    String findLast();

    void insertNumbers_value(String number);
}
