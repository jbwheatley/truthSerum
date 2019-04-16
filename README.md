# benassi

"Push me <br>
And then just touch me <br>
Till I can get my satisfaction" <br> 
    \- *Benny Benassi*

In this project we use the compiler to evaluate the truth of boolean logic formulae expressed at the type-level. The project is currently spilt into two parts: one in which we determine whether a formula containing variables has a satisfying interpretation, and one in which we determine whether a formula expresses a logical tautology. 
Are expression types are built up from following classes: `~[A]` which represents `NOT A` and `&[A, B]` which respresents `A AND B`. All the rest of propositional logic can be defined as type alias' for some combination of these, e.g `type |[A, B] = ~[~[A] & [~B]]`. `True` and `False` are further represented by their own classes. 

# Satisfaction

Consider the formula `A -> B`. This has several satisfying interpretations (an evaluation of its variables to true or false such that the resulting formula is true), as seen in the following truth table: 

| A | B | A -> B |
|---|---|--------|
| T | T | T      |
| T | F | F      |
| F | T | T      |
| F | F | T      |

We define `type X[A, B] = A -> B` and we have a function defined `satisfiable[X]` that will only compile if it finds a satisfying interpretation (which in this case we know it can!). for `type Y[A] = A & ~[A]` we know that this has **no** satisfying interpretations, and hence `satisfiable[Y]` will **NOT** compile!
  
  # Tautologies
  
If a formula is true under all possible interpretations of its variables, then it is known as a tautology. We further provide the means to determine whether a formula is a tautology at compilation: i.e. `tautology[X]` that only compiles if X represents a logical tautology, and does not compile if even one interpretation resolves to false. For example consider the simplest tautological formula, the Law of Excluded Middle: `type X[A] = A | ~[A]`. `tautology[X]` will compile, whereas `tautology[(type Y[A, B] = A & B)]` will not compile, as the formula doesn't evaluate to true when, for example, `A` is true and `B` is false. 
  
