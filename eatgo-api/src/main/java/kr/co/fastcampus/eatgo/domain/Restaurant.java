package kr.co.fastcampus.eatgo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

    @Transient
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Restaurant() {
    }
    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getInformation() {
        return name + " in " + address;
    }

    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        for(MenuItem menuItem :menuItems) {
            addMenuItem(menuItem);
        }
    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
