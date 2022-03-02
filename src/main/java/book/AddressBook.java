package book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class AddressBook {
    @OneToMany (cascade = CascadeType.ALL)
    private List<BuddyInfo> infos;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    public AddressBook() {
        this.infos = new ArrayList<BuddyInfo>();
    }

    /**
     * Gets the id of this Team.
     *
     * @return the id
     *@Id
    @GeneratedValue */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Team to the specified value.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void addBuddy(BuddyInfo aBuddyInfo) {

        if (aBuddyInfo != null) {
            this.infos.add(aBuddyInfo);
        }
    }

    public BuddyInfo removeBuddy(int index) {

        if (index >= 0 && index < this.infos.size()) {
            return this.infos.remove(index);
        }
        return null;
    }

    public String toString() {
        String returnme = "";
        for (BuddyInfo bud : infos) {
            returnme += bud.toString() + "\n";
        }
        return returnme;
    }

    public int size() {
        int i = 0;

        for (BuddyInfo bud : infos) {
            i++;
        }
        return i;
    }

    public void setInfos(List<BuddyInfo> aBuddyInfo) {
        this.infos = aBuddyInfo;
    }


    public List<BuddyInfo> getInfos() {
        return infos;
    }

}