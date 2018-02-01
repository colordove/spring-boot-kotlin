package com.example.hujian.girlkotlin.repository

import com.example.hujian.girlkotlin.domain.Girl
import org.springframework.data.jpa.repository.JpaRepository

public interface GirlRepository: JpaRepository<Girl, Int> {
}