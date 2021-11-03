import java.lang.module.ModuleDescriptor.Builder;

public class Person {
    private String imie;
    private String nazwisko;
    private int wiek;
    private int wzrost;
    private int waga;

    private Person() {
    }

    public int wiek() {
    return wiek;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " wiek:" + wiek + " wzrost :" + wzrost + " waga:" + waga;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || o.getClass() != getClass())
            return false;
        Person p = (Person) o;
        return (imie == p.imie && nazwisko == p.nazwisko && wiek == p.wiek && wzrost == p.wzrost && waga == p.waga);
    }

    public static final class Builder {
        private String imie;
        private String nazwisko;
        private int wiek;
        private int wzrost;
        private int waga;

        public Builder firstName(String imie) {
            this.imie = imie;
            return this;
        }

        public Builder lastName(String nazwisko) {
            this.nazwisko = nazwisko;
            return this;
        }

        public Builder age(int wiek) {
            this.wiek = wiek;
            return this;
        }

        public Builder height(int wzrost) {
            this.wzrost = wzrost;
            return this;
        }

        public Builder weight(int waga) {
            this.waga = waga;
            return this;
        }

        public Person build() {
            if (imie == null || nazwisko == null || wiek == 0 || waga == 0 || wzrost == 0) {
                System.out.println("Blad");
                return null;
            }
            Person person = new Person();
            person.imie = this.imie;
            person.nazwisko = this.nazwisko;
            person.wiek = this.wiek;
            person.waga = this.waga;
            person.wzrost = this.wzrost;
            return person;
        }

    }

}
