# drools-library
The library to explain the drools features.

**Technologies**
* Drools - https://www.drools.org
* Java 8
* Cucumber, Spring 5 and Maven

This project will explain -
* How programming a rule engine differs from programming using an imperative programming language.
* What is domain expert.
* What is rule.
* How Drools run its rules.

**Rule Engine is like a domain expert** -
* taking in to account all the rules that exist.
* and applying the rules to data.

**Domain expert build in imperative way has limitation** --
* There might me lot of branches.
* Hard to make changes.

**Drools is declarative  programming** -
* You specify what you want.
* You don't specify how to achieve this step by step.

**Drools rule engine works in loop** -
* Finds what rules could fire next.
* Picks one out and fire it.
* Firing the rule modifies data.

### Rule Design Principles
```
1. Rule idependency - A Rule should not be depend on any other specific rule.
   The rule should depend on the data instead.

2. Rule atomicity - Rule should be designed as simple as possible.
   Complicated rule should be split in to several rules until they
   cannot be divided in to anything smaller.
3. Data defines the rule to fire next - While it is possible to impact
   the order of which rules are fired this should remain to special cases only.
```

### Methods vs Rules
* Rule executed by matching against any data inserted in to the engine.
* Rules can never be called directly.
* Specific instances cannot be passed to the rule.
* Depending  on the matches, a rule may fire once or several times, or not at all.

### When to use Drools ? (Use Drools for systems where ....)
* It is difficult for any one person to full understand without digging in
    + each business rule defines a small component of a complex scenario.

* Requirement keep changing over time
    + easier to make changes because no need to analyze whole tree.
    + more people can work on rules at the same time.
    
* Decision has to be made quickly.

### Stateless Session
* Common use case for stateless session.
    * Validation
    * Calculation
    * Routing and Filtering
* You need to explicitly state that session is stateless.
* A good practice is to write rules as short as possible.
    * Split longer rules n smaller ones whenever you can.
* You can assign variables to matched objects and fields.
* It is good practice starting a variable name with $-sign.
* You can change the state of the objects during session.
* You cannot make Drools aware of changed state of an object.


### Stateful Session
**If you modify an object in a stateful session then all affected rules automatically re-checked and re-run if needed.**

Stateful sessions are used a lot for:
* Monitoring
* Diagnostics
* Logistics
* Compliance

You need stateful sessions if you use inference - this is one rule setting information and other rules consume.
Usage of modify keyword - 
* Use it to make Drools aware of the changes.
* Other rules are automatically re-run if needed.
* It takes an object as parameter. 
* In the body of modify you can call several methods of the objects.

Call dispose() method in the end of Drools session to avoid memory leaks. 

### Inference
As per the dictionary, inference means, "An assumption or conclusion that is rationally and logically made, based on the given facts or circumstances."
An inference is based off of facts, so the reasoning for the conclusion is often logical.

Refer - https://docs.jboss.org/drools/release/7.36.0.Final/drools-docs/html_single/index.html#inference-and-truth-maintenance_decision-engine

The Drools engine makes inferences based on existing knowledge and performs the actions based on the inferred information.


### Cross Product

* Often one rule needs to look at combination of different objects.
    * Like passport needs to be examined with together with a visa application.
* This is very similar to SQL JOIN -
    * SQL JOIN is used when selecting from multiple tables.
    * For joining, we have to describe how tables are related. 
* In Drools join is called cross products.
    * Pattern matching looks if combination of objects exists.
    * We have to write in the when part how objects refer to each other.
    
**Pattern matching and cross products**
* Pattern matching in Drools is like selecting in SQL.
* Cross products is like joining in SQL.
* When matching pair of objects (or more), write down how objects are connected with each other.
* If you set property to a value at THEN side then update WHEN side to check that property is not already with this value.

### Adding new facts & setting execution order
Drools can insert new facts in the session.
* Inserting new facts is another form of inference - creating new knowledge.

Rule execution order can be controlled using either of:
* salience
* agenda-group

```` 
1. You can set expiration date for any Rule.
2. You can insert new facts in to session by Drools rule.
   - You can get all the facts from session to Java code.
3. When two or more rules can trigger - this is called conflict and how Drools solves it's conflict resolution.
4. You can control order using salience or agenda group.
   - Rule with largest salience value is triggered first.
   - Agenda groups are pushed in to stack by setting focus to them.
   - Agenda groups are popped from stack by Drools.
   - If you use salience and agenda group at same time - salience only has effect within particular agenda group.
5. If two or more rules belong to same activation group the maximum one Rule is run and only once.
````

### Logical facts
* Insert new objects using "insertLogical()"
    * If we insert object logically and later same expression becomes false then the object is deleted.
* Use "not()" if you need to match fact doesn't exist.
* Reduce the number of Rules needed by matching more than two objects at once.

#### insertLogical()
* Insert a fact in to session.
* Existence of the inserted fact is tied with truth of when side of the rule that inserted a fact.
* If the expression on when side becomes false the fact is removed.

#### Fact Objects
* Prefer them over changing objects.

#### Use Drools event listeners for debugging
* DebugAgendaEventListener
* RuleRuntimeEventListener

### Check facts exist
* exists -  Use to check that at least one facts exists.
* forall - evaluates to true when
         * all facts that match the first pattern.
         * also matches all the remaining pattern.
* Using forall to extract a fact from a group.
    * We can extract fact with a smallest/largest value
    
### Working with group of facts
* If you want to check that in the session at least one fact exists - use exists.
* If you want to test that a specific expression is valid for all - use forall.
* You can also use forall to find items with lowest/highest value from collection.
    


         




    
 





