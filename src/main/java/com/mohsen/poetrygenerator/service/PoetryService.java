package com.mohsen.poetrygenerator.service;

import com.mohsen.poetrygenerator.dto.PoetryDto;

public interface PoetryService {

    String getRobotHaiku();

    PoetryDto getPoetryByGenreAndTheme(String genre, String theme);

}
