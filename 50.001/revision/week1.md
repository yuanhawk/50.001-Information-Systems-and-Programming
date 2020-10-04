# ISTD Info to Sys week1
*Adapted from Emrys-Hong programming notes and my personal notes*

```
Python
print('Bye!')

Java
package MainMethod; // Package Statement

public class MainMethod { // Class Declaration
	
	public static void main(String[] args) { // Main method declaration
		System.out.println("Bye!"); //Oops don't use single quotes
		System.out.println(); //To print sysout, use syso, Ctrl+Space
	}

}
```

Moving on from Python classes in Freshmore to Java classes in Sophomore, do start by looking out for the differences and conventions
in Python and Java.

Java uses static types, while Python is dynamic
Java is a compiled lang, Python in an interpreted lang

There are more, but it will explained throughout the notes.

## Syntax
```
Python
variable_name = ;

type variableName = ;
variableName = value; - assignment
```

Python interpreter does not require you to specify the type, but Java requires you to declare the type of the variable outfront.<br>
Python uses snake_case 'variable_name' and Java uses camelCase "variableName"<br>
Assignment of variables are the same

```
Java
int, double
int quantity = 0; Reference it as integer
int maxQuantity = 100;
quantity = maxQuantity;  value of quantity is assigned to maxQuantity, which is 100
```

Capitalise String keyword because it is the name of a class, not a primitive data type, string is an array of chars

String formatting
```
"new " + "string" - Concatenation of string
\n - New line, \t - tab, \r - Return, \" - Backslash
```

#### Java most widely used packages<br>
java.lang - Fundamental class for primitive data types & strings<br>
java.util - Utility class, includingthose for getting input fr console<br>
java.text - Classes that handle text, format numbers and dates<br>

#### Common class<br>
java.lang.String<br>
java.lang.Integer<br>
java.lang.Double<br>
java.util.Scanner<br>
java.text.NumberFormat<br>

Relational Operators
```
==
!=
>
<
>=
<=
```
Logical Operators
```
&& And
|| Or
! Not
```


#### Casting Methods


## static method
static fields / static methods belong to the class, aka class fields / class methods

#### When to use static method:

static method or variable is shared by the entire class instead of a instance.

instance method can access both static variable and instance variable.

static method can only access both static variable.

static method cannot be overriden.

if you changes static variable or method in the class, it changes all the information in the instance as well.

## pointers( variables)
to the primitive type can be "changed"

to the reference type cannot be overriden.

## passing variable functions
the previous variable will be overriden by the new arg in the functions.

we can use ```this.variable``` to reference the variable in the class.

(args passed in the function is called a heap.)

## constructor
if the arg constructor is provided. then the no arg constructor will not be provided.

so it is good to have the no arg constructor.

Abstract classes also have pointers.


## data fields
Design principles for easier maintainence and protect data:
1. Minimize the accessibility of classes and members
2. In public classes, use accessor methods, not public attributes

![visibility modifiers](https://github.com/Emrys-Hong/programming_notes/blob/master/java/Info_to_Sys_notes/VisibilityModifiers.png)

## passing object to methods
if passing "myAnimal" created by ```Animal myAnimal = new Animal();``` as an argument to a method, the myAnimal as a reference type will be stored in the stack.

the new Animal() will be store in the heap, which is dynamic.

so when changing values in the pointer will not change new Animal class.