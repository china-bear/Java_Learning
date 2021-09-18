/*
 * The MIT License
 * Copyright © 2014-2021 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package customer;

import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Data Access Object (DAO) is an object that provides an abstract interface to some type of
 * database or other persistence mechanism. By mapping application calls to the persistence layer,
 * DAO provide some specific data operations without exposing details of the database. This
 * isolation supports the Single responsibility principle. It separates what data accesses the
 * application needs, in terms of domain-specific objects and data types (the public interface of
 * the DAO), from how these needs can be satisfied with a specific DBMS.
 *
 * <p>With the DAO pattern, we can use various method calls to retrieve/add/delete/update data
 * without directly interacting with the data source. The below example demonstrates basic CRUD
 * operations: select, add, update, and delete.
 */

public class App {
  public static final Logger LOGGER = getLogger(App.class);
  private static final String ALL_CUSTOMERS = "customerDao.getAllCustomers(): ";

  /**
   * Program entry point.
   *
   * @param args command line args.
   * @throws Exception if any error occurs.
   */
  public static void main(final String[] args) throws Exception {

    final CustomerDao inMemoryDao = new InMemoryCustomerDao();
    performOperationsUsing(inMemoryDao);

    createSchema();
    final CustomerDao dbDao = new DbCustomerDao();
    performOperationsUsing(dbDao);
    deleteSchema();
  }

  private static void deleteSchema() throws SQLException {
    try (Connection connection = JdbcUtil.getConnnect();
         Statement statement = connection.createStatement()) {
      statement.execute(CustomerSchemaSql.DELETE_SCHEMA_SQL);
    }
  }

  private static void createSchema() throws SQLException {
    try (Connection connection = JdbcUtil.getConnnect();
         Statement statement = connection.createStatement()) {
      statement.execute(CustomerSchemaSql.CREATE_SCHEMA_SQL);
    }
  }

  private static void performOperationsUsing(final CustomerDao customerDao) throws Exception {
    addCustomers(customerDao);
    LOGGER.info(ALL_CUSTOMERS);

    try (Stream<Customer> customerStream = customerDao.getAll()) {
      customerStream.forEach(customer -> LOGGER.info(customer.toString()));
    }
    LOGGER.info("customerDao.getCustomerById(2): " + customerDao.getById(2));
    final Customer customer = new Customer(4, "Dan", "Danson");
    customerDao.add(customer);
    LOGGER.info(ALL_CUSTOMERS + customerDao.getAll());
    customer.setFirstName("Daniel");
    customer.setLastName("Danielson");
    customerDao.update(customer);
    LOGGER.info(ALL_CUSTOMERS);
    try (Stream<Customer> customerStream = customerDao.getAll()) {
      customerStream.forEach(cust -> LOGGER.info(cust.toString()));
    }
    customerDao.delete(customer);
    LOGGER.info(ALL_CUSTOMERS + customerDao.getAll());
  }

  private static void addCustomers(CustomerDao customerDao) throws Exception {
    for (Customer customer : generateSampleCustomers()) {
      customerDao.add(customer);
    }
  }

  /**
   * Generate customers.
   *
   * @return list of customers.
   */
  public static List<Customer> generateSampleCustomers() {
    final Customer customer1 = new Customer(1, "Adam", "Adamson");
    final Customer customer2 = new Customer(2, "Bob", "Bobson");
    final Customer customer3 = new Customer(3, "Carl", "Carlson");
    return Arrays.asList(customer1, customer2, customer3);
  }
}
