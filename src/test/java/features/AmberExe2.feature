Feature: Exercise 2


Scenario:
    Given Uzytkownik jest na stronie "https://antycaptcha.amberteam.pl:5443/exercises/exercise2"
    When Uzytkownik wpisuje tekst do pola
    And Uzytkownik klika w przycisk B1
    And Uzytkownik klika przcisk uzyskania rozwiazania
    Then Uzytkownik widzi OK. Good answer