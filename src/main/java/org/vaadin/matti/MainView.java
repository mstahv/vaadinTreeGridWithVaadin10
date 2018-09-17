package org.vaadin.matti;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.Route;
import java.util.Arrays;
import java.util.List;

/**
 * The main view contains a button and a click listener.
 */
@Route
public class MainView extends VerticalLayout {
    
    public static class Person {
        private String name;
        private Person parent;

        public String getName() {
            return name;
        }

        public Person getParent() {
            return parent;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setParent(Person parent) {
            this.parent = parent;
        }

        public Person(String name, Person parent) {
            this.name = name;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return name;
        }
        
    }

    public MainView() {
        TreeGrid<Person> grid = new TreeGrid<>(Person.class);
        grid.setHierarchyColumn("name");
        
        Person dad = new Person("dad", null);
        Person son = new Person("son", dad);
        Person daughter = new Person("daughter", dad);
        List<Person> all = Arrays.asList(dad, son, daughter);
        
        all.forEach(p -> grid.getTreeData().addItem(p.getParent(), p));
        
        add(grid);
        
    }
}
