# ptbsDesignPatterns

Implemented Design Patterns:

1. Facade

2. Bridge

3. Iterator

4. Factory

5. Visitor

The UI is created and function works as follows:

A user is logged in

Main UI is generated hiding all functions behing and making simple UI (Facade class)- Facade

based on user, title of next UI window is decided (MenuUI, MenuUIBuyer)- Bridge

Then user enters the productType (ProductMenu, MeatProductMenu, ProduceProductMenu, Person, Buyer, Seller)- Factory

then iterator runs and fetches all products of that type (Product iterator, offering iterator) - Iterator

then we get an option to add a trade or see availble users trading on that
then select and output is displayed on command line

visitors are present for facade, trading and classproductlist (Trading, Facade, classProductList) - Visitor 

All commits are done on branch src. Commits can be visible in src

