package com.example.GaiNumbers.service;

import com.example.GaiNumbers.entity.Numbers;
import com.example.GaiNumbers.repo.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberServiceIMPL implements NumberService {

    private final NumberRepository numberRepository;

    @Autowired
    public NumberServiceIMPL(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @Override
    public List<String> findAllByNumbers() {
        return numberRepository.findAllByNumbers();
    }

    @Override
    public String findLast() {
        return numberRepository.findLast();
    }

    @Override
    public void insertNumbers_value(String number) {
        numberRepository.insertNumbers_value(number);
    }
}
