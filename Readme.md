@Autowired  :- This Annotation helps us solved the dependency injection with this annotation spring will automatically 
creates the required object.

@Controller, Service, Repository :- This Annotation helps spring to create objected whenever it required as dependency.

@Getter, Setter :- Lombok framework contains this framework helps us to save time and effort in writing the getter setter methods.

@Entity :- This Annotation helps spring to create table for the decorated class with entity annotation.

@Enumerated(EnumType.ORDINAL) :- this annotation in modal helps database to create field of enum in table and field contains a number in which enum is defined.

@ElementCollection :- Element collection helps spring to create the field for enum and store the list of enums with corresponding id.

@MappedSuperclass :- This annotation will help the base class to add the Attribute of super class in his table.

@Id and @GeneratedValue(strategy = GenerationType.IDENTITY) :- This Annotation helps spring in modal to mark field as a primary key.

@OneToOne :- This annotation will show that their is one to one relation between two tables.

@ManyToOne :- This annotation will show that their is Many to one relation between two tables.

@OneToMany(mappedBy = "corresponding class contains field name of defined class") :- This annotation will show that this is one to many relation between two tables.
