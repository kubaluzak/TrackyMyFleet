TrackyMyFleet
TrackyMyFleet to aplikacja do zarządzania flotą pojazdów, która umożliwia monitorowanie lokalizacji pojazdów w czasie rzeczywistym. Projekt składa się z dwóch głównych części: backendu opartego na Spring Boot (Java) oraz frontendowej aplikacji napisanej w Angularze. Aplikacja pozwala na zarządzanie pojazdami, edytowanie ich danych oraz śledzenie ich bieżącej lokalizacji na mapie.

Funkcjonalności
1. Zarządzanie pojazdami
Aplikacja umożliwia pobieranie listy pojazdów z backendu.
Użytkownicy mogą edytować dane pojazdów, takie jak nazwa, typ pojazdu itp.
Po zakończeniu edycji zmiany są zapisywane w bazie danych za pośrednictwem API backendu.
2. Śledzenie lokalizacji pojazdów
Aplikacja umożliwia wyświetlanie lokalizacji wybranego pojazdu na mapie.
Dane lokalizacji obejmują szerokość i długość geograficzną, które są wyświetlane na mapie przy pomocy biblioteki Leaflet.
3. Mapy
Z wykorzystaniem biblioteki Leaflet aplikacja wyświetla mapę, na której można zobaczyć aktualną lokalizację pojazdu.
Mapa zawiera markery wskazujące położenie pojazdów, umożliwiając śledzenie ich w czasie rzeczywistym.

Funkcjonalności planowane do wdrożenia

1. Rola Menedżera
Menedżer ma możliwość zarządzania tylko swoją flotą pojazdów. Oznacza to, że nie ma dostępu do pojazdów należących do innych menedżerów.
Menedżer może edytować dane swoich pojazdów oraz sprawdzać ich lokalizację.
Dostęp do funkcji zarządzania flotą jest możliwy tylko po poprawnej weryfikacji za pomocą JWT.
2. Rola Administratora
Administrator ma pełny dostęp do wszystkich pojazdów i użytkowników w systemie.
Administrator może zarządzać wszystkimi pojazdami, w tym przypisanymi do innych menedżerów.
Administrator może tworzyć, edytować i usuwać pojazdy, a także zarządzać użytkownikami (menedżerami).
Dostęp do funkcji administracyjnych jest możliwy po poprawnej weryfikacji za pomocą JWT.
3. Weryfikacja za pomocą JWT
Aplikacja korzysta z JSON Web Token (JWT) do weryfikacji tożsamości użytkowników.
Po zalogowaniu użytkownik otrzymuje token JWT, który jest używany do autoryzacji w dalszej komunikacji z API.
JWT zapewnia bezpieczeństwo i kontrolę dostępu do różnych zasobów aplikacji.

4. Historia trasy pojazdu
Wkrótce zostanie dodana funkcjonalność umożliwiająca wyświetlenie trasy, jaką pojazd przejechał w ciągu ostatnich 24 godzin.
Trasa pojazdu będzie przedstawiona na mapie, umożliwiając użytkownikom śledzenie, gdzie pojazd się poruszał w wybranym okresie.
Funkcja ta będzie dostępna zarówno dla menedżera, jak i administratora (w zależności od przypisania pojazdu).
5. Przeglądy techniczne pojazdów
Zostanie dodana możliwość zarządzania przeglądami technicznymi pojazdów.
Użytkownicy będą mogli zobaczyć daty przeglądów, a także ustawić przypomnienia o nadchodzących przeglądach.
Powiadomienia o nadchodzących przeglądach będą automatycznie wysyłane na adresy e-mail przypisanych użytkowników (np. menedżerów).
Użytkownicy będą otrzymywać powiadomienia na maile, jeśli termin przeglądu zbliża się do daty.
Funkcjonalność ta pozwoli na lepsze zarządzanie przeglądami pojazdów i zapewnienie ich odpowiedniego stanu technicznego.
7. Powiadomienia o lokalizacji pojazdów
W planach jest dodanie powiadomień o lokalizacji pojazdów, które będą wysyłane do odpowiednich menedżerów lub administratorów, jeśli pojazd opuści określoną strefę (np. wyjechał poza wyznaczoną lokalizację).
Będzie to umożliwiało szybsze reagowanie na nieprzewidziane sytuacje związane z pojazdami.
8. Monitorowanie aktualnego kierowcy pojazdu
Funkcja ta umożliwi wyświetlenie informacji o tym, który użytkownik (np. kierowca) aktualnie prowadzi dany pojazd.
Będzie to użyteczne w celu monitorowania, kto w danym momencie jest odpowiedzialny za pojazd, zwłaszcza w przypadku zarządzania dużą flotą.
