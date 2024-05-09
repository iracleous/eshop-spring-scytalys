package com.scytalys.eshop.mapper;

import com.scytalys.eshop.dto.EmployeeDto;
import com.scytalys.eshop.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring"   )
public interface EshopMapper {

    EmployeeDto toEmployeeDto(Employee employee);
    Employee toEmployee(EmployeeDto employeeDto);
}


