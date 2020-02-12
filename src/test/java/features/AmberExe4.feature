Feature: Exercise 4

@new
Scenario:
    Given Uzytkownik wlacza strone "https://antycaptcha.amberteam.pl:5443/exercises/exercise4"
    When Uzytkownik wybiera pozycje z pierwszej grupy
    When Uzytkownik wybiera pozycje z drugiej grupy
    When Uzytkownik wybiera pozycje z trzeciej grupy
    When Uzytkownik wybiera pozycje z czwartej grupy
    When Uzytkownik klika przcisk potwierdzenia poprawnosci wyniku
    Then Uzytkownik uzyskuje potwierdzenie poprawnosci wyniku OK. Good answer