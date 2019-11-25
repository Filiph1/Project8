import java.util.Comparator;


public class NameComparator implements Comparator<Name> {

    public int compare(Name s1, Name s2) {

        if (s1.getPriority() < s2.getPriority())
            return 1;
        else if (s1.getPriority() > s2.getPriority())
            return -1;
        else {
            int compare = s1.getName().compareTo(s2.getName());
            if (compare < 0) {

                return -3;
            } else if (compare > 0) {

                return 2;

            } else {
                return -4;
            }

        }

    }
}

