# Sun_base_Data_Assignment# Customer Management System

![GitHub](link)

## Description

This project implements a Customer Management System that integrates with a set of APIs to perform various operations such as authentication, creating, updating, listing, and deleting customers. The APIs are provided by the backend service at https://qa2.sunbasedata.com/sunbase/portal/api.

The project is designed to have a basic UI in HTML that allows users to perform the following actions:

1. **Login**: Users can authenticate themselves using their login credentials to obtain a bearer token. This token is required for subsequent API calls.

2. **View Customer List**: After successful authentication, the user can view the list of existing customers fetched from the backend service.

3. **Create Customer**: Users can add a new customer to the system by providing mandatory details such as first name and last name.

4. **Update Customer**: Users can update the information of an existing customer by providing the unique identifier (UUID) and updated details.

5. **Delete Customer**: Users can remove a customer from the system by providing a unique identifier (UUID).

## API Endpoints

[Complete API documentation](./API.md)

## Basic Steps to Use the Application

1. Use a tool like Postman to test the provided APIs before integrating them with the UI.

2. Clone the repository and open the `index.html` file in a web browser to access the application.

3. Enter login credentials and click on the login button to authenticate.

4. Once logged in, the customer list will be displayed.

5. To create a new customer, click on the "Create Customer" button, enter customer details, and click on the "Submit" button.

6. To update a customer, click on the "Update Customer" button, select a customer from the list, update the details, and click on the "Save" button.

7. To delete a customer, click on the "Delete Customer" button, select a customer from the list, and click on the "Delete" button.

## How to Contribute

Contributions are welcome! Here's how you can contribute to the project:

1. Fork the repository and create your branch: `git checkout -b feature/new-feature`.

2. Commit your changes: `git commit -m 'Add some new feature'`.

3. Push to your branch: `git push origin feature/new-feature`.

4. Create a pull request.


