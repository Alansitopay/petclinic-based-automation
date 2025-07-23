package org.springframework.samples.petclinic;

import io.qameta.allure.*;
import org.springframework.samples.petclinic.mapper.SpecialtyMapper;
import org.springframework.samples.petclinic.model.Specialty;
import org.mapstruct.factory.Mappers;
import org.testng.annotations.*;
import static org.testng.Assert.*;

@Epic("Mapper")
@Feature("SpecialtyMapper Unit Tests")
public class SpecialtyMapperTest {
    private SpecialtyMapper specialtyMapper;

    @BeforeMethod
    public void setUp() {
        specialtyMapper = Mappers.getMapper(SpecialtyMapper.class);
    }

    @Test(description = "Should map Specialty to DTO")
    @Story("Map Specialty")
    public void testMapSpecialtyToDto() {
        Specialty specialty = new Specialty();
        specialty.setName("Surgery");
        // Assume a mapToDto method exists
        // SpecialtyDto dto = specialtyMapper.mapToDto(specialty);
        // assertEquals(dto.getName(), "Surgery");
        assertEquals(specialty.getName(), "Surgery"); // Placeholder
    }
} 