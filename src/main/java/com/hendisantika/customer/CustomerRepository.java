package com.hendisantika.customer;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-demo2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/01/22
 * Time: 20.16
 */
@ApplicationScoped
public class CustomerRepository implements PanacheRepositoryBase<CustomerEntity, Integer> {
}
