# TreeGrid example for Vaadin 10

This is a simple example how to use (yet to be officially released) Vaadin TreeGrid with Vaadin 10 (LTS).

The difficult part, the dependency. You'll need to add explicit dependency to your component's flow integration, in this case vaadin-tree-grid-flow, and choose a latest version (which might or might not work with your current platform version, but here with 10 it works just fine). With many IDEs (at least with NetBeans), you can choose to explicitly add dependency to a transitive depenency, like vaadin-grid-flow. The use autocomplete on the version part to get the latest release (or use [mvnrepository](https://mvnrepository.com) or similar if you don't have proper tooling):


        <dependency>
            <groupId>com.vaadin</groupId>
            <artifactId>vaadin-grid-flow</artifactId>
            <version>1.1.1</version>
        </dependency>

The IDE might at this point complain about mismatch between bom version and the version that you declare, but trust yourself here.

The just use it! For this demo I created a simple example to MainView class:

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

Enjoy!

