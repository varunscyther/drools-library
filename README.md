# drools-library
The library to explain the drools features

This project will explain -
* How programming a rule engine differs from programming using an imperative programming language.
* What is domain expert
* What is rule
* How Drools run its rules

**Rule Engine is like a domain expert** -
* taking in to account all the rules that exist
* and applying the rules to data

**Domain expert build in imperative way has limitation** --
* There might me lot of branches
* Hard to make changes

**Drools is declarative  programming** -
* You specify what you want
* You don't specify how to achieve this step by step

**Drools rule engine works in loop** -
* Finds what rules could fire next
* Picks one out and fire it
* Firing the rule modifies data

**Rule Design Principles**
```
1. Rule idependency - A Rule should not be depend on any other specific rule.
   The rule should depend on the data instead.

2. Rule atomicity - Rule should be designed as simple as possible.
   Complicated rule should be split in to several rules until they
   cannot be divided in to anything smaller.
3. Data defines the rule to fire next - While it is possible to impact
   the order of which rules are fired this should remain to special cases only.
```

**Methods vs Rules**
* Rule executed by matching against any data inserted in to the engine.
* Rules can never be called directly.
* Specific instances cannot be passed to the rule.
* Depending  on the matches, a rule may fire once or several times, or not at all.

**When to use Drools ? (Use Drools for systems where ...**
* It is difficult for any one person to full understand without digging in
    + each business rule defines a small component of a complex scenario

* Requirement keep changing over time
    + easier to make changes because no need to analyze whole tree
    + more people can work on rules at the same time
    
* Decision has to be made quickly




