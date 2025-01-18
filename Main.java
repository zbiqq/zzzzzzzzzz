import java.util.*;

class PerfumeStoreApp {

    // Klasa reprezentująca perfumy
    static class Perfume {
        private int id;
        private String name;
        private String brand;
        private double price;

        public Perfume(int id, String name, String brand, double price) {
            this.id = id;
            this.name = name;
            this.brand = brand;
            this.price = price;
        }

        // Gettery i settery
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Perfume{id=" + id + ", name='" + name + "', brand='" + brand + "', price=" + price + '}';
        }
    }

    // Klasa zarządzająca perfumami
    static class PerfumeStore {
        private Map<Integer, Perfume> perfumes;
        private int nextId;

        public PerfumeStore() {
            perfumes = new HashMap<>();
            nextId = 1; // ID zaczynamy od 1
        }

        // Dodanie perfum (Create)
        public void addPerfume(String name, String brand, double price) {
            Perfume perfume = new Perfume(nextId++, name, brand, price);
            perfumes.put(perfume.getId(), perfume);
        }

        // Wyświetlanie wszystkich perfum (Read)
        public void showAllPerfumes() {
            if (perfumes.isEmpty()) {
                System.out.println("Brak perfum w sklepie.");
            } else {
                perfumes.values().forEach(System.out::println);
            }
        }

        // Edytowanie perfum (Update)
        public boolean updatePerfume(int id, String name, String brand, double price) {
            Perfume perfume = perfumes.get(id);
            if (perfume != null) {
                perfume.setName(name);
                perfume.setBrand(brand);
                perfume.setPrice(price);
                return true;
            }
            return false;
        }

        // Usuwanie perfum (Delete)
        public boolean deletePerfume(int id) {
            if (perfumes.containsKey(id)) {
                perfumes.remove(id);
                return true;
            }
            return false;
        }

        // Pobranie perfum po ID
        public Perfume getPerfumeById(int id) {
            return perfumes.get(id);
        }
    }

    // Główna klasa aplikacji
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PerfumeStore store = new PerfumeStore();
        boolean running = true;

        while (running) {
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Dodaj perfumy");
            System.out.println("2. Wyświetl wszystkie perfumy");
            System.out.println("3. Edytuj perfumy");
            System.out.println("4. Usuń perfumy");
            System.out.println("5. Zakończ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Podaj nazwę perfum: ");
                    String name = scanner.nextLine();
                    System.out.print("Podaj markę perfum: ");
                    String brand = scanner.nextLine();
                    System.out.print("Podaj cenę perfum: ");
                    double price = scanner.nextDouble();
                    store.addPerfume(name, brand, price);
                    System.out.println("Perfumy zostały dodane.");
                    break;

                case 2:
                    store.showAllPerfumes();
                    break;

                case 3:
                    System.out.print("Podaj ID perfum do edycji: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    Perfume perfume = store.getPerfumeById(updateId);
                    if (perfume != null) {
                        System.out.print("Podaj nową nazwę perfum: ");
                        String newName = scanner.nextLine();
                        System.out.print("Podaj nową markę perfum: ");
                        String newBrand = scanner.nextLine();
                        System.out.print("Podaj nową cenę perfum: ");
                        double newPrice = scanner.nextDouble();
                        store.updatePerfume(updateId, newName, newBrand, newPrice);
                        System.out.println("Perfumy zostały zaktualizowane.");
                    } else {
                        System.out.println("Nie znaleziono perfum o takim ID.");
                    }
                    break;

                case 4:
                    System.out.print("Podaj ID perfum do usunięcia: ");
                    int deleteId = scanner.nextInt();
                    if (store.deletePerfume(deleteId)) {
                        System.out.println("Perfumy zostały usunięte.");
                    } else {
                        System.out.println("Nie znaleziono perfum o takim ID.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Koniec programu.");
                    break;

                default:
                    System.out.println("Niepoprawny wybór, spróbuj ponownie.");
            }
        }
        scanner.close();
    }
}
// Jak działa program?
//Dodanie perfum – umożliwia użytkownikowi dodanie nowych perfum, przypisując im unikalne ID.
//Wyświetlanie perfum – pokazuje listę wszystkich dostępnych perfum w sklepie.
//Edycja perfum – pozwala na edytowanie szczegółów perfum (np. zmiana nazwy, marki, ceny) na podstawie ID.
//Usuwanie perfum – umożliwia usunięcie perfum na podstawie ID.
//Zakończenie programu – kończy działanie aplikacji.
//Program działa w konsoli i pozwala użytkownikowi na interakcję przy pomocy numerowanych opcji.