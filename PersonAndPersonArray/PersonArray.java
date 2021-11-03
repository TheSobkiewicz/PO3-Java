import java.util.Arrays;

public class PersonArray {
    Person list[] = new Person[0];
    int size = 0;

    public void addPerson(Person person) {
        if (person == null)
            System.out.println("Blad");
        else if (Arrays.asList(list).contains(person))
            System.out.println("Juz jest");
        else {

            size++;
            Person nlist[] = new Person[size];
            System.arraycopy(this.list, 0, nlist, 0, size - 1);
            nlist[size - 1] = person;
            list = nlist;
        }

    }

    public PersonArray(PersonArray personArray) {
        list = personArray.list.clone();
        size = personArray.size;

    }

    public PersonArray() {
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }

    public void removePerson(Person person) {
        int a = Arrays.asList(list).indexOf(person);
        if (a != -1) {
            size--;
            Person nlist[] = new Person[size];
            System.arraycopy(this.list, 0, nlist, 0, a);
            System.arraycopy(this.list, a + 1, nlist, a, size - a);
            list = nlist;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || o.getClass() != getClass())
            return false;
        PersonArray p = (PersonArray) o;
        return Arrays.equals(list, p.list);
    }

    public void sortByAge() {
        Arrays.sort(list, (x,y) -> x.wiek() - y.wiek() );
    }

}
