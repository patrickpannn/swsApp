# SwsCompany Stock Management API

## Overview
This is a Spring Boot application that manages stock data for companies. The primary functionality of the application is exposed via the `SwsCompanyController` REST API, which allows clients to retrieve detailed information about various companies, including stock prices and company scores.

The backend architecture includes entities such as `SwsCompany`, `SwsCompanyScore`, and `SwsCompanyPriceClose`, which are mapped to a database using JPA. The application retrieves company data from a repository, processes it through services, and exposes it via REST endpoints.

## Features
- Retrieve a list of companies and their associated details (such as stock prices and scores).
- Optional query parameter to include or exclude stock prices in the response.
- Handles potential errors and returns meaningful HTTP status codes.

## Endpoints
### `GET /SwsCompanies`
Retrieves a list of companies with their details. The response can optionally include the latest stock prices for each company.

#### Query Parameters:
- `prices` (Optional): Boolean flag to include stock prices in the response. Default is `false`.