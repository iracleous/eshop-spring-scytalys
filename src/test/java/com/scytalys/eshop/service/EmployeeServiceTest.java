package com.scytalys.eshop.service;

import com.scytalys.eshop.dto.EmployeeDto;
import com.scytalys.eshop.mapper.EshopMapper;
import com.scytalys.eshop.model.Employee;
import com.scytalys.eshop.repository.EmployeeRepository;
import com.scytalys.eshop.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    private Employee mockEmployee;
    private static final long employeeId = 1L;
    private static final String FIRSTNAME = "John";
    private static final String LASTNAME = "Doe";

    @Mock
    private EmployeeRepository employeeRepository;
    @Spy
    private EshopMapper eshopMapper = Mappers.getMapper(EshopMapper.class);
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        // Arrange
        mockEmployee = new Employee();
        mockEmployee.setId(employeeId);
        mockEmployee.setFirstName(FIRSTNAME);
        mockEmployee.setLastName(LASTNAME);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testGetEmployeeById() {
        Mockito.when(employeeRepository.findById(employeeId))
                .thenReturn(Optional.of(mockEmployee));
        EmployeeDto result = employeeService.getEmployee(employeeId);
        assertNotNull(result);
        assertEquals(employeeId, result.getId());
        assertEquals(FIRSTNAME, result.getOfficialName());
        assertEquals(LASTNAME, result.getFamilyName());
    }
}