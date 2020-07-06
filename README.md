# REI SDET Homework Problem 

Program that finds all the English words of a given String and indicates if the string passed is an English word.


### Assumptions made in the exercise statement:

  * Search criteria word in lowercase.
  * Search criteria word without accents.
  * Search criteria word spaces.
  * Search criteria word in singular.
  * Json response in lowercase.
  * There aren't duplicate words in Json response.
  * Response simulation with most used English words.

### Mocked response for test

```json
[{
	"word": "working",
	"definition": "having work"
}, {
	"word": "kite",
	"definition": "a frame covered with cloth or plastic and joined to a long string, that you fly in the air when the weather is windy"
}, {
	"word": "work",
	"definition": "an activity"
}, {
	"word": "king",
	"definition": "the title of a male ruler of a country"
}, {
	"word": "staff",
	"definition": "the group of people who work for an organization"
}, {
	"word": "boat",
	"definition": "a ship"
}, {
	"word": "row",
	"definition": "a line of things"
}, {
	"word": "ring",
	"definition": "a circle of any material"
}, {
	"word": "cat",
	"definition": "a small animal with fur, four legs, a tail, and claws, usually kept as a pet or for catching mice"
}, {
	"word": "know",
	"definition": "to have information in your mind"
}, {
	"word": "wing",
	"definition": "the flat part of the body that a bird, insect, or bat uses for flying"
}, {
	"word": "strengths",
	"definition": "the ability to do things that need a lot of physical or mental effort"
}, {
	"word": "zoo",
	"definition": "an area in which animals, especially wild animals, are kept so that people can go and look at them or study them"
}]
```  

## Built with
 * Postman - Mock Server
 * HttpComponent - Rest Client
 * JUnit v.4 - Unit Testing
 * Hamcrest - Assertions
 * Gson - Json Parser
  
  
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposs

### Prerequisites

 * Java 8
 * Maven 3.6.3
 
### Clone

Clone this repo to your local machine using `git clone https://github.com/sergioamendava/ReiSdetHomework.git`
 
### Installing
`$ mvn clean install`
 
### Running the tests
`$ mvn clean test`

## How to use?
`isEnglishWord(String word)`
This function return a boolean depending on is a valid English word and it's available in the English words list returned by the dictionary web service.

`getMatchesWords(String word)`
Get a String list with all English words in a given string.
