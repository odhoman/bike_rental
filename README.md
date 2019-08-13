# bike_rental

This code implements differents kind of rental combos: Regular Rental and Family Rental.

## Rents


*Regular Rental:* A list of bikes rented, by hour, day or week. None especial concept is applied on this kind of rental.

*Family Rental:* A list of bikes rented, by hour, day or week. Theres is a 30% discount when is rented between 3 and 5 bikes.


## Design
### RentalCombo (class)

*RentalCombo* Is a list of Rental bikes
Each RentalCombo: 
* Has the list of rented bikes
* Has a validator manager that throws one or more error when the validation is executed.
* Returns the total price adding the amounts of each item.
* Return the final price applying different concepts to the total price.

### RentalItem (class)

The rental of one bicycle in the final rent.

Each rental bike has:
* Number of hours
* Rental Type (hour, day, week)
* The Bike selected (Bike1, Bike2,etc)

### ConceptAmountApplyer (class)
* Applies concepts to the total price. These concepts can lower or raise the price.
* Return a list of applicable concepts.


### ComboConceptAmountApplicable (class)
* Is the concept applicable to the total price.
* Returns the concept type name
* Returns the concept type description
* Calculates the porcentaje applicable 
* Return the amount to apply to the final price

### ComboValidationManager (class)
* Validates the bikes rental 
* Has a list of validators
* Executes all the validators
* Throws the error validations obtained 

### RentalComboValidator (class)
* Validates a condition in the rental 
* Throws a validation exception when this conditions occurs


### RentalService (class)
* Creates a new empty rental bikes
* Creates a new empty rental type
* Executes Rentals validations
* Adds a Rental bike to the rental combo

### Factories (classes)
* *RentalComboFactory:* Creates a new empty rental bikes by an Enum Parameter
* *RentalTypeFactory:* Creates a new rental type by an Enum Parameter


## Desing applied

### Validating Rental

The validator for *Regular Rental* throws an exception when the rental has 0 items

The validator for *Family Rental*:
* throws an exception when the combo has 0 items
* throws an exception when the items are not between 3 and 5.

### Family Rental Discount 

In this rent is applied a concept, reducing the total price 30%.
First the discount amount is obtained and then the discount is applied to the total price.

### Patters Applied
*Manager:* ComboValidationManager

*Delegator:* In RentalCombo class:
* The validation is delegated to ComboValidationManager. 
* The concepts to the total price is delegated to ConceptAmountApplyer

*Factory:* RentalComboFactory, RentalTypeFactory

*Service:* RentalService

## Best Practices
* Proper indentation
* Comments on main classes and methods
* Inspection of code quality (SonarLint)
* Over 85% coverage

## How to run the test
1. Configure Java 8 and maven in your environment.
2. Go to root project and execute:
```bash
 mvn test
```