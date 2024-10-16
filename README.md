# POS System API

This API is designed to manage the core functionalities of a Point-of-Sale (POS) system, including customer, item, and order management. Built using the Spring Framework, it follows RESTful architecture principles.

## Features

- **Customer Management**: Add, update, delete, and retrieve customers.
- **Item Management**: Manage inventory by adding, updating, and deleting items, and retrieving item information.
- **Order Management**: Place and manage orders, and update item quantities after placing orders.

## Technologies Used

- **Framework**: Spring 
- **Database**: MySQL
- **ORM**: Hibernate (JPA)
- **JSON**: Jackson for request and response handling
- **Dependency Management**: Maven
- **Java Version**: 21

## API Endpoints

### Customer Endpoints

| Method | Endpoint                        | Description                |
|--------|----------------------------------|----------------------------|
| POST   | `/api/v1/customer`               | Add a new customer         |
| GET    | `/api/v1/customer/{id}`          | Get customer by ID         |
| PUT    | `/api/v1/customer`               | Update customer details    |
| DELETE | `/api/v1/customer/{id}`          | Delete a customer          |
| GET    | `/api/v1/customers`              | Get all customers          |

### Item Endpoints

| Method | Endpoint                        | Description                |
|--------|----------------------------------|----------------------------|
| POST   | `/api/v1/item`                   | Add a new item             |
| GET    | `/api/v1/item/{id}`              | Get item details by ID     |
| PUT    | `/api/v1/item`                   | Update item details        |
| DELETE | `/api/v1/item/{id}`              | Delete an item             |
| GET    | `/api/v1/items`                  | Get all items              |

### Order Endpoints

| Method | Endpoint                        | Description                |
|--------|----------------------------------|----------------------------|
| POST   | `/api/v1/order`                  | Place a new order          |
| GET    | `/api/v1/order/{id}`             | Get order details by ID    |
| GET    | `/api/v1/orders`                 | Get all orders             |


### License
This project is licensed under the MIT License. See the LICENSE file for details.

