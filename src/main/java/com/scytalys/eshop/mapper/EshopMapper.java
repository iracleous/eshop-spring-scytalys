package com.scytalys.eshop.mapper;

import com.scytalys.eshop.dto.EmployeeDto;
import com.scytalys.eshop.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring"  )
@MapperConfig(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EshopMapper {

    @Mapping(target = "officialName",source = "firstName")
    @Mapping(target = "familyName",source = "lastName")
    EmployeeDto toEmployeeDto(Employee employee);

    @Mapping(target = "firstName",source = "officialName")
    @Mapping(target = "lastName",source = "familyName")
    Employee toEmployee(EmployeeDto employeeDto);
}


