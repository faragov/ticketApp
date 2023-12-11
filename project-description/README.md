# Project Introduction

## Every project team member must read the project description

## Foxticket Full-Stack project

## Vision

The vision of the Foxticket project is to create an online travel ticket
application where users can read current travel news articles,
buy travel tickets from the shop with the help of a cart system.
Purchased tickets can be used up online and offline as a QR code.
The design and layout is not defined as it can change from project to project.

## Roles

There are three main roles in the project:

- Registered user: has a profile and a personal cart
- Admin: Manages the products, articles, users and purchased tickets
- Visitor: doesn't have an account on the page,
  but still can check out the news articles

## Definitions

| Name        | Description                                                                              |
| ----------- | ---------------------------------------------------------------------------------------- |
| Landing page | The main page of the application, the default view has news articles displayed           |
| Shop        | Buyable products listed in an orderly fasion                                             |
| Cart        | Before buying a product, users place them in the cart to buy them in bulk                |
| Profile     | Every user can edit their account information                                            |
| Purchases   | Every user can access their own purchased products                                       |
| Admin page  | Admins can list, add, edit and delete different entities                                 |

## Tasks for setup

### I've read the project description

---

### Development environment is set up

### Every project team member must have the development environment set up

### Acceptance Criteria

Each team member should be able to:

- Install all the necessary dependencies locally
- Run the application in local development environment
- Run all the unit and integration tests
- Run the linter locally
- Deploy a new version of the application

---

## Registration

### As a new User, I want to register to the application, so that I can use the app

![](./assets/Register/registerpage.png)

### Acceptance Criteria

Scenario 1:  
Given the /register route.  
When the page is loaded.  
Then the register form exists.

Scenario 2:  
Given the loaded register page.  
When I click on the submit button.  
And the input fields are blank.  
Then an error message shows up: "Name, email and password are required."

Scenario 3:  
Given the loaded register page.  
When I click on the submit button.  
And the email was taken.  
Then an error message shows up: "Email is already taken, choose another one."

Scenario 4:  
Given the loaded register page.  
When I click on the submit button.  
And the password is under 8 characters.  
Then an error message shows up: "Password must be at least 8 characters."

Scenario 5:  
Given the loaded register page.  
When I click on the submit button.  
And I give a name, unique email and minimum 8 character long password  
Then I am navigated to the /login page.

## Tasks for Registration

### Add routing to the frontend project

### Create the registration form

- Must have the required fields and buttons,
  can be extended with extra features.

### Form values are validated before sending the HTTP request

### Form values are validated after editing of a single field finished

### Send HTTP request upon form submit

## Registration backend

Must validate the name, password and the email:

- Full name: required, may not be an empty string
- Password: must be at least 8 characters long
- Email: required, must be unique

Request

`POST /register`

```json
{
  "name" : "Test Elek",
  "password" : "password123",
  "email" : "elek@test.com"
}
```

Response

`200` - If the request was successful

```json
{
  "id" : 1,
  "email" : "elek@test.com",
  "isAdmin": false,
  "isVerified": false
}
```

`400` - if the username, password or the name was not valid

### Create an endpoint test for the registration endpoint

### Create unit test for the registration form

### Create unit test for the validation on the backend

---

## Login

### As a User I'd like to be able to login to the app so that I can purchase tickets

![](./assets/Login/loginpage.png)

### Acceptance Criteria

Scenario 1:  
Given the /login route.  
When the page is loaded.  
Then the login form exists.

Scenario 2:  
Given the loaded login page.  
When I click on the submit button.  
And any input field is empty.  
Then an error message shows up: "All fields are required."

Scenario 3:  
Given the loaded login page.  
When I click on the submit button.  
And the email or password was wrong.  
Then an error message shows up: "Wrong email or password."

Scenario 4:  
Given the loaded login page.  
When I click on the submit button.  
And the user exists  
And the passwords match.  
Then I am logged in to the application  
And I am navigated to the main page.

## Tasks for Login

### Add routing to the frontend project

### Create the Login form

### Create the login endpoint

Provided a valid email and password returns a JWT token.

`POST /login`

Request

```json
{
  "email" : "test@elek.com",
  "password" : "password123"
}
```

Reponse

`200` - If the login was successful

```json
{
  "status" : "ok",
  "token" : "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZW5hbWUiOiJraXR0ZW4ifQ.QHKTRzU4hA-yzNqXbPHTVdYkoHP5CjllJr6XsN761k"
}
```

`400` - If the email or password were empty

`401` - If the email and password pair is incorrect

### Frontend saves and sends the access token with every HTTP request

### Backend validates the access token for every HTTP request

### Create a unit test for the login form

### Create an endpoint test for the login endpoint

---

## Header

### As a user, I want to see the page header, so I can navigate between Profile, Purchases, Register, Login pages and Logout

![](./assets/header.png)

### Acceptance Criteria

### Scenarios with user *logged in*

Scenario 1:  
Given all the loaded (Landing, Profile, Purchases) pages.  
When I click on the application's title.  
Then I am navigated to the landing page.

Scenario 2:  
Given all the loaded (Landing, Profile, Purchases) pages.  
When I click on the profile button.  
Then I am navigated to the profile page.

Scenario 3:  
Given all the loaded (Landing, Profile, Purchases) pages.  
When I click on the purchases button.  
Then I am navigated to the purchases page.

Scenario 4:  
Given all the loaded (Landing, Profile, Purchases) pages.  
When I click on the Logout.  
Then I am navigated to the Landing page.  
And the token is removed.

### Scenarios for *anonymous users*

Scenario 1:  
Given all the loaded (Landing, Login, Register) pages.  
When I click on the login button.  
Then I navigated to the login page.

Scenario 2:  
Given all the loaded (Login, Register) pages.  
When I click on the register button.  
Then I navigated to the register page.

Scenario 3:  
Given all the loaded (Landing, Login, Register) pages.  
When I click on the application's title.  
Then I am navigated to the landing page.

---

## Menu

### As a user I want to see a Menu on the Header, so i can open the shop and cart on the Landing page

![](./assets/menu.png)

### Acceptance Criteria

Scenario 1:  
GIVEN the loaded Landing page.  
WHEN I click on the shop button.  
Then the shop component is loaded.

Scenario 2:  
Given the loaded Landing page.  
AND loaded shop display  
WHEN I click on the shop button  
THEN the shop display is removed.

Scenario 3:  
Given the loaded Landing page  
When I click on the cart button.  
Then the cart display is loaded.

Scenario 4:  
Given the loaded Landing page  
AND loaded cart display  
WHEN I click on the cart button  
THEN the cart display is removed.

---

## Shop

### As a User I would like to see all purchasable products in the Shop

![](./assets/shop.png)

The two main product types are Ticket and Pass.

### Acceptance Criteria

Scenario 1:  
WHEN the Shop display is loaded  
AND "Tickets" tab is chosen  
THEN I can see the available tickets.

Scenario 2:  
WHEN the Shop display is loaded  
AND "Passes" tab is chosen  
THEN I can see the available passes.

## Tasks for Shop

### Shop frontend

### Shop backend GET /products

**Request**

`GET /products`

**Response**

```json
{
  "products" : [
    {
      "id" : 1,
      "name" : "Day ticket",
      "price": 360,
      "duration": 24,
      "description": "You can use this ticket for a whole day!",
      "type": "ticket"
    },
    {
      "id" : 2,
      "name" : "2 Day ticket",
      "price": 700,
      "duration": 48,
      "description": "You can use this ticket for a 2 day!",
      "type": "ticket"
    }
  ]
}
```

#### Create a frontend unit test for the Shop component

#### Create an endpoint test for the products endpoint

---

## Cart

### As a User I want to see my cart which holds my pending orders. The cart's size should be displayed on the cart button as well

![](./assets/cart.png)

### Acceptance Criteria

Scenario 1:  
GIVEN the loaded landing page  
WHEN I click on the cart button  
THEN the cart component is loaded.

Scenario 2:  
GIVEN the loaded landing page  
WHEN the cart component is loaded  
THEN the user's pending orders are shown in the cart.

## Tasks for Cart

### Cart frontend

### Cart size indicator

### Cart backend

**Request**

`GET /cart`

**Response**

```json
{
  "orders": [
    {
      "id" : 1,
      "status": "pending",
      "orderDate": 1234569,
      "name": "One day ticket",
      "price": 390
    },
    {
      "id" : 3,
      "status": "pending",
      "orderDate": 1234569,
      "name": "Two day ticket",
      "price": 700
    }
  ]
}
```