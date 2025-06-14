# Person Hierarchy Design - Java

## Class Structure

### Person
- Driver
- Manager

### Attributes
- name
- age
- dob
- Address

### Behaviour
- doEat
- doSleep
- doWork

---

## Why Not Make Person Abstract with an Abstract doWork()?

The initial design used a concrete Person class with a generic doWork() implementation.  
Here's why an abstract Person class with abstract doWork() is a better approach for this specific scenario, along with best practices:

### 1. Problem with the Initial Design

**Generic doWork() is meaningless**:  
A "generic person" doesn't have a work behavior.  
The problem states a person must be either a Driver or Manager, so forcing subclasses to define doWork() is more logical.

**Prevents misuse**:  
Without abstraction, someone might accidentally instantiate a generic Person (which violates the requirement).

---

### 3. Best Practice: When to Use Abstract Classes/Methods

**Use abstraction when**:  
-> The base class should not be instantiated directly (e.g., Person is too generic).  
-> Subclasses must implement specific behaviors (e.g., doWork() is role-specific).  
-> You want to enforce a contract (subclasses can’t compile without implementing abstract methods).

**Avoid abstraction when**:  
-> The base class has complete/default implementations of all methods.  
-> You need to instantiate the base class directly.

---

### 4. Key Advantages of This Approach

**Enforces Correctness**:  
Subclasses must define doWork(), preventing accidental use of a generic implementation.

**Clarity**:  
Clearly communicates that Person is a conceptual entity, not a concrete role.

**Polymorphism**:  
Still supports `Person driver = new Driver(...);` and `driver.doWork();`

**Future-Proof**:  
Adding new roles (e.g., Engineer) requires implementing doWork().
