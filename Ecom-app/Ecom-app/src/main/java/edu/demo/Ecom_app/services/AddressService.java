package edu.demo.Ecom_app.services;

import edu.demo.Ecom_app.entities.Address;
import edu.demo.Ecom_app.tools.dtos.address.AddressDto;
import edu.demo.Ecom_app.tools.dtos.user.UserDtoRequest;
import edu.demo.Ecom_app.tools.dtos.user.UserDtoResponse;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    public Address AddAddress(AddressDto address);
    public Address AddAddressInternalVersion(Address address);
    public List<Address> findAllAddresses();
    public Optional<Address> findAddressById(int id);
    public boolean deleteAddressById(int id);
    public boolean updateAddress(int id,AddressDto address);
}
