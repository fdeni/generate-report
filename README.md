# Welcome to Report Module!

Report Module is an simple API designed to generate report.


# Prerequisite :
- Java version 17
- Docker
- Docker Compose

# How to Run the Project :

1. Clone this repository.

2. Go to terminal and go to this repository.

3. Make sure your local device installed with Docker and Docker Compose.

4. Run `docker-compose up`

5. Wait for a while to setup the Loan Account Module, before start to use the API.

6. Run database script and make sure the data already there.

7Run this url in postman :
- Loan Account API `baseUrl`: `http:/localhost:8080/`

8To kill the Apps `CTRL + C`

# API Documentation
### Calculate Loan Endpoint :
### Register: `{baseUrl}/api/genereate-report`
### Method : POST

**Request Body:**
```json
{
  "startDate": "2024-01-01",
  "endDate": "2024-03-01"
}
```
**Response Success:**
```json
{
  "data": [
    {
      "no": 1,
      "productId": 1,
      "productName": "Eiger",
      "productType": "hand bag",
      "price": 2.0E7,
      "margin": 200000.0
    },
    {
      "no": 2,
      "productId": 2,
      "productName": "Rown",
      "productType": "ransel",
      "price": 3.0E7,
      "margin": 300000.0
    },
    {
      "no": 3,
      "productId": 3,
      "productName": "Rebook",
      "productType": "tote bag",
      "price": 2.5E7,
      "margin": 250000.0
    },
    {
      "no": 4,
      "productId": 1,
      "productName": "Eiger",
      "productType": "hand bag",
      "price": 2.7E7,
      "margin": 270000.0
    },
    {
      "no": 5,
      "productId": 2,
      "productName": "Rown",
      "productType": "ransel",
      "price": 2.85E7,
      "margin": 285000.0
    }
  ],
  "error": null,
  "status": 200
}
```

**Response Failed:**
```json
{
  "data": null,
  "error": "Invalid Period",
  "status": 500
}
```




