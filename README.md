Parking lot

I own a parking lot that can hold up to 'n' cars at any given point in time. Each slot is given a

number starting at 1 increasing with increasing distance from the entry point in steps of

one. I want to create an automated ticketing system that allows my customers to use my

parking lot without human intervention.

 

Feature 1 :

Park : Allocate a slot, record the registration number, slot and color of the car

 

Feature 2 :

Seek : Given a slot number, I should be able to get the details of the car

 

What we are interested in:

1. Design thinking, conceptualizing the solution, clarity of thought

2. Code crafting, attention to details, syntax, maintainability

3. Completeness, code coverage, test cases and mocks (if required)

4. Abstracting hairy details and providing a simple elegant way to access / run

5. Clear documentation to access / run

 

Interactive, command based access to the solution

 For example :

• Creating a parking lot : create_parking_lot 10 à Should create a lot with 10 slots

• Park : park KA-01-MH-1234 white à Should park a car desired car in the available slot

• Seek : seek 1 à Details of the car parked in the slot 1
