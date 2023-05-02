# Gilded Rose starting position in Java

## Run the Text Fixture from Command-Line

```
./gradlew -q text
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew -q text --args 10
```

## Unit tests

To run unit tests it suffices to run the maven build or by running the class GildedRose test.

## Analysis

Based on the requirements we need to handle the quality of an item based on conditions and every conditions varies
depends on the type of the item.
To do so and to handle the conditions in a performant, better code readability and code maintenance,
I chose to use the Chain of responsibility design pattern.

## Questions and problems

* I noticed in some requirements are not respected by texttest, was texttest supposed to be updated part of the tests ?
* I wasn't sure if I was allowed to add maven dependencies, as for tests I would have used mockito, and I would have
  transformed the application to springboot application.
* It was mentioned that we can't change the item object, however I would have prefered to create an object for every
  type such as
    * AgedBrie
    * BackstagePass
    * Sulfuras
    * Conjured
    * NormalItem
