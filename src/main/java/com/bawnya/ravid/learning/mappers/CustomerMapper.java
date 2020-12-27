package com.bawnya.ravid.learning.mappers;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.bawnya.ravid.learning.persistance.entity.Customer;
import com.bawnya.ravid.learning.resources.CustomerResource;

@Mapper(implementationPackage = "com.bawnya.ravid.learning.mappers", unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {

	public CustomerResource mapCustomerEntityToResource(Customer customerEntity);

	public Customer mapCustomerResourceToEntity(CustomerResource customerResource);

	@IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL )
	public List<CustomerResource> mapCustomerEntityToResource(List<Customer> customerEntity);

}
