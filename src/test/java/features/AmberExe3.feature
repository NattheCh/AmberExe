Feature: Exercise 3

@new
Scenario:
    Given Uzytkownik otwiera strone "https://antycaptcha.amberteam.pl:5443/exercises/exercise3"
    When Uzytkownik wybiera pozycje z listy
    And Uzytkownik klika przcisk potwierdzenia rozwiazania
    Then Uzytkownik uzyskuje potwierdzenie OK. Good answer