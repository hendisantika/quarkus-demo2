package com.hendisantika.customer;

import org.mapstruct.Mapper;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-demo2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/01/22
 * Time: 20.15
 */
@Mapper(componentModel = "cdi")
public interface CustomerMapper {

    CustomerEntity toEntity(Customer domain);

    Customer toDomain(CustomerEntity entity);
}
