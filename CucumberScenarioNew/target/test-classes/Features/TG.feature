
@TranslatorAndGrammer
Feature: Translater and Grammer Functionality
 

  @AdjectiveAndAdverb
  Scenario: check user learns about Adjectives and adverb  through grammer 
    Given user navigates to "https://dictionary.cambridge.org"
    When user click on the grammar 
    And user click on the adjectives and adverbs 
    Then user is able to learn about adjectives and adverbs

@Easilyconfusedwords
Scenario: check user learns about Easily confused words through grammer link
    Given user is in home page
    When user click on the Grammar link
    And user click on the Easily confused words link
    Then user is able to learn about Easily confused words
    
    @Nounspronounsanddeterminers 
Scenario: check user learns about Nouns, pronouns and determiners through grammer link
    Given user navigated to the Cambridge Dictionary website 
    When user click on the Grammar link
    And user click on the Nouns, pronouns and determiners link
    Then user is able to learn about Nouns, pronouns and determiners
    
    
    @Prepositionsandparticles
Scenario: check user learns about Prepositions and particles through grammer link
    Given user navigated to the Cambridge Dictionary website 
    When user click on the Grammar link
    And user click on the Prepositions and particles link
    Then user is able to learn about Prepositions and particles
    
    @UsingEnglish
  Scenario: check user learns about Using English through grammer link
    Given user navigated to the Cambridge Dictionary website
    When user click on the Grammar link
    And user click on the Using English link
    Then user is able to learn about Using English
    
    
    @Verbs
  Scenario: check user learns about Verbs through grammer link
    Given user navigated to the Cambridge Dictionary website
    When user click on the Grammar link
    And user click on the Verbs link
    Then user is able to learn about Verbs
    
     @WordsSentencesAndClauses
  Scenario: check user learns about Words,Sentences and Clauses through grammer link
    Given user navigated to the Cambridge Dictionary website
    When user click on the Grammar link
    And user click on the Words,Sentences and Clauses link
    Then user is able to learn about Words, sentences and clauses
    
    
    @translate
     Scenario: user translate a sentence from english to japanese
    Given user navigated to the Cambridge Dictionary website
    When user clicks on English to japanese traslation
    And search for sentence and get transalation
    
    
    
    
    