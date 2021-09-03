package com.example.GaiNumbers.service;

import com.example.GaiNumbers.repo.NumberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberService {

    private final NumberRepository numberRepository;

    public NumberService(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    public List<Integer> findAllByNumberId() {
        return numberRepository.findAllByNumberId();
    }

    public Integer findByLastId() {
        return numberRepository.findByLastId();
    }

    public List<String> findAllByNumbers() {
        return numberRepository.findAllByNumbers();
    }

    public String findLast() {
        return numberRepository.findLast();
    }

    public void insertNumbersValue(Integer id, String number) {
        numberRepository.insertNumbersValue(id, number);
    }
}
