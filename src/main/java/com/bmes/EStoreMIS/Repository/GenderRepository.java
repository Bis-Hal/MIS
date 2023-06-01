package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.models.lookUps.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GenderRepository extends JpaRepository<Gender, UUID> {
    Gender findGenderIdByGender(String gender);

//    UUID findByGender(String gender);
}
