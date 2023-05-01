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

To run unit tests it suffice to run the maven build or by running the class GildedRose test.

## Analysis

Based on the requirements we need to handle the quality of an item based on conditions.
To do so and to handle the conditions in a performant, better code readability and code maintenance,
I chose to use the Chain of responsibility design pattern.
