package com.mrogotnev.jdbc_jpa_spring.services;

import com.mrogotnev.jdbc_jpa_spring.dao.DeleteAndInitTestDataDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeleteAndInitTestDataService {
    private DeleteAndInitTestDataDao deleteAndInitTestDataDao;

    public void deleteAndInitTestData() {
        deleteAndInitTestDataDao.deleteAndInitTestData();
    }
}
