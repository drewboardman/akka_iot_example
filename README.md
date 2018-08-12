Intro
----------
* Using Akka instead of just creating actors solves a lot of boilerplate
  infrastucture stuff
  - includes the actor lifecycle and failure handling (let it crash)

Hierarchy
--------------
* using `context.actorOf()` or `system.actorOf()` guarantees that an actor
  always belongs to a parent
  - *parent actor* And *child actor*
* actor references are URLs
    - for example `akka://testSystem/user/first-actor/second-actor#-1544706041`
    - instead of `testSystem`, it could be a hostname for actors that are scaled across multiple systems

Lifecycle
-------------
* you should stop actors with a `PoisonPill`
  - the bad way to stop them is with `context.stop(actorRef)`

Questions
-------------
* What is the difference between `context.actorOf()` and `system.actorOf()`?
  - So the `system` creates an actor that belong to the *parent* guardian
  - the `context` creates an actor that just belongs to another actor
* Where is all the routing done for scaled-out actors? Like who keeps track of what hostnames own what actors? Does it do a search or something?
