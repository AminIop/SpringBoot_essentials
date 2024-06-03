package edu.demo.Ecom_app.tools.mappers;

import edu.demo.Ecom_app.entities.Address;
import edu.demo.Ecom_app.tools.dtos.address.AddressDto;

public class AddressMapper {
    public static Address fromAddressDtoToAddress(AddressDto addressDto){
        /*Address address = new Address();
        BeanUtils.copyProperties(addressDto, address);
        return address;*/
        // another way to copy properties using builder pattern
        return new Address().builder()
                .street(addressDto.getStreet())
                .city(addressDto.getCity())
                .country(addressDto.getCountry())
                .build();
    }
}
